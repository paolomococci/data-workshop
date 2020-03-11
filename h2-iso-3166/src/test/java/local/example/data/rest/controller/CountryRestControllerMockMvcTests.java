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

package local.example.data.rest.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

@SpringBootTest
@AutoConfigureMockMvc
public class CountryRestControllerMockMvcTests {

	private static String ISO_3166_TEST_STRING = 
			"{\"name\":\"Italy\",\"alphaTwo\":\"IT\",\"alphaThree\":\"ITA\",\"countryId\":\"380\"}";
	
	@Autowired
	MockMvc mockMvc;
	
	@Autowired
	CountryRestController countryRestController;
	
	@Test
	public void contextTest() 
			throws Exception {
		assertThat(countryRestController)
			.isNotNull();
	}

	@Test
	void existenceTest() 
			throws Exception {
		mockMvc
			.perform(get("/api/countries"))
			.andDo(print())
			.andExpect(status().isOk());
	}

	@Test
	public void createTest() 
			throws Exception {
		// TODO
	}

	@Test
	public void readTest() 
			throws Exception {
		// TODO
	}

	@Test
	public void readAllTest() 
			throws Exception {
		// TODO
	}

	@Test
	public void updateTest() 
			throws Exception {
		// TODO
	}

	@Test
	public void deleteTest() 
			throws Exception {
		// TODO
	}
}
