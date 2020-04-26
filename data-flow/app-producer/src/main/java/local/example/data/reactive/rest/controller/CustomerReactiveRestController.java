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

import local.example.data.assembler.CustomerRepresentationModelAssembler;
import local.example.data.entity.Customer;
import local.example.data.exception.CustomerNotFoundException;
import local.example.data.repository.CustomerRestRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RepositoryRestController
@RequestMapping(path = "/api/reactive/customers")
public class CustomerReactiveRestController {

	@Autowired
	CustomerRestRepository customerRestRepository;
	
	@Autowired
	CustomerRepresentationModelAssembler customerRepresentationModelAssembler;

	@GetMapping(path = "/{id}")
	public ResponseEntity<Mono<EntityModel<Customer>>> read(@PathVariable Long id) 
			throws URISyntaxException {
		Customer customer = customerRestRepository.findById(id)
				.orElseThrow(() -> new CustomerNotFoundException(id));
		Mono<EntityModel<Customer>> monoOfCustomer;
		monoOfCustomer = customerRepresentationModelAssembler.toMono(customer);
		return new ResponseEntity<Mono<EntityModel<Customer>>>(monoOfCustomer, HttpStatus.OK);
	}
	
	@GetMapping(path = "/nicknames/{nickname}")
	public ResponseEntity<?> readByNickname(@PathVariable String nickname) 
			throws URISyntaxException {
		var customers = customerRestRepository.findByNickname(nickname);
		var fluxOfCustomers = customerRepresentationModelAssembler.toFlux(customers);
		return new ResponseEntity<>(fluxOfCustomers, HttpStatus.OK);
	}

	@GetMapping
	public ResponseEntity<?> readAll() 
			throws URISyntaxException {
		Iterable<Customer> customers = customerRestRepository.findAll();
		Flux<CollectionModel<EntityModel<Customer>>> fluxOfCustomers;
		fluxOfCustomers = customerRepresentationModelAssembler.toFlux(customers);
		return new ResponseEntity<>(fluxOfCustomers, HttpStatus.OK);
	}
}
