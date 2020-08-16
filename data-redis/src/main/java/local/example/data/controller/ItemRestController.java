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

package local.example.data.controller;

import local.example.data.assembler.ItemRepresentationModelAssembler;
import local.example.data.model.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ReactiveRedisOperations;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.net.URISyntaxException;
import java.util.UUID;

@RepositoryRestController
@RequestMapping(value = "/api/reactive/items", produces = "application/hal+json")
public class ItemRestController {

    @Autowired
    ReactiveRedisOperations<String, Item> itemReactiveRedisOperations;

    @Autowired
    ItemRepresentationModelAssembler itemRepresentationModelAssembler;

    @PostMapping
    public ResponseEntity<?> create(@RequestBody Item item)
            throws Exception {
        item.setId(UUID.randomUUID().toString());
        Mono<Boolean> result = this.itemReactiveRedisOperations.opsForValue().set(item.getId(), item);
        if (result.single().block()) {
            EntityModel<Item> entityModelOfItem = this.itemRepresentationModelAssembler.toModel(item);
            return new ResponseEntity<>(entityModelOfItem, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<?> read(@PathVariable String id)
            throws URISyntaxException {
        Mono<Item> itemMono = this.itemReactiveRedisOperations.opsForValue().get(id);
        Item item = itemMono.block();
        if (item != null) {
            EntityModel<Item> entityModelOfItem = this.itemRepresentationModelAssembler.toModel(item);
            return new ResponseEntity<>(entityModelOfItem, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public ResponseEntity<?> readAll() {
         Flux<Item> itemFlux = itemReactiveRedisOperations
                .keys("*")
                .flatMap(this.itemReactiveRedisOperations.opsForValue()::get);
         Iterable<Item> items = itemFlux.toIterable();
         CollectionModel<EntityModel<Item>> collectionModelOfItems;
         collectionModelOfItems = this.itemRepresentationModelAssembler.toCollectionModel(items);
         return new ResponseEntity<>(collectionModelOfItems, HttpStatus.OK);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<?> putUpdate(@RequestBody Item updated, @PathVariable String id) {
        // TODO
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    @PatchMapping(path = "/{id}")
    public ResponseEntity<?> patchUpdate(@RequestBody Item item, @PathVariable String id) {
        // TODO
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> delete(@PathVariable String id)
            throws URISyntaxException {
        this.itemReactiveRedisOperations.opsForValue().delete(id).subscribe();
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
