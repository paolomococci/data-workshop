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

package local.example.data.assembler;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import local.example.data.controller.CustomerRestController;
import local.example.data.domain.Booking;

@Component
public class BookingRepresentationModelAssembler 
		implements RepresentationModelAssembler<Booking, EntityModel<Booking>> {

	@Override
	public EntityModel<Booking> toModel(Booking booking) {
		return new EntityModel<>(booking, 
				linkTo(methodOn(CustomerRestController.class).read(booking.getId())).withSelfRel(), 
				linkTo(methodOn(CustomerRestController.class).readAll()).withRel("bookings"));
	}

	@Override
	public CollectionModel<EntityModel<Booking>> toCollectionModel(
			Iterable<? extends Booking> bookings) {
		return RepresentationModelAssembler.super.toCollectionModel(bookings);
	}
}
