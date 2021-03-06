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

package local.example.data.model.controller;

import java.net.URISyntaxException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import local.example.data.model.assembler.SampleRepresentationModelAssembler;
import local.example.data.model.entity.SampleEntity;
import local.example.data.model.exception.SampleNotFoundException;
import local.example.data.model.repository.SampleRestRepository;

@Validated
@RepositoryRestController
@RequestMapping(path = "/rest/api/samples")
public class SampleRestController {

	@Autowired
	SampleRestRepository sampleRestRepository;

	@Autowired
	SampleRepresentationModelAssembler sampleRepresentationModelAssembler;

	@PostMapping
	public ResponseEntity<?> create(@RequestBody SampleEntity sample) 
			throws URISyntaxException {
		EntityModel<SampleEntity> entityModelOfSample;
		entityModelOfSample = sampleRepresentationModelAssembler
				.toModel(sampleRestRepository.save(sample));
		return new ResponseEntity<>(entityModelOfSample, HttpStatus.CREATED);
	}

	@GetMapping(path = "/{id}")
	public ResponseEntity<?> read(@PathVariable Long id) 
			throws URISyntaxException {
		SampleEntity sample = sampleRestRepository.findById(id)
				.orElseThrow(() -> new SampleNotFoundException(id));
		EntityModel<SampleEntity> entityModelOfSample;
		entityModelOfSample = sampleRepresentationModelAssembler.toModel(sample);
		return new ResponseEntity<>(entityModelOfSample, HttpStatus.OK);
	}

	@GetMapping
	public ResponseEntity<?> readAll() 
			throws URISyntaxException {
		Iterable<SampleEntity> samples = sampleRestRepository.findAll();
		CollectionModel<EntityModel<SampleEntity>> collectionModelOfSamples;
		collectionModelOfSamples = sampleRepresentationModelAssembler
				.toCollectionModel(samples);
		return new ResponseEntity<>(collectionModelOfSamples, HttpStatus.OK);
	}

	@PutMapping(path = "/{id}")
	public ResponseEntity<?> putUpdate(
			@RequestBody SampleEntity sampleUpdated, 
			@PathVariable Long id) 
			throws URISyntaxException {
		 SampleEntity temporaryEntityOfSample = sampleRestRepository.findById(id)
				.map(sample -> {
					sample.setName(sampleUpdated.getName());
					return sampleRestRepository.save(sample);
				}).orElseGet(() -> {
					return sampleRestRepository.save(sampleUpdated);
				});
		EntityModel<SampleEntity> entityModelOfSample;
		entityModelOfSample = sampleRepresentationModelAssembler
				.toModel(temporaryEntityOfSample);
		return new ResponseEntity<>(entityModelOfSample, HttpStatus.OK);
	}

	@DeleteMapping(path = "/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) 
			throws URISyntaxException {
		sampleRestRepository.deleteById(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
