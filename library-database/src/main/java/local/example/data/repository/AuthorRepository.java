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

import local.example.data.model.Author;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Collection;
import java.util.Optional;

@RepositoryRestResource
public interface AuthorRepository
        extends PagingAndSortingRepository<Author, Long> {

    @Query(value = "SELECT COUNT(*) FROM author", nativeQuery = true)
    long rowCounter();

    @Query(value = "SELECT * FROM author", nativeQuery = true)
    Collection<Author> selectAll();

    @Query(value = "SELECT * FROM author a ORDER BY a.last_name DESC", nativeQuery = true)
    Collection<Author> selectAllOrderByLastName();

    @Query(value = "SELECT * FROM author a WHERE a.id = :id", nativeQuery = true)
    Optional<Author> selectWhereId(@Param("id") Long id);

    @Query(value = "SELECT * FROM author a WHERE a.first_name LIKE %:firstName%", nativeQuery = true)
    Collection<Author> selectLikeFirstName(@Param("firstName") String fistName);

    @Query(value = "SELECT * FROM author a WHERE a.last_name = :lastName", nativeQuery = true)
    Collection<Author> selectWhereLastName(@Param("lastName") String lastName);

    @Modifying(flushAutomatically = true, clearAutomatically = true)
    @Query(value = "UPDATE author SET first_name = :firstName WHERE id = :id", nativeQuery = true)
    int updateFirstNameWhereId(@Param("firstName") String firstName, @Param("id") Long id);

    @Modifying(flushAutomatically = true, clearAutomatically = true)
    @Query(value = "UPDATE author SET last_name = :lastName WHERE id = :id", nativeQuery = true)
    int updateLastNameWhereId(@Param("lastName") String lastName, @Param("id") Long id);
}
