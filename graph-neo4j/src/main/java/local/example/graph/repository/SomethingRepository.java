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

package local.example.graph.repository;

import local.example.graph.node.Something;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Collection;
import java.util.List;

@RepositoryRestResource(
        collectionResourceRel = "everything",
        path = "everything"
)
public interface SomethingRepository
        extends Neo4jRepository<Something, Long> {

    @Query("match (e:Something)<-[t:THINK_TO]-(s:Someone) return e,t,s limit {limit}")
    Collection<Something> showGraph(@Param("limit") int limit);

    List<Something> findByCode(@Param("code") String code);
    Collection<Something> findByCodeLike(@Param("code") String code);
}
