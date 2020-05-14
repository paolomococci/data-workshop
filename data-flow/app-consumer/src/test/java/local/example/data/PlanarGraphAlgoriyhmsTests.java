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
import org.junit.jupiter.api.Disabled;
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
		weightedGraph.addVertex("L");
		DefaultWeightedEdge abWeightedEdge = new DefaultWeightedEdge();
		DefaultWeightedEdge adWeightedEdge = new DefaultWeightedEdge();
		DefaultWeightedEdge acWeightedEdge = new DefaultWeightedEdge();
		DefaultWeightedEdge bgWeightedEdge = new DefaultWeightedEdge();
		DefaultWeightedEdge beWeightedEdge = new DefaultWeightedEdge();
		DefaultWeightedEdge bdWeightedEdge = new DefaultWeightedEdge();
		DefaultWeightedEdge cdWeightedEdge = new DefaultWeightedEdge();
		DefaultWeightedEdge cfWeightedEdge = new DefaultWeightedEdge();
		DefaultWeightedEdge clWeightedEdge = new DefaultWeightedEdge();
		DefaultWeightedEdge deWeightedEdge = new DefaultWeightedEdge();
		DefaultWeightedEdge dfWeightedEdge = new DefaultWeightedEdge();
		DefaultWeightedEdge efWeightedEdge = new DefaultWeightedEdge();
		DefaultWeightedEdge egWeightedEdge = new DefaultWeightedEdge();
		DefaultWeightedEdge fgWeightedEdge = new DefaultWeightedEdge();
		DefaultWeightedEdge fiWeightedEdge = new DefaultWeightedEdge();
		DefaultWeightedEdge flWeightedEdge = new DefaultWeightedEdge();
		DefaultWeightedEdge ghWeightedEdge = new DefaultWeightedEdge();
		DefaultWeightedEdge giWeightedEdge = new DefaultWeightedEdge();
		DefaultWeightedEdge hiWeightedEdge = new DefaultWeightedEdge();
		DefaultWeightedEdge hlWeightedEdge = new DefaultWeightedEdge();
		DefaultWeightedEdge ilWeightedEdge = new DefaultWeightedEdge();
		weightedGraph.addEdge("A", "B", abWeightedEdge);
		weightedGraph.addEdge("A", "C", acWeightedEdge);
		weightedGraph.addEdge("A", "D", adWeightedEdge);
		weightedGraph.addEdge("B", "D", bdWeightedEdge);
		weightedGraph.addEdge("B", "E", beWeightedEdge);
		weightedGraph.addEdge("B", "G", bgWeightedEdge);
		weightedGraph.addEdge("C", "D", cdWeightedEdge);
		weightedGraph.addEdge("C", "F", cfWeightedEdge);
		weightedGraph.addEdge("C", "L", clWeightedEdge);
		weightedGraph.addEdge("D", "E", deWeightedEdge);
		weightedGraph.addEdge("D", "F", dfWeightedEdge);
		weightedGraph.addEdge("E", "F", efWeightedEdge);
		weightedGraph.addEdge("E", "G", egWeightedEdge);
		weightedGraph.addEdge("F", "G", fgWeightedEdge);
		weightedGraph.addEdge("F", "I", fiWeightedEdge);
		weightedGraph.addEdge("F", "L", flWeightedEdge);
		weightedGraph.addEdge("G", "H", ghWeightedEdge);
		weightedGraph.addEdge("G", "I", giWeightedEdge);
		weightedGraph.addEdge("H", "I", hiWeightedEdge);
		weightedGraph.addEdge("H", "L", hlWeightedEdge);
		weightedGraph.addEdge("I", "L", ilWeightedEdge);
		weightedGraph.setEdgeWeight(abWeightedEdge, 6.0);
		weightedGraph.setEdgeWeight(acWeightedEdge, 9.0);
		weightedGraph.setEdgeWeight(adWeightedEdge, 3.0);
		weightedGraph.setEdgeWeight(bdWeightedEdge, 4.0);
		weightedGraph.setEdgeWeight(beWeightedEdge, 2.0);
		weightedGraph.setEdgeWeight(bgWeightedEdge, 9.0);
		weightedGraph.setEdgeWeight(cdWeightedEdge, 9.0);
		weightedGraph.setEdgeWeight(cfWeightedEdge, 8.0);
		weightedGraph.setEdgeWeight(clWeightedEdge, 18.0);
		weightedGraph.setEdgeWeight(deWeightedEdge, 2.0);
		weightedGraph.setEdgeWeight(dfWeightedEdge, 9.0);
		weightedGraph.setEdgeWeight(efWeightedEdge, 8.0);
		weightedGraph.setEdgeWeight(egWeightedEdge, 5.0);
		weightedGraph.setEdgeWeight(fgWeightedEdge, 7.0);
		weightedGraph.setEdgeWeight(fiWeightedEdge, 9.0);
		weightedGraph.setEdgeWeight(flWeightedEdge, 10.0);
		weightedGraph.setEdgeWeight(ghWeightedEdge, 4.0);
		weightedGraph.setEdgeWeight(giWeightedEdge, 5.0);
		weightedGraph.setEdgeWeight(hiWeightedEdge, 1.0);
		weightedGraph.setEdgeWeight(hlWeightedEdge, 4.0);
		weightedGraph.setEdgeWeight(ilWeightedEdge, 3.0);
	}

	@Test
	@Disabled
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
