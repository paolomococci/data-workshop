/**
 *
 * Copyright 2020 paolo mococci
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * 	   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed following in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package local.example.data.rest.controller;

import java.net.URISyntaxException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import local.example.data.assembler.EmployeeRepresentationModelAssembler;
import local.example.data.entity.Employee;
import local.example.data.exception.EmployeeNotFoundException;
import local.example.data.repository.EmployeeRestRepository;

@RepositoryRestController
@RequestMapping(path = "/api/employees")
public class EmployeeRestController {

	@Autowired
	EmployeeRestRepository employeeRestRepository;

	@Autowired
	EmployeeRepresentationModelAssembler employeeRepresentationModelAssembler;

	@PostMapping
	public ResponseEntity<?> create(@RequestBody Employee employee) 
			throws URISyntaxException {
		EntityModel<Employee> entityModelOfEmployee;
		entityModelOfEmployee = employeeRepresentationModelAssembler
				.toModel(employeeRestRepository.save(employee));
		return new ResponseEntity<>(entityModelOfEmployee, HttpStatus.CREATED);
	}

	@GetMapping(path = "/{id}")
	public ResponseEntity<?> read(@PathVariable Long id) 
			throws URISyntaxException {
		Employee employee = employeeRestRepository.findById(id)
				.orElseThrow(() -> new EmployeeNotFoundException(id));
		EntityModel<Employee> entityModelOfEmployee;
		entityModelOfEmployee = employeeRepresentationModelAssembler.toModel(employee);
		return new ResponseEntity<>(entityModelOfEmployee, HttpStatus.OK);
	}
	
	@GetMapping(path = "/nicknames/{nickname}")
	public ResponseEntity<?> readByNickname(@PathVariable String nickname) 
			throws URISyntaxException {
		Iterable<Employee> employees = employeeRestRepository.findByNickname(nickname);
		CollectionModel<EntityModel<Employee>> collectionModelOfEmployees;
		collectionModelOfEmployees = employeeRepresentationModelAssembler
				.toCollectionModel(employees);
		return new ResponseEntity<>(collectionModelOfEmployees, HttpStatus.OK);
	}

	@GetMapping
	public ResponseEntity<?> readAll() 
			throws URISyntaxException {
		Iterable<Employee> employees = employeeRestRepository.findAll();
		CollectionModel<EntityModel<Employee>> collectionModelOfEmployees;
		collectionModelOfEmployees = employeeRepresentationModelAssembler
				.toCollectionModel(employees);
		return new ResponseEntity<>(collectionModelOfEmployees, HttpStatus.OK);
	}

	@PutMapping(path = "/{id}")
	public ResponseEntity<?> putUpdate(
			@RequestBody Employee employeeUpdated, 
			@PathVariable Long id) 
			throws URISyntaxException {
		 Employee temporaryEntityOfEmployee = employeeRestRepository.findById(id)
				.map(employee -> {
					employee.setNickname(employeeUpdated.getNickname());
					return employeeRestRepository.save(employee);
				}).orElseGet(() -> {
					return employeeRestRepository.save(employeeUpdated);
				});
		EntityModel<Employee> entityModelOfEmployee;
		entityModelOfEmployee = employeeRepresentationModelAssembler
				.toModel(temporaryEntityOfEmployee);
		return new ResponseEntity<>(entityModelOfEmployee, HttpStatus.OK);
	}
	
	@PatchMapping(path = "/{id}")
	public ResponseEntity<?> patchUpdate(
			@RequestBody Employee employeeUpdated, 
			@PathVariable Long id) 
			throws URISyntaxException {
		Employee temporaryEntityOfEmployee = employeeRestRepository.findById(id)
				.map(employee -> {
					if (employeeUpdated.getNickname() != null) {
						employee.setNickname(employeeUpdated.getNickname());
					}
					return employeeRestRepository.save(employee);
				}).orElseGet(() -> {
					return employeeRestRepository.save(employeeUpdated);
				});
		EntityModel<Employee> entityModelOfEmployee;
		entityModelOfEmployee = employeeRepresentationModelAssembler
				.toModel(temporaryEntityOfEmployee);
		return new ResponseEntity<>(entityModelOfEmployee, HttpStatus.OK);
	}

	@DeleteMapping(path = "/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) 
			throws URISyntaxException {
		employeeRestRepository.deleteById(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
