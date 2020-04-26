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

package local.example.data.assembler;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.net.URISyntaxException;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import local.example.data.entity.Employee;
import local.example.data.rest.controller.EmployeeRestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class EmployeeRepresentationModelAssembler 
		implements RepresentationModelAssembler<Employee, EntityModel<Employee>> {

	@Override
	public EntityModel<Employee> toModel(Employee employee) {
		try {
			return new EntityModel<>(employee, 
					linkTo(methodOn(EmployeeRestController.class).read(employee.getId())).withSelfRel(), 
					linkTo(methodOn(EmployeeRestController.class).readAll()).withRel("employees"));
		} catch (URISyntaxException uriException) {
			uriException.printStackTrace();
		}
		return new EntityModel<>(new Employee());
	}

	@Override
	public CollectionModel<EntityModel<Employee>> toCollectionModel(
			Iterable<? extends Employee> employees) {
		return RepresentationModelAssembler.super.toCollectionModel(employees);
	}

	public Mono<EntityModel<Employee>> toMono(Employee employee) 
			throws URISyntaxException {
		EntityModel<Employee> entityModelOfEmployee;
		entityModelOfEmployee = new EntityModel<>(employee, 
				linkTo(methodOn(EmployeeRestController.class).read(employee.getId())).withSelfRel(), 
				linkTo(methodOn(EmployeeRestController.class).readAll()).withRel("employees"));
		Mono<EntityModel<Employee>> monoOfEmployee = Mono.justOrEmpty(entityModelOfEmployee);
		return monoOfEmployee;
	}

	public Flux<CollectionModel<EntityModel<Employee>>> toFlux(
			Iterable<? extends Employee> employees) {
		var collectionModelOfEmployees = RepresentationModelAssembler.super.toCollectionModel(employees);
		var fluxOfEmployees = Flux.just(collectionModelOfEmployees);
		return fluxOfEmployees;
	}
}
