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

import local.example.data.entity.Job;
import local.example.data.rest.controller.JobRestController;

@Component
public class JobRepresentationModelAssembler 
		implements RepresentationModelAssembler<Job, EntityModel<Job>> {

	@Override
	public EntityModel<Job> toModel(Job job) {
		try {
			return new EntityModel<>(job, 
					linkTo(methodOn(JobRestController.class).read(job.getId())).withSelfRel(), 
					linkTo(methodOn(JobRestController.class).readAll()).withRel("jobs"));
		} catch (URISyntaxException uriException) {
			uriException.printStackTrace();
		}
		return new EntityModel<>(new Job());
	}

	@Override
	public CollectionModel<EntityModel<Job>> toCollectionModel(
			Iterable<? extends Job> jobs) {
		return RepresentationModelAssembler.super.toCollectionModel(jobs);
	}
}
