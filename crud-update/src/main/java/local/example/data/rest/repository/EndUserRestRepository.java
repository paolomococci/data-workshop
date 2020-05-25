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

package local.example.data.rest.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import local.example.data.entity.EndUser;

@RepositoryRestResource
public interface EndUserRestRepository 
		extends PagingAndSortingRepository<EndUser, Long> {

	List<EndUser> findByFirstName(@Param("firstName") String firstName);
	List<EndUser> findByLastName(@Param("lastName") String lastName);
	List<EndUser> findByUsername(@Param("username") String username);
}
