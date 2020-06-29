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

package local.example.data.view;

import static org.junit.jupiter.api.Assertions.assertEquals;

import javax.annotation.PostConstruct;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Configuration;

import com.vaadin.flow.server.VaadinRequest;

import local.example.data.model.Customer;
import local.example.data.model.CustomerRepository;

@SpringBootTest(classes = MainViewTests.Configure.class, webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class MainViewTests {

	@Autowired
	CustomerRepository customerRepository;

	VaadinRequest vaadinRequest = Mockito.mock(VaadinRequest.class);

	MainView mainView;

	@BeforeEach
	public void init() {
		// TODO
	}

	@Test
	@Disabled
	void existTest() 
			throws Exception {
		assertEquals(1, this.customerRepository.count());
		// TODO
	}

	@Configuration
	@EnableAutoConfiguration(exclude = com.vaadin.flow.spring.SpringBootAutoConfiguration.class)
	static class Configure {
	
		@Autowired
		CustomerRepository customerRepository;
	
		@PostConstruct
		public void initialize() {
			this.customerRepository.save(new Customer(null, "john", "Do", null, null, null));
		}
	}
}
