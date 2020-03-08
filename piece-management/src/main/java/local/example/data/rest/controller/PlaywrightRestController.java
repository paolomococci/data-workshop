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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import local.example.data.assembler.PlaywrightRepresentationModelAssembler;
import local.example.data.entity.Playwright;
import local.example.data.exception.PlaywrightNotFoundException;
import local.example.data.repository.PlaywrightRepository;

@RepositoryRestController
@RequestMapping(path = "/api/playwrights")
public class PlaywrightRestController {

	@Autowired
	PlaywrightRepository playwrightRepository;
	
	@Autowired
	PlaywrightRepresentationModelAssembler playwrightRepresentationModelAssembler;
	
	@PostMapping
	public ResponseEntity<?> create(@RequestBody Playwright playwright) 
			throws URISyntaxException {
		EntityModel<Playwright> entityModelOfPlaywright;
		entityModelOfPlaywright = playwrightRepresentationModelAssembler
				.toModel(playwrightRepository.save(playwright));
		return new ResponseEntity<>(entityModelOfPlaywright, HttpStatus.CREATED);
	}
	
	@GetMapping(path = "/{id}")
	public ResponseEntity<?> read(@PathVariable Long id) 
			throws URISyntaxException {
		var playwright = playwrightRepository.findById(id)
				.orElseThrow(() -> new PlaywrightNotFoundException(id));
		EntityModel<Playwright> entityModelOfPlaywright;
		entityModelOfPlaywright = playwrightRepresentationModelAssembler.toModel(playwright);
		return new ResponseEntity<>(entityModelOfPlaywright, HttpStatus.OK);
	}
	
	@GetMapping(path = "/nicknames/{nickname}")
	public ResponseEntity<?> readByNickname(@PathVariable String nickname) 
			throws URISyntaxException {
		Iterable<Playwright> playwrights = playwrightRepository.findByNickname(nickname);
		CollectionModel<EntityModel<Playwright>> collectionModelOfPlaywrights;
		collectionModelOfPlaywrights = playwrightRepresentationModelAssembler
				.toCollectionModel(playwrights);
		return new ResponseEntity<>(collectionModelOfPlaywrights, HttpStatus.OK);
	}
	
	@GetMapping
	public ResponseEntity<?> readAll() 
			throws URISyntaxException {
		Iterable<Playwright> playwrights = playwrightRepository.findAll();
		CollectionModel<EntityModel<Playwright>> collectionModelOfPlaywrights;
		collectionModelOfPlaywrights = playwrightRepresentationModelAssembler
				.toCollectionModel(playwrights);
		return new ResponseEntity<>(collectionModelOfPlaywrights, HttpStatus.OK);
	}
	
	@PutMapping(path = "/{id}")
	public ResponseEntity<?> update(
			@RequestBody Playwright playwrightUpdated, 
			@PathVariable Long id) 
			throws URISyntaxException {
		var temporaryEntityOfPlaywright = playwrightRepository.findById(id)
				.map(playwright -> {
					playwright.setNickname(playwrightUpdated.getNickname());
					return playwrightRepository.save(playwright);
				})
				.orElseGet(() -> {
					return playwrightRepository.save(playwrightUpdated);
				});
		EntityModel<Playwright> entityModelOfPlaywright;
		entityModelOfPlaywright = playwrightRepresentationModelAssembler
				.toModel(temporaryEntityOfPlaywright);
		return new ResponseEntity<>(entityModelOfPlaywright, HttpStatus.OK);
	}
	
	@DeleteMapping(path = "/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) 
			throws URISyntaxException {
		playwrightRepository.deleteById(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
