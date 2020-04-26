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

package local.example.data.reactive.rest.controller;

import java.net.URISyntaxException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import local.example.data.assembler.JobRepresentationModelAssembler;
import local.example.data.entity.Job;
import local.example.data.exception.JobNotFoundException;
import local.example.data.repository.JobRestRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RepositoryRestController
@RequestMapping(path = "/api/reactive/jobs")
public class JobReactiveRestController {

	@Autowired
	JobRestRepository jobRestRepository;

	@Autowired
	JobRepresentationModelAssembler jobRepresentationModelAssembler;

	@GetMapping(path = "/{id}")
	public ResponseEntity<Mono<EntityModel<Job>>> read(@PathVariable Long id) 
			throws URISyntaxException {
		Job job = jobRestRepository.findById(id)
				.orElseThrow(() -> new JobNotFoundException(id));
		Mono<EntityModel<Job>> monoOfJob;
		monoOfJob = jobRepresentationModelAssembler.toMono(job);
		return new ResponseEntity<Mono<EntityModel<Job>>>(monoOfJob, HttpStatus.OK);
	}
	
	@GetMapping(path = "/codes/{code}")
	public ResponseEntity<?> readByNickname(@PathVariable String code) 
			throws URISyntaxException {
		var jobs = jobRestRepository.findByCode(code);
		var fluxOfJobs = jobRepresentationModelAssembler.toFlux(jobs);
		return new ResponseEntity<>(fluxOfJobs, HttpStatus.OK);
	}

	@GetMapping
	public ResponseEntity<?> readAll() 
			throws URISyntaxException {
		Iterable<Job> jobs = jobRestRepository.findAll();
		Flux<CollectionModel<EntityModel<Job>>> fluxOfJobs;
		fluxOfJobs = jobRepresentationModelAssembler.toFlux(jobs);
		return new ResponseEntity<>(fluxOfJobs, HttpStatus.OK);
	}
}
