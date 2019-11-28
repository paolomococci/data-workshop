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

import local.example.graph.node.Someone;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(
        collectionResourceRel = "some",
        path = "some"
)
public interface SomeoneRepository
        extends Neo4jRepository<Someone, Long> {

    String CREATE_RELATIONSHIP = "match (s:Someone),(e:Something) " +
            "where s.id = {someoneId} " +
            "and e.id = {SomethingId} " +
            "create (s)-[THINK_TO]->(e)";
    String CREATE_RELATIONSHIP_WITH_CODE = "match (s:Someone),(e:Something) " +
            "where s.id = {someoneId} " +
            "and e.id = {SomethingId} " +
            "create (s)-[THINK_TO {code:s.code+'-'+e.code}]->(e)";
    String DELETE_RELATIONSHIP = "match (s {id: {someoneId}})-[r:THINK_TO]->(e {id: {somethingId}}) delete r";

    @Query(value = CREATE_RELATIONSHIP)
    void createRelationship(@Param("someoneId") long someoneId, @Param("somethingId") long somethingId);

    @Query(value = CREATE_RELATIONSHIP_WITH_CODE)
    void createRelationshipWithCode(@Param("someoneId") long someoneId, @Param("somethingId") long somethingId);

    @Query(value = DELETE_RELATIONSHIP)
    void deleteRelationship(@Param("someoneId") long someoneId, @Param("somethingId") long somethingId);

    List<Someone> findByCode(@Param("code") String code);
}
