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
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import local.example.data.assembler.JobRepresentationModelAssembler;
import local.example.data.entity.Job;
import local.example.data.exception.JobNotFoundException;
import local.example.data.repository.JobRestRepository;

@RepositoryRestController
@RequestMapping(path = "/api/jobs")
public class JobRestController {

	@Autowired
	JobRestRepository jobRestRepository;

	@Autowired
	JobRepresentationModelAssembler jobRepresentationModelAssembler;

	@PostMapping
	public ResponseEntity<?> create(@RequestBody Job job) 
			throws URISyntaxException {
		EntityModel<Job> entityModelOfJob;
		entityModelOfJob = jobRepresentationModelAssembler
				.toModel(jobRestRepository.save(job));
		return new ResponseEntity<>(entityModelOfJob, HttpStatus.CREATED);
	}

	@GetMapping(path = "/{id}")
	public ResponseEntity<?> read(@PathVariable Long id) 
			throws URISyntaxException {
		Job job = jobRestRepository.findById(id)
				.orElseThrow(() -> new JobNotFoundException(id));
		EntityModel<Job> entityModelOfJob;
		entityModelOfJob = jobRepresentationModelAssembler.toModel(job);
		return new ResponseEntity<>(entityModelOfJob, HttpStatus.OK);
	}
	
	@GetMapping(path = "/codes/{code}")
	public ResponseEntity<?> readByCode(@PathVariable String code) 
			throws URISyntaxException {
		Iterable<Job> jobs = jobRestRepository.findByCode(code);
		CollectionModel<EntityModel<Job>> collectionModelOfJobs;
		collectionModelOfJobs = jobRepresentationModelAssembler
				.toCollectionModel(jobs);
		return new ResponseEntity<>(collectionModelOfJobs, HttpStatus.OK);
	}

	@GetMapping
	public ResponseEntity<?> readAll() 
			throws URISyntaxException {
		Iterable<Job> jobs = jobRestRepository.findAll();
		CollectionModel<EntityModel<Job>> collectionModelOfJobs;
		collectionModelOfJobs = jobRepresentationModelAssembler
				.toCollectionModel(jobs);
		return new ResponseEntity<>(collectionModelOfJobs, HttpStatus.OK);
	}

	@PutMapping(path = "/{id}")
	public ResponseEntity<?> putUpdate(
			@RequestBody Job jobUpdated, 
			@PathVariable Long id) 
			throws URISyntaxException {
		 Job temporaryEntityOfJob = jobRestRepository.findById(id)
				.map(job -> {
					job.setCode(jobUpdated.getCode());
					return jobRestRepository.save(job);
				}).orElseGet(() -> {
					return jobRestRepository.save(jobUpdated);
				});
		EntityModel<Job> entityModelOfJob;
		entityModelOfJob = jobRepresentationModelAssembler
				.toModel(temporaryEntityOfJob);
		return new ResponseEntity<>(entityModelOfJob, HttpStatus.OK);
	}
	
	@PatchMapping(path = "/{id}")
	public ResponseEntity<?> patchUpdate(
			@RequestBody Job jobUpdated, 
			@PathVariable Long id) 
			throws URISyntaxException {
		Job temporaryEntityOfJob = jobRestRepository.findById(id)
				.map(job -> {
					if (jobUpdated.getCode() != null) {
						job.setCode(jobUpdated.getCode());
					}
					return jobRestRepository.save(job);
				}).orElseGet(() -> {
					return jobRestRepository.save(jobUpdated);
				});
		EntityModel<Job> entityModelOfJob;
		entityModelOfJob = jobRepresentationModelAssembler
				.toModel(temporaryEntityOfJob);
		return new ResponseEntity<>(entityModelOfJob, HttpStatus.OK);
	}

	@DeleteMapping(path = "/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) 
			throws URISyntaxException {
		jobRestRepository.deleteById(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
