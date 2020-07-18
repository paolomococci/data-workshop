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

package local.example.data.retrieve;

import java.io.Serializable;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClient.RequestHeadersSpec;

import com.fasterxml.jackson.databind.JsonNode;

@Service
public class ItemsRestDataRetriever 
		implements Serializable {

	private static final long serialVersionUID = 2315861607687624378L;
	
	private static final String RESTFUL_URI = "http://127.0.0.1:8091/items";

	public List<JsonNode> recoversAllItemsExpressedAsJsonNodes() {
		final RequestHeadersSpec<?> requestHeadersSpec = WebClient
				.create()
				.get()
				.uri(RESTFUL_URI);
		return requestHeadersSpec
				.retrieve()
				.toEntityList(JsonNode.class)
				.block()
				.getBody();
	}
}
