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

package local.example.graph.controller;

import local.example.graph.relationship.Think;
import local.example.graph.service.ThinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ThinkRestController {

    @Autowired
    private ThinkService thinkService;

    @GetMapping("/relationship")
    public ResponseEntity<List<Think>> retrieveAll() {
        List<Think> relationships = thinkService.retrieveAllThinks();
        return ResponseEntity.ok(relationships);
    }

    @GetMapping("/relationship/code")
    public ResponseEntity<List<String>> retrieveAllCode() {
        List<String> relationshipCodes = thinkService.retrieveCodeOfAllRelationships();
        return ResponseEntity.ok(relationshipCodes);
    }
}
