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

package local.example.data.model.assembler;

import java.net.URISyntaxException;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import local.example.data.model.controller.SampleRestController;
import local.example.data.model.entity.SampleEntity;

@Component
public class SampleRepresentationModelAssembler 
		implements RepresentationModelAssembler<SampleEntity, EntityModel<SampleEntity>> {

	@Override
	public EntityModel<SampleEntity> toModel(SampleEntity sample) {
		try {
		EntityModel<SampleEntity> entityModelOfSample = EntityModel.of(sample, 
				linkTo(methodOn(SampleRestController.class).read(sample.getId())).withSelfRel(), 
				linkTo(methodOn(SampleRestController.class).readAll()).withRel("samples"));
		return entityModelOfSample;
	} catch (URISyntaxException uriException) {
		uriException.printStackTrace();
	}
	return EntityModel.of(new SampleEntity());
	}

	@Override
	public CollectionModel<EntityModel<SampleEntity>> toCollectionModel(
			Iterable<? extends SampleEntity> samples) {
		return RepresentationModelAssembler.super.toCollectionModel(samples);
	}
}
