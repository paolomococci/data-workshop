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

import local.example.data.document.Account;
import local.example.data.repository.AccountRestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(value = "/accounts")
public class AccountRestController {

    @Autowired
    private AccountRestRepository accountRestRepository;

    @PostMapping
    public Mono<Account> create(@RequestBody Account account) {
        return this.accountRestRepository.save(account);
    }

    @GetMapping(value = "/{id}")
    public Mono<Account> read(@PathVariable String id) {
        return this.accountRestRepository.findById(id);
    }

    @GetMapping
    public Flux<Account> readAll() {
        return this.accountRestRepository.findAll();
    }

    @PutMapping(value = "/{id}")
    public Mono<Account> putUpdate(@RequestBody Account updated, @PathVariable String id) {
        Account account = this.accountRestRepository.findById(id).block();
        if (account != null) {
            if (updated.getName() != null) account.setName(updated.getName());
            if (updated.getPassword() != null) account.setPassword(updated.getPassword());
            return this.accountRestRepository.save(account);
        }
        return Mono.empty();
    }

    @PatchMapping(value = "/{id}")
    public Mono<Account> patchUpdate(@RequestBody Account updated, @PathVariable String id) {
        Account account = this.accountRestRepository.findById(id).block();
        if (account != null) {
            if (updated.getPassword() != null) account.setPassword(updated.getPassword());
            return this.accountRestRepository.save(account);
        }
        return Mono.empty();
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable String id) {
        this.accountRestRepository.deleteById(id).subscribe();
    }
}
