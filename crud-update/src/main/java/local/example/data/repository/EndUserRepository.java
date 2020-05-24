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

package local.example.data.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import local.example.data.entity.EndUser;

public interface EndUserRepository 
		extends JpaRepository<EndUser, Long> {

	Optional<EndUser> findById(Long id);

	@Query(nativeQuery = true, value = "SELECT * FROM ENDUSER WHERE NAME LIKE ?1%")
	List<EndUser> likeByName(String name);

	@Query(nativeQuery = true, value = "SELECT * FROM ENDUSER WHERE SURNAME LIKE ?1%")
	List<EndUser> likeBySurname(String surname);

	@Query(nativeQuery = true, value = "SELECT * FROM ENDUSER WHERE USERNAME LIKE ?1%")
	List<EndUser> likeByUsername(String username);
}
