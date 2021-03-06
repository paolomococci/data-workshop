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

import local.example.data.assembler.DirectorRepresentationModelAssembler;
import local.example.data.entity.Director;
import local.example.data.exception.DirectorNotFoundException;
import local.example.data.repository.DirectorRepository;

@RepositoryRestController
@RequestMapping(path = "/api/directors")
public class DirectorRestController {

	@Autowired
	DirectorRepository directorRepository;
	
	@Autowired
	DirectorRepresentationModelAssembler directorRepresentationModelAssembler;
	
	@PostMapping
	public ResponseEntity<?> create(@RequestBody Director director) 
			throws URISyntaxException {
		EntityModel<Director> entityModelOfDirector;
		entityModelOfDirector = directorRepresentationModelAssembler
				.toModel(directorRepository.save(director));
		return new ResponseEntity<>(entityModelOfDirector, HttpStatus.CREATED);
	}
	
	@GetMapping(path = "/{id}")
	public ResponseEntity<?> read(@PathVariable Long id) 
			throws URISyntaxException {
		var director = directorRepository.findById(id)
				.orElseThrow(() -> new DirectorNotFoundException(id));
		EntityModel<Director> entityModelOfDirector;
		entityModelOfDirector = directorRepresentationModelAssembler.toModel(director);
		return new ResponseEntity<>(entityModelOfDirector, HttpStatus.OK);
	}
	
	@GetMapping(path = "/nicknames/{nickname}")
	public ResponseEntity<?> readByNickname(@PathVariable String nickname)
			throws URISyntaxException {
		Iterable<Director> directors = directorRepository.findByNickname(nickname);
		CollectionModel<EntityModel<Director>> collectionModelOfDirectors;
		collectionModelOfDirectors = directorRepresentationModelAssembler
				.toCollectionModel(directors);
		return new ResponseEntity<>(collectionModelOfDirectors, HttpStatus.OK);
	}
	
	@GetMapping
	public ResponseEntity<?> readAll() 
			throws URISyntaxException {
		Iterable<Director> directors = directorRepository.findAll();
		CollectionModel<EntityModel<Director>> collectionModelOfDirectors;
		collectionModelOfDirectors = directorRepresentationModelAssembler
				.toCollectionModel(directors);
		return new ResponseEntity<>(collectionModelOfDirectors, HttpStatus.OK);
	}
	
	@PutMapping(path = "/{id}")
	public ResponseEntity<?> putUpdate(
			@RequestBody Director directorUpdated, 
			@PathVariable Long id) 
			throws URISyntaxException {
		var temporaryEntityOfDirector = directorRepository.findById(id)
				.map(director -> {
					director.setNickname(directorUpdated.getNickname());
					return directorRepository.save(director);
				})
				.orElseGet(() -> {
					return directorRepository.save(directorUpdated);
				});
		EntityModel<Director> entityModelOfDirector;
		entityModelOfDirector = directorRepresentationModelAssembler
				.toModel(temporaryEntityOfDirector);
		return new ResponseEntity<>(entityModelOfDirector, HttpStatus.OK);
	}
	
	@PatchMapping(path = "/{id}")
	public ResponseEntity<?> patchUpdate(
			@RequestBody Director directorUpdated, 
			@PathVariable Long id) 
			throws URISyntaxException {
		var temporaryEntityOfDirector = directorRepository.findById(id)
				.map(director -> {
					if (directorUpdated.getNickname() != null) {
						director.setNickname(directorUpdated.getNickname());
					}
					return directorRepository.save(director);
				})
				.orElseGet(() -> {
					return directorRepository.save(directorUpdated);
				});
		EntityModel<Director> entityModelOfDirector;
		entityModelOfDirector = directorRepresentationModelAssembler
				.toModel(temporaryEntityOfDirector);
		return new ResponseEntity<>(entityModelOfDirector, HttpStatus.OK);
	}
	
	@DeleteMapping(path = "/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) 
			throws URISyntaxException {
		directorRepository.deleteById(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
