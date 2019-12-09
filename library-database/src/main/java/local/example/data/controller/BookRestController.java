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
import local.example.data.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RepositoryRestController
@RequestMapping("/api/books")
public class BookRestController {

    @Autowired
    private BookService bookService;

    @GetMapping("/row/counter")
    public ResponseEntity<Map<String, Long>> rowCounter() {
        Map<String, Long> response = new HashMap<>();
        response.put("rows", bookService.rowCounter());
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<Collection<Book>> selectAll() {
        return ResponseEntity.ok(bookService.selectAll());
    }

    @GetMapping("/order/by/title")
    public ResponseEntity<Collection<Book>> selectAllOrderByTitle() {
        return ResponseEntity.ok(bookService.selectAllOrderByTitle());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Book>> selectWhereId(@PathVariable("id") Long id) {
        return ResponseEntity.ok(bookService.selectWhereId(id));
    }

    @GetMapping("/like{title}")
    public ResponseEntity<Collection<Book>> selectLikeTitle(@RequestParam(value = "title") String title) {
        return ResponseEntity.ok(bookService.selectLikeTitle(title));
    }

    @GetMapping("/like/ignore/case{title}")
    public ResponseEntity<Collection<Book>> selectLikeTitleIgnoreCase(@RequestParam(value = "title") String title) {
        return ResponseEntity.ok(bookService.selectLikeTitleIgnoreCase(title.toLowerCase()));
    }

    @GetMapping("/where{title}")
    public ResponseEntity<Collection<Book>> selectWhereTitle(@RequestParam(value = "title") String title) {
        return ResponseEntity.ok(bookService.selectWhereTitle(title));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<String> updateTitleWhereId(
            @PathVariable("id") Long id,
            @RequestBody Book book) {
        return ResponseEntity.ok("{updated: " + bookService.updateTitleWhereId(book, id) + "}");
    }
}
