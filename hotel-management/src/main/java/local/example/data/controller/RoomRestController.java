/**
 *
 * Copyright 2019 paolo mococci
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

package local.example.data.controller;

import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RepositoryRestController
@RequestMapping("/api/rooms")
public class RoomRestController {

	@PostMapping
	public ResponseEntity<?> create() {
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);		
	}
	
	@GetMapping(path = "/{id}")
	public ResponseEntity<?> read() {
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);		
	}
	
	@GetMapping
	public ResponseEntity<?> readAll() {
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);		
	}
	
	@PutMapping(path = "/{id}")
	public ResponseEntity<?> update() {
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);		
	}
	
	@DeleteMapping(path = "/{id}")
	public ResponseEntity<?> delete() {
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);		
	}
}
