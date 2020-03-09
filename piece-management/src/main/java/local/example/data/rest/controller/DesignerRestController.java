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

import local.example.data.assembler.DesignerRepresentationModelAssembler;
import local.example.data.entity.Designer;
import local.example.data.exception.DesignerNotFoundException;
import local.example.data.repository.DesignerRepository;

@RepositoryRestController
@RequestMapping(path = "/api/designers")
public class DesignerRestController {

	@Autowired
	DesignerRepository designerRepository;
	
	@Autowired
	DesignerRepresentationModelAssembler designerRepresentationModelAssembler;
	
	@PostMapping
	public ResponseEntity<?> create(@RequestBody Designer designer) 
			throws URISyntaxException {
		EntityModel<Designer> entityModelOfDesigner;
		entityModelOfDesigner = designerRepresentationModelAssembler
				.toModel(designerRepository.save(designer));
		return new ResponseEntity<>(entityModelOfDesigner, HttpStatus.CREATED);
	}
	
	@GetMapping(path = "/{id}")
	public ResponseEntity<?> read(@PathVariable Long id) 
			throws URISyntaxException {
		var designer = designerRepository.findById(id)
				.orElseThrow(() -> new DesignerNotFoundException(id));
		EntityModel<Designer> entityModelOfDesigner;
		entityModelOfDesigner = designerRepresentationModelAssembler.toModel(designer);
		return new ResponseEntity<>(entityModelOfDesigner, HttpStatus.OK);
	}
	
	@GetMapping(path = "/nicknames/{nickname}")
	public ResponseEntity<?> readByNickname(@PathVariable String nickname) 
			throws URISyntaxException {
		Iterable<Designer> designers = designerRepository.findByNickname(nickname);
		CollectionModel<EntityModel<Designer>> collectionModelOfDesigners;
		collectionModelOfDesigners = designerRepresentationModelAssembler
				.toCollectionModel(designers);
		return new ResponseEntity<>(collectionModelOfDesigners, HttpStatus.OK);
	}
	
	@GetMapping
	public ResponseEntity<?> readAll() 
			throws URISyntaxException {
		Iterable<Designer> designers = designerRepository.findAll();
		CollectionModel<EntityModel<Designer>> collectionModelOfDesigners;
		collectionModelOfDesigners = designerRepresentationModelAssembler
				.toCollectionModel(designers);
		return new ResponseEntity<>(collectionModelOfDesigners, HttpStatus.OK);
	}
	
	@PutMapping(path = "/{id}")
	public ResponseEntity<?> putUpdate(
			@RequestBody Designer designerUpdated, 
			@PathVariable Long id) 
			throws URISyntaxException {
		var temporaryEntityOfDesigner = designerRepository.findById(id)
				.map(designer -> {
					designer.setNickname(designerUpdated.getNickname());
					return designerRepository.save(designer);
				}).orElseGet(() -> {
					return designerRepository.save(designerUpdated);
				});
		EntityModel<Designer> entityModelOfDesigner;
		entityModelOfDesigner = designerRepresentationModelAssembler
				.toModel(temporaryEntityOfDesigner);
		return new ResponseEntity<>(entityModelOfDesigner, HttpStatus.OK);
	}
	
	@DeleteMapping(path = "/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) 
			throws URISyntaxException {
		designerRepository.deleteById(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
