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
import local.example.data.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Optional;

@RepositoryRestController
@RequestMapping("/api/authors")
public class AuthorRestController {

    @Autowired
    private AuthorService authorService;

    @GetMapping("/row/counter")
    public ResponseEntity<String> rowCounter() {
        return ResponseEntity.ok("{rows: " + authorService.rowCounter() + "}");
    }

    @GetMapping
    public ResponseEntity<Collection<Author>> selectAll() {
        return ResponseEntity.ok(authorService.selectAll());
    }

    @GetMapping("/order/by/lastName")
    public ResponseEntity<Collection<Author>> selectAllOrderByLastName() {
        return ResponseEntity.ok(authorService.selectAllOrderByLastName());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Author>> selectWhereId(@PathVariable("id") Long id) {
        return ResponseEntity.ok(authorService.selectWhereId(id));
    }

    @GetMapping("/name{firstName}")
    public ResponseEntity<Collection<Author>> selectLikeFirstName(@RequestParam("firstName") String firstName) {
        return ResponseEntity.ok(authorService.selectLikeFirstName(firstName));
    }

    @GetMapping("/surname{lastName}")
    public ResponseEntity<Collection<Author>> selectWhereLastName(@RequestParam("lastName") String lastName) {
        return ResponseEntity.ok(authorService.selectWhereLastName(lastName));
    }

    @PatchMapping("/name/{id}")
    public ResponseEntity<String> updateFirstNameWhereId(
            @PathVariable("id") Long id,
            @RequestBody Author author) {
        return ResponseEntity.ok("{updated: " + authorService.updateFirstNameWhereId(author, id) + "}");
    }

    @PatchMapping("/surname/{id}")
    public ResponseEntity<String> updateLastNameWhereId(
            @PathVariable("id") Long id,
            @RequestBody Author author) {
        return ResponseEntity.ok("{updated: " + authorService.updateLastNameWhereId(author, id) + "}");
    }
}
