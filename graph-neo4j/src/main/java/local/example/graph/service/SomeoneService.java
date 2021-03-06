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

import local.example.graph.node.Someone;
import local.example.graph.node.Something;
import local.example.graph.repository.SomeoneRepository;
import local.example.graph.repository.SomethingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class SomeoneService {

    @Autowired
    private SomeoneRepository someoneRepository;

    @Autowired
    private SomethingRepository somethingRepository;

    @Transactional(readOnly = true)
    public boolean verifyExistenceById(Long id) {
        Optional<Someone> optionalSomeone = someoneRepository.findById(id);
        return optionalSomeone.isPresent();
    }

    @Transactional
    public void createRelationship(Long someoneId, Long somethingId) {
        Optional<Someone> optionalSomeone = someoneRepository.findById(someoneId);
        Optional<Something> optionalSomething = somethingRepository.findById(somethingId);
        someoneRepository.createRelationshipWithCode(
                optionalSomeone.get().getCode(),
                optionalSomething.get().getCode());
    }
}
