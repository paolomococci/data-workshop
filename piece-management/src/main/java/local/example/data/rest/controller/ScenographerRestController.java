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

import local.example.data.assembler.ScenographerRepresentationModelAssembler;
import local.example.data.entity.Scenographer;
import local.example.data.exception.ScenographerNotFoundException;
import local.example.data.repository.ScenographerRepository;

@RepositoryRestController
@RequestMapping(path = "/api/scenographers")
public class ScenographerRestController {

	@Autowired
	ScenographerRepository scenographerRepository;
	
	@Autowired
	ScenographerRepresentationModelAssembler scenographerRepresentationModelAssembler;
	
	@PostMapping
	public ResponseEntity<?> create(@RequestBody Scenographer scenographer) 
			throws URISyntaxException {
		EntityModel<Scenographer> entityModelOfScenographer;
		entityModelOfScenographer = scenographerRepresentationModelAssembler
				.toModel(scenographerRepository.save(scenographer));
		return new ResponseEntity<>(entityModelOfScenographer, HttpStatus.CREATED);
	}
	
	@GetMapping(path = "/{id}")
	public ResponseEntity<?> read(@PathVariable Long id) 
			throws URISyntaxException {
		var scenographer = scenographerRepository.findById(id)
				.orElseThrow(() -> new ScenographerNotFoundException(id));
		EntityModel<Scenographer> entityModelOfScenographer;
		entityModelOfScenographer = scenographerRepresentationModelAssembler.toModel(scenographer);
		return new ResponseEntity<>(entityModelOfScenographer, HttpStatus.OK);
	}
	
	@GetMapping(path = "/nicknames/{nickname}")
	public ResponseEntity<?> readByNickname(@PathVariable String nickname) 
			throws URISyntaxException {
		Iterable<Scenographer> scenographers = scenographerRepository.findByNickname(nickname);
		CollectionModel<EntityModel<Scenographer>> collectionModelOfScenographers;
		collectionModelOfScenographers = scenographerRepresentationModelAssembler
				.toCollectionModel(scenographers);
		return new ResponseEntity<>(collectionModelOfScenographers, HttpStatus.OK);
	}
	
	@GetMapping
	public ResponseEntity<?> readAll() 
			throws URISyntaxException {
		Iterable<Scenographer> scenographers = scenographerRepository.findAll();
		CollectionModel<EntityModel<Scenographer>> collectionModelOfScenographers;
		collectionModelOfScenographers = scenographerRepresentationModelAssembler
				.toCollectionModel(scenographers);
		return new ResponseEntity<>(collectionModelOfScenographers, HttpStatus.OK);
	}
	
	@PutMapping(path = "/{id}")
	public ResponseEntity<?> putUpdate(
			@RequestBody Scenographer scenographerUpdated, 
			@PathVariable Long id) 
			throws URISyntaxException {
		var temporaryEntityOfScenographer = scenographerRepository.findById(id)
				.map(scenographer -> {
					scenographer.setNickname(scenographerUpdated.getNickname());
					return scenographerRepository.save(scenographer);
				})
				.orElseGet(() -> {
					return scenographerRepository.save(scenographerUpdated);
				});
		EntityModel<Scenographer> entityModelOfScenographer;
		entityModelOfScenographer = scenographerRepresentationModelAssembler
				.toModel(temporaryEntityOfScenographer);
		return new ResponseEntity<>(entityModelOfScenographer, HttpStatus.OK);
	}
	
	@PatchMapping(path = "/{id}")
	public ResponseEntity<?> patchUpdate(
			@RequestBody Scenographer scenographerUpdated, 
			@PathVariable Long id) 
			throws URISyntaxException {
		var temporaryEntityOfScenographer = scenographerRepository.findById(id)
				.map(scenographer -> {
					if (scenographerUpdated.getNickname() != null) {
						scenographer.setNickname(scenographerUpdated.getNickname());
					}
					return scenographerRepository.save(scenographer);
				})
				.orElseGet(() -> {
					return scenographerRepository.save(scenographerUpdated);
				});
		EntityModel<Scenographer> entityModelOfScenographer;
		entityModelOfScenographer = scenographerRepresentationModelAssembler
				.toModel(temporaryEntityOfScenographer);
		return new ResponseEntity<>(entityModelOfScenographer, HttpStatus.OK);
	}
	
	@DeleteMapping(path = "/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) 
			throws URISyntaxException {
		scenographerRepository.deleteById(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
