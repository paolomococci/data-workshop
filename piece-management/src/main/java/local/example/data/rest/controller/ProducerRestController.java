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

import local.example.data.assembler.ProducerRepresentationModelAssembler;
import local.example.data.entity.Producer;
import local.example.data.exception.ProducerNotFoundException;
import local.example.data.repository.ProducerRepository;

@RepositoryRestController
@RequestMapping(path = "/api/producers")
public class ProducerRestController {

	@Autowired
	ProducerRepository producerRepository;
	
	@Autowired
	ProducerRepresentationModelAssembler producerRepresentationModelAssembler;
	
	@PostMapping
	public ResponseEntity<?> create(@RequestBody Producer producer) 
			throws URISyntaxException {
		EntityModel<Producer> entityModelOfProducer;
		entityModelOfProducer = producerRepresentationModelAssembler
				.toModel(producerRepository.save(producer));
		return new ResponseEntity<>(entityModelOfProducer, HttpStatus.CREATED);
	}
	
	@GetMapping(path = "/{id}")
	public ResponseEntity<?> read(@PathVariable Long id) 
			throws URISyntaxException {
		var producer = producerRepository.findById(id)
				.orElseThrow(() -> new ProducerNotFoundException(id));
		EntityModel<Producer> entityModelOfProducer;
		entityModelOfProducer = producerRepresentationModelAssembler.toModel(producer);
		return new ResponseEntity<>(entityModelOfProducer, HttpStatus.OK);
	}
	
	@GetMapping(path = "/nicknames/{nickname}")
	public ResponseEntity<?> readByNickname(@PathVariable String nickname) 
			throws URISyntaxException {
		Iterable<Producer> producers = producerRepository.findByNickname(nickname);
		CollectionModel<EntityModel<Producer>> collectionModelOfProducers;
		collectionModelOfProducers = producerRepresentationModelAssembler
				.toCollectionModel(producers);
		return new ResponseEntity<>(collectionModelOfProducers, HttpStatus.OK);
	}
	
	@GetMapping
	public ResponseEntity<?> readAll() 
			throws URISyntaxException {
		Iterable<Producer> producers = producerRepository.findAll();
		CollectionModel<EntityModel<Producer>> collectionModelOfProducers;
		collectionModelOfProducers = producerRepresentationModelAssembler
				.toCollectionModel(producers);
		return new ResponseEntity<>(collectionModelOfProducers, HttpStatus.OK);
	}
	
	@PutMapping(path = "/{id}")
	public ResponseEntity<?> putUpdate(
			@RequestBody Producer producerUpdated, 
			@PathVariable Long id) 
			throws URISyntaxException {
		var temporaryEntityOfProducer = producerRepository.findById(id)
				.map(producer -> {
					producer.setNickname(producerUpdated.getNickname());
					return producerRepository.save(producer);
				})
				.orElseGet(() -> {
					return producerRepository.save(producerUpdated);
				});
		EntityModel<Producer> entityModelOfProducer;
		entityModelOfProducer = producerRepresentationModelAssembler
				.toModel(temporaryEntityOfProducer);
		return new ResponseEntity<>(entityModelOfProducer, HttpStatus.OK);
	}
	
	@PatchMapping(path = "/{id}")
	public ResponseEntity<?> patchUpdate(
			@RequestBody Producer producerUpdated, 
			@PathVariable Long id) 
			throws URISyntaxException {
		var temporaryEntityOfProducer = producerRepository.findById(id)
				.map(producer -> {
					if (producerUpdated.getNickname() != null) {
						producer.setNickname(producerUpdated.getNickname());
					}
					return producerRepository.save(producer);
				})
				.orElseGet(() -> {
					return producerRepository.save(producerUpdated);
				});
		EntityModel<Producer> entityModelOfProducer;
		entityModelOfProducer = producerRepresentationModelAssembler
				.toModel(temporaryEntityOfProducer);
		return new ResponseEntity<>(entityModelOfProducer, HttpStatus.OK);
	}
	
	@DeleteMapping(path = "/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) 
			throws URISyntaxException {
		producerRepository.deleteById(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
