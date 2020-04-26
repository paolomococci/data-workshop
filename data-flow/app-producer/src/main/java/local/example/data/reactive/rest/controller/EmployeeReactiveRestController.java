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

package local.example.data.reactive.rest.controller;

import java.net.URISyntaxException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import local.example.data.assembler.EmployeeRepresentationModelAssembler;
import local.example.data.entity.Employee;
import local.example.data.exception.EmployeeNotFoundException;
import local.example.data.repository.EmployeeRestRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RepositoryRestController
@RequestMapping(path = "/api/reactive/employees")
public class EmployeeReactiveRestController {

	@Autowired
	EmployeeRestRepository employeeRestRepository;

	@Autowired
	EmployeeRepresentationModelAssembler employeeRepresentationModelAssembler;

	@GetMapping(path = "/{id}")
	public ResponseEntity<Mono<EntityModel<Employee>>> read(@PathVariable Long id) 
			throws URISyntaxException {
		Employee employee = employeeRestRepository.findById(id)
				.orElseThrow(() -> new EmployeeNotFoundException(id));
		Mono<EntityModel<Employee>> monoOfEmployee;
		monoOfEmployee = employeeRepresentationModelAssembler.toMono(employee);
		return new ResponseEntity<Mono<EntityModel<Employee>>>(monoOfEmployee, HttpStatus.OK);
	}
	
	@GetMapping(path = "/nicknames/{nickname}")
	public ResponseEntity<?> readByNickname(@PathVariable String nickname) 
			throws URISyntaxException {
		var employees = employeeRestRepository.findByNickname(nickname);
		var fluxOfEmployees = employeeRepresentationModelAssembler.toFlux(employees);
		return new ResponseEntity<>(fluxOfEmployees, HttpStatus.OK);
	}

	@GetMapping
	public ResponseEntity<?> readAll() 
			throws URISyntaxException {
		Iterable<Employee> employees = employeeRestRepository.findAll();
		Flux<CollectionModel<EntityModel<Employee>>> fluxOfEmployees;
		fluxOfEmployees = employeeRepresentationModelAssembler.toFlux(employees);
		return new ResponseEntity<>(fluxOfEmployees, HttpStatus.OK);
	}
}
