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

package local.example.data.rest.repository;

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

import local.example.data.assembler.EndUserRepresentationModelAssembler;
import local.example.data.entity.EndUser;
import local.example.data.exception.EndUserNotFoundException;

@RepositoryRestController
@RequestMapping(path = "/rest/endUsers")
public class EndUserRestController {

	@Autowired
	EndUserRestRepository endUserRestRepository;

	@Autowired
	EndUserRepresentationModelAssembler endUserRepresentationModelAssembler;

	@PostMapping
	public ResponseEntity<?> create(@RequestBody EndUser endUser) 
			throws URISyntaxException {
		EntityModel<EndUser> entityModelOfEndUser;
		entityModelOfEndUser = endUserRepresentationModelAssembler
				.toModel(endUserRestRepository.save(endUser));
		return new ResponseEntity<>(entityModelOfEndUser, HttpStatus.CREATED);
	}

	@GetMapping(path = "/{id}")
	public ResponseEntity<?> read(@PathVariable Long id) 
			throws URISyntaxException {
		EndUser endUser = endUserRestRepository.findById(id)
				.orElseThrow(() -> new EndUserNotFoundException(id));
		EntityModel<EndUser> entityModelOfEndUser;
		entityModelOfEndUser = endUserRepresentationModelAssembler.toModel(endUser);
		return new ResponseEntity<>(entityModelOfEndUser, HttpStatus.OK);
	}
	
	@GetMapping(path = "/names/{name}")
	public ResponseEntity<?> readByName(@PathVariable String name) 
			throws URISyntaxException {
		Iterable<EndUser> endUsers = endUserRestRepository.findByName(name);
		CollectionModel<EntityModel<EndUser>> collectionModelOfEndUsers;
		collectionModelOfEndUsers = endUserRepresentationModelAssembler
				.toCollectionModel(endUsers);
		return new ResponseEntity<>(collectionModelOfEndUsers, HttpStatus.OK);
	}
	
	@GetMapping(path = "/surnames/{surname}")
	public ResponseEntity<?> readBySurname(@PathVariable String surname) 
			throws URISyntaxException {
		Iterable<EndUser> endUsers = endUserRestRepository.findBySurname(surname);
		CollectionModel<EntityModel<EndUser>> collectionModelOfEndUsers;
		collectionModelOfEndUsers = endUserRepresentationModelAssembler
				.toCollectionModel(endUsers);
		return new ResponseEntity<>(collectionModelOfEndUsers, HttpStatus.OK);
	}
	
	@GetMapping(path = "/usernames/{username}")
	public ResponseEntity<?> readByUsername(@PathVariable String username) 
			throws URISyntaxException {
		Iterable<EndUser> endUsers = endUserRestRepository.findByUsername(username);
		CollectionModel<EntityModel<EndUser>> collectionModelOfEndUsers;
		collectionModelOfEndUsers = endUserRepresentationModelAssembler
				.toCollectionModel(endUsers);
		return new ResponseEntity<>(collectionModelOfEndUsers, HttpStatus.OK);
	}

	@GetMapping
	public ResponseEntity<?> readAll() 
			throws URISyntaxException {
		Iterable<EndUser> endUsers = endUserRestRepository.findAll();
		CollectionModel<EntityModel<EndUser>> collectionModelOfEndUsers;
		collectionModelOfEndUsers = endUserRepresentationModelAssembler
				.toCollectionModel(endUsers);
		return new ResponseEntity<>(collectionModelOfEndUsers, HttpStatus.OK);
	}

	@PutMapping(path = "/{id}")
	public ResponseEntity<?> putUpdate(
			@RequestBody EndUser endUserUpdated, 
			@PathVariable Long id) 
			throws URISyntaxException {
		 EndUser temporaryEntityOfEndUser = endUserRestRepository.findById(id)
				.map(endUser -> {
					endUser.setName(endUserUpdated.getName());
					endUser.setSurname(endUserUpdated.getSurname());
					endUser.setUsername(endUserUpdated.getUsername());
					return endUserRestRepository.save(endUser);
				}).orElseGet(() -> {
					return endUserRestRepository.save(endUserUpdated);
				});
		EntityModel<EndUser> entityModelOfEndUser;
		entityModelOfEndUser = endUserRepresentationModelAssembler
				.toModel(temporaryEntityOfEndUser);
		return new ResponseEntity<>(entityModelOfEndUser, HttpStatus.OK);
	}
	
	@PatchMapping(path = "/{id}")
	public ResponseEntity<?> patchUpdate(
			@RequestBody EndUser endUserUpdated, 
			@PathVariable Long id) 
			throws URISyntaxException {
		EndUser temporaryEntityOfEndUser = endUserRestRepository.findById(id)
				.map(endUser -> {
					if (endUserUpdated.getName() != null) {
						endUser.setName(endUserUpdated.getName());
					}
					if (endUserUpdated.getSurname() != null) {
						endUser.setSurname(endUserUpdated.getSurname());
					}
					if (endUserUpdated.getUsername() != null) {
						endUser.setUsername(endUserUpdated.getUsername());
					}
					return endUserRestRepository.save(endUser);
				}).orElseGet(() -> {
					return endUserRestRepository.save(endUserUpdated);
				});
		EntityModel<EndUser> entityModelOfEndUser;
		entityModelOfEndUser = endUserRepresentationModelAssembler
				.toModel(temporaryEntityOfEndUser);
		return new ResponseEntity<>(entityModelOfEndUser, HttpStatus.OK);
	}

	@DeleteMapping(path = "/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) 
			throws URISyntaxException {
		endUserRestRepository.deleteById(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
