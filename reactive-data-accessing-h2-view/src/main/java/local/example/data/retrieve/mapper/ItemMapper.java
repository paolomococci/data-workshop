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

package local.example.data.retrieve.mapper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import local.example.data.retrieve.representation.Item;

public class ItemMapper {

	public static List<Item> toItemList(List<JsonNode> jsonNodes) 
			throws JsonProcessingException, IOException {
		List<Item> items = new ArrayList<Item>();
		ObjectMapper objectMapper = new ObjectMapper();
		for (JsonNode jsonNode : jsonNodes) {
			items.add(objectMapper.treeToValue(jsonNode, Item.class));
		}
		return items;
	}
}
