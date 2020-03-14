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

package local.example.data.repository;

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
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

@SpringBootTest
public class PieceRepositoryMockMvcTests {

	private static String PIECE_TEST_STRING = 
			"{\"title\":\"some_title\",\"act\":\"some_act\",\"session\":\"some_session\",\"script\":\"some_script\"}";

	@Autowired
	MockMvc mockMvc;

	@Autowired
	PieceRepository pieceRepository;

	@Test
	public void contextTest() 
			throws Exception {
		assertThat(pieceRepository)
			.isNotNull();
	}

	@Test
	public void verifyExistence() 
			throws Exception {
		mockMvc
			.perform(get("/"))
			.andDo(print())
			.andExpect(status().isOk())
			.andExpect(jsonPath("$._links.pieces").exists());
	}

	@Test
	public void createTest() 
			throws Exception {
		mockMvc
			.perform(post("/pieces").content(PIECE_TEST_STRING))
			.andExpect(status().isCreated())
			.andExpect(header().string("Location", containsString("pieces/")));
	}

	@Test
	public void readTest() 
			throws Exception {
		var mvcResult = mockMvc
				.perform(post("/pieces").content(PIECE_TEST_STRING))
				.andExpect(status().isCreated())
				.andReturn();
		var result = mvcResult.getResponse().getHeader("Location");
		mockMvc.perform(get(result))
			.andExpect(status().isOk())
			.andExpect(jsonPath("$.title").value("some_title"))
			.andExpect(jsonPath("$.act").value("some_act"))
			.andExpect(jsonPath("$.session").value("some_session"))
			.andExpect(jsonPath("$.script").value("some_script"));
	}

	@Test
	public void readAllTest() 
			throws Exception {
		MvcResult mvcResult = mockMvc
				.perform(post("/pieces").content(PIECE_TEST_STRING))
				.andExpect(status().isCreated())
				.andReturn();
		String result = mvcResult.getResponse().getHeader("Location");
		mockMvc.perform(get(result))
				.andExpect(status().isOk());
	}

	@Test
	public void partialUpdateTest() 
			throws Exception {
		MvcResult mvcResult = mockMvc
				.perform(post("/pieces").content(PIECE_TEST_STRING))
				.andExpect(status().isCreated())
				.andReturn();
		String result = mvcResult.getResponse().getHeader("Location");
		mockMvc.perform(patch(result).content("{\"title\":\"waiting_for_nobody\"}"))
				.andExpect(status().isNoContent());
		mockMvc.perform(get(result))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.title").value("waiting_for_nobody"));
	}

	@Test
	public void deleteTest() 
			throws Exception {
		var mvcResult = mockMvc
				.perform(post("/pieces").content(PIECE_TEST_STRING))
				.andExpect(status().isCreated())
				.andReturn();
		var result = mvcResult.getResponse().getHeader("Location");
		mockMvc.perform(delete(result)).andExpect(status().isNoContent());
		mockMvc.perform(get(result)).andExpect(status().isNotFound());
	}
}
