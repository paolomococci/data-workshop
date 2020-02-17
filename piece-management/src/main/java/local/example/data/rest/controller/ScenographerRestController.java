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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import local.example.data.assembler.ScenographerRepresentationModelAssembler;
import local.example.data.entity.Scenographer;
import local.example.data.repository.ScenographerRepository;

@RepositoryRestController
@RequestMapping(path = "/api/scenographers")
public class ScenographerRestController {

	@Autowired
	ScenographerRepository scenographerRepository;
	
	@Autowired
	ScenographerRepresentationModelAssembler scenographerRepresentationModelAssembler;
	
	@PostMapping
	public ResponseEntity<?> create(@RequestBody Scenographer scenographer) {
		return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
	}
	
	@GetMapping(path = "/{id}")
	public ResponseEntity<?> read(@PathVariable Long id) {
		return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
	}
	
	@GetMapping
	public ResponseEntity<?> readAll() {
		return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
	}
	
	@PutMapping(path = "/{id}")
	public ResponseEntity<?> update(
			@RequestBody Scenographer scenographer, 
			@PathVariable Long id) {
		return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
	}
	
	@DeleteMapping(path = "/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {
		return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
	}
}
