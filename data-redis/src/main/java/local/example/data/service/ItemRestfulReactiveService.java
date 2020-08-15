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

package local.example.data.service;

import local.example.data.model.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.ReactiveRedisConnectionFactory;
import org.springframework.data.redis.core.ReactiveRedisOperations;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Service
public class ItemRestfulReactiveService {

    @Autowired
    ReactiveRedisConnectionFactory reactiveRedisConnectionFactory;

    @Autowired
    ReactiveRedisOperations<String, Item> itemReactiveRedisOperations;

    public void monoCreate(Item item) {
        this.reactiveRedisConnectionFactory.getReactiveConnection().serverCommands().flushAll().then(
                Mono.just(item.getId())
                        .map(id -> new Item(id, item.getCode(), item.getName(), item.getDescription()))
                        .flatMap(temp -> this.itemReactiveRedisOperations.opsForValue().set(temp.getId(), temp)));
    }

    public void fluxCreate(Item item) {
        this.reactiveRedisConnectionFactory.getReactiveConnection().serverCommands().flushAll().thenMany(
                Flux.just(item.getId())
                        .map(id -> new Item(id, item.getCode(), item.getName(), item.getDescription()))
                        .flatMap(temp -> this.itemReactiveRedisOperations.opsForValue().set(temp.getId(), temp)))
                    .thenMany(this.itemReactiveRedisOperations.keys("*")
                            .flatMap(this.itemReactiveRedisOperations.opsForValue()::get))
                    .subscribe(System.out::println);
    }
}
