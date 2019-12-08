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

import local.example.data.model.Book;
import local.example.data.repository.BookRepository;
import local.example.data.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Optional;

@RepositoryRestController
@RequestMapping("/api/books")
public class BookRestController {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private BookService bookService;

    @GetMapping
    public ResponseEntity<Collection<Book>> selectAll() {
        return ResponseEntity.ok(bookRepository.selectAll());
    }

    @GetMapping("/order/by/title")
    public ResponseEntity<Collection<Book>> selectAllOrderByTitle() {
        return ResponseEntity.ok(bookRepository.selectAllOrderByTitle());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Book>> selectBookWhereId(@PathVariable("id") Long id) {
        return ResponseEntity.ok(bookRepository.selectById(id));
    }

    @GetMapping("/like{title}")
    public ResponseEntity<Collection<Book>> selectBookLikeTitle(@RequestParam(value = "title") String title) {
        return ResponseEntity.ok(bookRepository.selectLikeTitle(title));
    }

    @GetMapping("/like/ignore/case{title}")
    public ResponseEntity<Collection<Book>> selectBookLikeTitleIgnoreCase(@RequestParam(value = "title") String title) {
        return ResponseEntity.ok(bookRepository.selectLikeTitleIgnoreCase(title.toLowerCase()));
    }

    @GetMapping("/where{title}")
    public ResponseEntity<Collection<Book>> selectBookWhereTitle(@RequestParam(value = "title") String title) {
        return ResponseEntity.ok(bookRepository.selectWhereTitle(title));
    }

    @PostMapping("/{id}")
    public ResponseEntity<String> updateTitleWhereId(
            @PathVariable("id") Long id,
            @RequestBody Book book) {
        return ResponseEntity.ok("updated: " + bookService.updateTitleWhereId(book, id));
    }
}
