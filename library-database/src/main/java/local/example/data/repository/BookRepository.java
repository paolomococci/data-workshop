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

package local.example.data.repository;

import local.example.data.model.Book;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Collection;
import java.util.Optional;

@RepositoryRestResource
public interface BookRepository
        extends PagingAndSortingRepository<Book, Long> {

    @Query(value = "SELECT COUNT(*) FROM book", nativeQuery = true)
    long rowCounter();

    @Query(value = "SELECT * FROM book", nativeQuery = true)
    Collection<Book> selectAll();

    @Query(value = "SELECT * FROM book b ORDER BY b.title", nativeQuery = true)
    Collection<Book> selectAllOrderByTitle();

    @Query(value = "SELECT * FROM book b WHERE b.id = :id", nativeQuery = true)
    Optional<Book> selectWhereId(@Param("id") Long id);

    @Query(value = "SELECT * FROM book b WHERE b.title LIKE %:title%", nativeQuery = true)
    Collection<Book> selectLikeTitle(@Param("title") String title);

    @Query(value = "SELECT * FROM book b WHERE LOWER(b.title) LIKE %:title%", nativeQuery = true)
    Collection<Book> selectLikeTitleIgnoreCase(String title);

    @Query(value = "SELECT * FROM book b WHERE b.title = :title", nativeQuery = true)
    Collection<Book> selectWhereTitle(@Param("title") String title);

    @Modifying(flushAutomatically = true, clearAutomatically = true)
    @Query(value = "UPDATE book SET title = :title WHERE id = :id", nativeQuery = true)
    int updateTitleWhereId(@Param("title") String title, @Param("id") Long id);
}
