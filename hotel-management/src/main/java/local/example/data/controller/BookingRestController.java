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

import local.example.data.assembler.BookingRepresentationModelAssembler;
import local.example.data.domain.Booking;
import local.example.data.service.BookingService;

@RepositoryRestController
@RequestMapping("/api/bookings")
public class BookingRestController {
	
	@Autowired
	BookingService bookingService;
	
	@Autowired
	BookingRepresentationModelAssembler bookingRepresentationModelAssembler;

	@PostMapping
	public ResponseEntity<?> create(@RequestBody Booking booking) 
			throws URISyntaxException {
		  EntityModel<Booking> entityModelOfBooking =
				  bookingRepresentationModelAssembler
				  		.toModel(bookingService.createBooking(booking));
		return new ResponseEntity<>(entityModelOfBooking, HttpStatus.CREATED);
	}
	
	@GetMapping(path = "/{id}")
	public ResponseEntity<?> read(@PathVariable ULong id) {
		Booking booking = bookingService.readBooking(id);
		EntityModel<Booking> entityModelOfBooking = 
				bookingRepresentationModelAssembler.toModel(booking);
		return new ResponseEntity<>(entityModelOfBooking, HttpStatus.OK);
	}
	
	@GetMapping
	public ResponseEntity<?> readAll() {
		Iterable<Booking> reservations = bookingService.readAllReservations();
		CollectionModel<EntityModel<Booking>> collectionModelOfReservations = 
				bookingRepresentationModelAssembler.toCollectionModel(reservations);
		return new ResponseEntity<>(collectionModelOfReservations, HttpStatus.OK);
	}
	
	@PutMapping(path = "/{id}")
	public ResponseEntity<?> update(@RequestBody Booking booking, @PathVariable ULong id) 
			throws URISyntaxException {
		bookingService.updateBooking(id, booking);
		var bookingUpdated = bookingService.readBooking(id);
		  EntityModel<Booking> entityModelOfBooking =
				  bookingRepresentationModelAssembler
				  		.toModel(bookingService.createBooking(bookingUpdated));
		return new ResponseEntity<>(entityModelOfBooking, HttpStatus.OK);
	}
	
	@DeleteMapping(path = "/{id}")
	public ResponseEntity<?> delete(@PathVariable ULong id) 
			throws URISyntaxException {
		bookingService.deleteBooking(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
