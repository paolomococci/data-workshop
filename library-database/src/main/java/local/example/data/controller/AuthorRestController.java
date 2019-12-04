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

import local.example.data.model.Author;
import local.example.data.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collection;

@RepositoryRestController
@RequestMapping("/api/authors")
public class AuthorRestController {

    @Autowired
    private AuthorRepository authorRepository;

    @GetMapping
    public ResponseEntity<Collection<Author>> selectAll() {
        return ResponseEntity.ok(authorRepository.selectAll());
    }

    @GetMapping("/{lastName}")
    public ResponseEntity<Collection<Author>> selectAuthorWhereLastName(@PathVariable("lastName") String lastName) {
        return ResponseEntity.ok(authorRepository.selectByLastName(lastName));
    }
}
