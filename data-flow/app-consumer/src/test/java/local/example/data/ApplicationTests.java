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

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.jgrapht.Graph;
import org.jgrapht.alg.connectivity.KosarajuStrongConnectivityInspector;
import org.jgrapht.alg.interfaces.StrongConnectivityAlgorithm;
import org.jgrapht.graph.DefaultDirectedGraph;
import org.jgrapht.graph.DefaultEdge;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Execution(ExecutionMode.CONCURRENT)
class ApplicationTests {

	@Test
	@DisplayName("strongly connected directed graph test")
	void sampleTest() {
		Graph<String, DefaultEdge> directedGraph;
		directedGraph = new DefaultDirectedGraph<>(DefaultEdge.class);
		// add vertexes
		directedGraph.addVertex("A");
		directedGraph.addVertex("B");
		directedGraph.addVertex("C");
		directedGraph.addVertex("D");
		// add edges
		directedGraph.addEdge("A", "B");
		directedGraph.addEdge("B", "D");
		directedGraph.addEdge("D", "C");
		directedGraph.addEdge("C", "A");
		StrongConnectivityAlgorithm<String, DefaultEdge> strongConnectivityAlgorithm;
		strongConnectivityAlgorithm = new KosarajuStrongConnectivityInspector<>(directedGraph);
		assertTrue(strongConnectivityAlgorithm.isStronglyConnected());
	}
}
