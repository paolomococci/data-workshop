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

package local.example.demo.model

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
class Customer {

    @Id
    @GeneratedValue
    Long id

    String name

    String surname

    String email

    Long getId() {
        return id
    }

    String getName() {
        return name
    }

    void setName(String name) {
        this.name = name
    }

    String getSurname() {
        return surname
    }

    void setSurname(String surname) {
        this.surname = surname
    }

    String getEmail() {
        return email
    }

    void setEmail(String email) {
        this.email = email
    }
}
