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

package local.example.demo.controller

import local.example.demo.repository.CustomerRepository
import local.example.demo.model.Customer
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.servlet.ModelAndView

@Controller
class CustomerController {

    @Autowired
    private CustomerRepository customerRepository;

    @PostMapping('/create')
    def create(@ModelAttribute Customer customer) {
        customerRepository.save(customer);
        "redirect:/customer"
    }

    @GetMapping(value = ["/", "/customer"])
    def readAll() {
        new ModelAndView('customer', [customers: customerRepository.findAll()])
    }

    @GetMapping("/update/{id}")
    def updateForm(@PathVariable("id") Long id) {
        new ModelAndView('customer-update', [updated: customerRepository.findById(id).get()])
    }

    @PostMapping("/update")
    def update(@ModelAttribute("customer") Customer customer) {
        customerRepository.findById(customer.id).map(
                updatable -> {
                    updatable.name = customer.name
                    updatable.surname = customer.surname
                    updatable.email = customer.email
                    customerRepository.save(updatable)
                })
        "redirect:/customer"
    }

    @GetMapping("/delete/{id}")
    def delete(@PathVariable("id") Long id) {
        customerRepository.deleteById(id)
        "redirect:/customer"
    }
}
