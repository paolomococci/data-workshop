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

package local.example.data.service;

import local.example.data.model.Book;
import local.example.data.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public long rowCounter() {
        return bookRepository.rowCounter();
    }

    public Collection<Book> selectAll() {
        return bookRepository.selectAll();
    }

    public Collection<Book> selectAllOrderByTitle() {
        return bookRepository.selectAllOrderByTitle();
    }

    public Optional<Book> selectWhereId(Long id) {
        return bookRepository.selectWhereId(id);
    }

    public Collection<Book> selectLikeTitle(String title) {
        return bookRepository.selectLikeTitle(title);
    }

    public Collection<Book> selectLikeTitleIgnoreCase(String title) {
        return bookRepository.selectLikeTitleIgnoreCase(title.toLowerCase());
    }

    public Collection<Book> selectWhereTitle(String title) {
        return bookRepository.selectWhereTitle(title);
    }

    @Transactional
    public int updateTitleWhereId(Book book, Long id) {
        return bookRepository.updateTitleWhereId(book.getTitle(), id);
    }
}
