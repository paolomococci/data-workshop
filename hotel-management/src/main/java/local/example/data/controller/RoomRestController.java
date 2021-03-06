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

import java.net.URISyntaxException;

import org.jooq.types.ULong;
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

import local.example.data.assembler.RoomRepresentationModelAssembler;
import local.example.data.domain.Room;
import local.example.data.service.RoomService;

@RepositoryRestController
@RequestMapping("/api/rooms")
public class RoomRestController {
	
	@Autowired
	RoomService roomService;
	
	@Autowired
	RoomRepresentationModelAssembler roomRepresentationModelAssembler;

	@PostMapping
	public ResponseEntity<?> create(@RequestBody Room room) 
			throws URISyntaxException {
		  EntityModel<Room> entityModelOfRoom =
				  roomRepresentationModelAssembler
				  		.toModel(roomService.createRoom(room));
		return new ResponseEntity<>(entityModelOfRoom, HttpStatus.CREATED);
	}
	
	@GetMapping(path = "/{id}")
	public ResponseEntity<?> read(@PathVariable ULong id) {
		Room room = roomService.readRoom(id);
		EntityModel<Room> entityModelOfRoom = 
				roomRepresentationModelAssembler.toModel(room);
		return new ResponseEntity<>(entityModelOfRoom, HttpStatus.OK);
	}
	
	@GetMapping
	public ResponseEntity<?> readAll() {
		Iterable<Room> rooms = roomService.readAllRooms();
		CollectionModel<EntityModel<Room>> collectionModelOfRooms = 
				roomRepresentationModelAssembler.toCollectionModel(rooms);
		return new ResponseEntity<>(collectionModelOfRooms, HttpStatus.OK);
	}
	
	@PutMapping(path = "/{id}")
	public ResponseEntity<?> update(@RequestBody Room room, @PathVariable ULong id) 
			throws URISyntaxException {
		roomService.updateRoom(id, room);
		var roomUpdated = roomService.readRoom(id);
		  EntityModel<Room> entityModelOfRoom =
				  roomRepresentationModelAssembler
				  		.toModel(roomService.createRoom(roomUpdated));
		return new ResponseEntity<>(entityModelOfRoom, HttpStatus.OK);
	}
	
	@DeleteMapping(path = "/{id}")
	public ResponseEntity<?> delete(@PathVariable ULong id) 
			throws URISyntaxException {
		roomService.deleteRoom(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
