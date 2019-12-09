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

import local.example.data.model.Author;
import local.example.data.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.Optional;

@Service
public class AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    public long rowCounter() {
        return authorRepository.rowCounter();
    }

    public Collection<Author> selectAll() {
        return authorRepository.selectAll();
    }

    public Collection<Author> selectAllOrderByLastName() {
        return authorRepository.selectAllOrderByLastName();
    }

    public Optional<Author> selectWhereId(Long id) {
        return authorRepository.selectWhereId(id);
    }

    public Collection<Author> selectLikeFirstName(String firstName) {
        return authorRepository.selectLikeFirstName(firstName);
    }

    public Collection<Author> selectWhereLastName(String lastName) {
        return authorRepository.selectWhereLastName(lastName);
    }

    @Transactional
    public int updateFirstNameWhereId(Author author, Long id) {
        return authorRepository.updateFirstNameWhereId(author.getFirstName(), id);
    }

    @Transactional
    public int updateLastNameWhereId(Author author, Long id) {
        return authorRepository.updateLastNameWhereId(author.getLastName(), id);
    }
}
