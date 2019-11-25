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

import local.example.graph.node.Something;
import local.example.graph.relationship.Think;
import local.example.graph.repository.SomethingRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
public class SomethingService {

    private final SomethingRepository somethingRepository;

    public SomethingService(SomethingRepository somethingRepository) {
        this.somethingRepository = somethingRepository;
    }

    @Transactional(readOnly = true)
    public List<Something> findByCode(String code) {
        return somethingRepository.findByCode(code);
    }

    @Transactional(readOnly = true)
    public Collection<Something> findByCodeLike(String code) {
        return somethingRepository.findByCodeLike(code);
    }

    @Transactional(readOnly = true)
    public Map<String, Object> graphMap(int limit) {
        Collection<Something> somethingCollection = somethingRepository.showGraph(limit);
        return this.cast(somethingCollection);
    }

    private Map<String, Object> cast(Collection<Something> somethingCollection) {
        int index = 0;
        List<Map<String, Object>> nodes = new ArrayList<>();
        List<Map<String, Object>> relationships = new ArrayList<>();
        for (Something value : somethingCollection) {
            int target = index;
            nodes.add(this.map("code", value.getCode(), "label", "something"));
            index++;
            for (Think think : value.getThinks()) {
                Map<String, Object> someone = this.map(
                        "code",
                        think.getSomeone().getCode(),
                        "label",
                        "some"
                );
                int source = nodes.indexOf(someone);
                if (source == -1) {
                    nodes.add(someone);
                    source = index++;
                }
                relationships.add(this.map("source", source, "target", target));
            }
        }
        return this.map("nodes", nodes, "relationships", relationships);
    }

    private Map<String, Object> map(String keyOne, Object objectOne, String keyTwo, Object objectTwo) {
        Map<String, Object> hashMap = new HashMap<>(2);
        hashMap.put(keyOne, objectOne);
        hashMap.put(keyTwo, objectTwo);
        return hashMap;
    }
}
