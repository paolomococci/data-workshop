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

package local.example.graph.service;

import local.example.graph.relationship.Think;
import local.example.graph.repository.SomeoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ThinkService {

    @Autowired
    private SomeoneRepository someoneRepository;

    @Transactional(readOnly = true)
    public List<Think> retrieveAllThinks() {
        return someoneRepository.retrieveAllRelationship();
    }

    @Transactional(readOnly = true)
    public List<String> retrieveCodeOfAllRelationships() {
        return someoneRepository.retrieveCodeOfAllRelationships();
    }
}
