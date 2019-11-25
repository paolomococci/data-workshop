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
package local.example.graph.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
class SomethingRepositoryMockMvcTests {

    @Autowired
    private MockMvc mockMvc;

    /* it is not necessary that Neo4j community edition is in operation */
    @Test
    void sampleTest()
            throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$._links.everything").exists());
    }

    /* it's necessary that Neo4j community edition is correctly installed and in operation */
    @Test
    void existTest()
            throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/everything"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$._embedded.everything").exists());
    }

    /**
     * from here on, it's necessary that Neo4j community edition is correctly installed,
     * in operation and with some stored data
     */
    @Test
    void retrieveExistTest()
            throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/everything/22"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.code").exists());
    }

    @Test
    void retrieveCodeValueTest()
            throws Exception {
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/everything/22"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();
        String location = mvcResult.getResponse().getHeader("Location");
        if (location != null) {
            mockMvc.perform(MockMvcRequestBuilders.get(location))
                    .andExpect(MockMvcResultMatchers.status().isOk())
                    .andExpect(MockMvcResultMatchers
                            .jsonPath("$.code").value("FE8NXS34M1W9"));
        }
    }

    @Test
    void existLinksTest()
            throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/everything/22"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$._links").exists());
    }

    @Test
    void existSelfLinkTest()
            throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/everything/22"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$._links.self").exists());
    }

    @Test
    void retrieveSelfLinkValueTest()
            throws Exception {
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/everything/22"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();
        String location = mvcResult.getResponse().getHeader("Location");
        if (location != null) {
            mockMvc.perform(MockMvcRequestBuilders.get(location))
                    .andExpect(MockMvcResultMatchers.status().isOk())
                    .andExpect(MockMvcResultMatchers
                            .jsonPath("$._links.self")
                            .value("http://127.0.0.1:8080/everything/22"));
        }
    }

    @Test
    void retrieveSomethingLinkValueTest()
            throws Exception {
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/everything/22"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();
        String location = mvcResult.getResponse().getHeader("Location");
        if (location != null) {
            mockMvc.perform(MockMvcRequestBuilders.get(location))
                    .andExpect(MockMvcResultMatchers.status().isOk())
                    .andExpect(MockMvcResultMatchers
                            .jsonPath("$._links.something")
                            .value("http://127.0.0.1:8080/everything/22"));
        }
    }

    @Test
    void retrieveFindByCodeTest()
            throws Exception {
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders
                .get("http://127.0.0.1:8080/everything/search/findByCode?code=FE8NXS34M1W9"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();
        String location = mvcResult.getResponse().getHeader("Location");
        if (location != null) {
            mockMvc.perform(MockMvcRequestBuilders.get(location))
                    .andExpect(MockMvcResultMatchers.status().isOk())
                    .andExpect(MockMvcResultMatchers
                            .jsonPath("$._embedded.everything.thinks")
                            .value(null))
                    .andExpect(MockMvcResultMatchers
                            .jsonPath("$._embedded.everything._links.self")
                            .value("http://127.0.0.1:8080/everything/22"))
                    .andExpect(MockMvcResultMatchers
                            .jsonPath("$._embedded.everything._links.something")
                            .value("http://127.0.0.1:8080/everything/22"));
        }
    }
}
