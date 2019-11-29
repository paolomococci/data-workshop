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
            "where s.code = {someoneCode} " +
            "and e.code = {SomethingCode} " +
            "create (s)-[r:THINK_TO]->(e)";
    String CREATE_RELATIONSHIP_WITH_CODE = "match (s:Someone),(e:Something) " +
            "where s.code = {someoneCode} " +
            "and e.code = {SomethingCode} " +
            "create (s)-[r:THINK_TO {code:s.code+'-'+e.code}]->(e)";
    String DELETE_RELATIONSHIP = "match (s {code: {someoneCode}})-[r:THINK_TO]->(e {code: {somethingCode}}) delete r";
    String RETRIEVE_CODE_OF_ALL_RELATIONSHIP = "match (Someone)-[r:THINK_TO]->(Something) return r.code";

    @Query(value = CREATE_RELATIONSHIP)
    void createRelationship(@Param("someoneCode") String someoneCode, @Param("somethingCode") String somethingCode);

    @Query(value = CREATE_RELATIONSHIP_WITH_CODE)
    void createRelationshipWithCode(@Param("someoneCode") String someoneCode, @Param("somethingCode") String somethingCode);

    @Query(value = DELETE_RELATIONSHIP)
    void deleteRelationship(@Param("someoneCode") String someoneCode, @Param("somethingCode") String somethingCode);

    @Query(RETRIEVE_CODE_OF_ALL_RELATIONSHIP)
    List<String> retrieveCodeOfAllRelationships();

    List<Someone> findByCode(@Param("code") String code);
}
