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

import local.example.data.entity.Customer;
import local.example.data.rest.controller.CustomerRestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class CustomerRepresentationModelAssembler 
		implements RepresentationModelAssembler<Customer, EntityModel<Customer>> {

	@Override
	public EntityModel<Customer> toModel(Customer customer) {
		try {
			// TODO, deprecated, to fix
			return new EntityModel<>(customer, 
					linkTo(methodOn(CustomerRestController.class).read(customer.getId())).withSelfRel(), 
					linkTo(methodOn(CustomerRestController.class).readAll()).withRel("customers"));
		} catch (URISyntaxException uriException) {
			uriException.printStackTrace();
		}
		// TODO, deprecated, to fix
		return new EntityModel<>(new Customer());
	}

	@Override
	public CollectionModel<EntityModel<Customer>> toCollectionModel(
			Iterable<? extends Customer> customers) {
		return RepresentationModelAssembler.super.toCollectionModel(customers);
	}

	public Mono<EntityModel<Customer>> toMono(Customer customer) 
			throws URISyntaxException {
		EntityModel<Customer> entityModelOfCustomer;
		// TODO, deprecated, to fix
		entityModelOfCustomer = new EntityModel<>(customer, 
				linkTo(methodOn(CustomerRestController.class).read(customer.getId())).withSelfRel(), 
				linkTo(methodOn(CustomerRestController.class).readAll()).withRel("customers"));
		Mono<EntityModel<Customer>> monoOfCustomer = Mono.justOrEmpty(entityModelOfCustomer);
		return monoOfCustomer;
	}

	public Flux<CollectionModel<EntityModel<Customer>>> toFlux(
			Iterable<? extends Customer> customers) {
		var collectionModelOfCustomers = RepresentationModelAssembler.super.toCollectionModel(customers);
		var fluxOfCustomers = Flux.just(collectionModelOfCustomers);
		return fluxOfCustomers;
	}
}
