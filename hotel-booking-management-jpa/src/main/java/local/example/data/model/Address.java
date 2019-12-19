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

package local.example.data.model;

import java.io.Serializable;
import javax.persistence.*;
import static javax.persistence.AccessType.PROPERTY;

@Entity
@NamedQuery(name="Address.findAll", query="SELECT a FROM Address a")
@Access(PROPERTY)
public class Address 
	implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	private Long id;

	private String city;

	private String civic;

	private String country;

	private String street;

	public Address() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCivic() {
		return this.civic;
	}

	public void setCivic(String civic) {
		this.civic = civic;
	}

	public String getCountry() {
		return this.country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getStreet() {
		return this.street;
	}

	public void setStreet(String street) {
		this.street = street;
	}
}
