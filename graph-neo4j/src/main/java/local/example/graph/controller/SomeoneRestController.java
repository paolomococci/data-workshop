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

import local.example.graph.service.SomeoneService;
import local.example.graph.service.SomethingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class SomeoneRestController {

    @Autowired
    private SomeoneService someoneService;

    @Autowired
    private SomethingService somethingService;

    @GetMapping("/some/create/relationship/{someoneId}")
    public ResponseEntity<String> createRelationship(
            @PathVariable("someoneId") String someoneId,
            @RequestParam(value = "somethingId") String somethingId) {
        if (someoneService.verifyExistenceById(Long.parseLong(someoneId))
                && somethingService.verifyExistenceById(Long.parseLong(somethingId))) {
            someoneService.createRelationship(
                    // TODO
                    Long.parseLong(someoneId),
                    Long.parseLong(somethingId)
            );
        } else {
            return new ResponseEntity<>("an error has occurred", HttpStatus.NO_CONTENT);
        }
        return ResponseEntity.ok().body("correlation created correctly");
    }
}
