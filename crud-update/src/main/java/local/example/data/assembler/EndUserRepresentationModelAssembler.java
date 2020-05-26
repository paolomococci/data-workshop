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

package local.example.data.assembler;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.net.URISyntaxException;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import local.example.data.entity.EndUser;
import local.example.data.rest.repository.EndUserRestController;

@Component
public class EndUserRepresentationModelAssembler 
		implements RepresentationModelAssembler<EndUser, EntityModel<EndUser>> {

	@Override
	public EntityModel<EndUser> toModel(EndUser endUser) {
		try {
			EntityModel<EndUser> entityModelOfendUser = EntityModel.of(endUser, 
					linkTo(methodOn(EndUserRestController.class).read(endUser.getId())).withSelfRel(), 
					linkTo(methodOn(EndUserRestController.class).readAll()).withRel("endUsers"));
			return entityModelOfendUser;
		} catch (URISyntaxException uriException) {
			uriException.printStackTrace();
		}
		return EntityModel.of(new EndUser());
	}

	@Override
	public CollectionModel<EntityModel<EndUser>> toCollectionModel(
			Iterable<? extends EndUser> endUsers) {
		return RepresentationModelAssembler.super.toCollectionModel(endUsers);
	}
}
