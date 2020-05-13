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

package local.example.data;

import org.jgrapht.Graph;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleWeightedGraph;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Execution(ExecutionMode.CONCURRENT)
public class PlanarGraphAlgoriyhmsTests {

	private static Graph<String, DefaultWeightedEdge> weightedGraph;

	@BeforeAll
	static void init() 
			throws Exception {
		weightedGraph  = new SimpleWeightedGraph<>(DefaultWeightedEdge.class);
		weightedGraph.addVertex("A");
		weightedGraph.addVertex("B");
		weightedGraph.addVertex("C");
		weightedGraph.addVertex("D");
		weightedGraph.addVertex("E");
		weightedGraph.addVertex("F");
		weightedGraph.addVertex("G");
		weightedGraph.addVertex("G");
		weightedGraph.addVertex("G");
		weightedGraph.addVertex("H");
		weightedGraph.addVertex("I");
	}

	@Test
	@DisplayName("planar test")
	void planarTest() 
			throws Exception {
		
	}

	@AfterAll
	static void end() 
			throws Exception {
		System.out.println("After all execution!");
	}
}
