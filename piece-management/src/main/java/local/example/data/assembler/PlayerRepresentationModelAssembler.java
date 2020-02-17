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

package local.example.data.assembler;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import local.example.data.entity.Player;

@Component
public class PlayerRepresentationModelAssembler 
		implements RepresentationModelAssembler<Player, EntityModel<Player>>{

	@Override
	public EntityModel<Player> toModel(Player player) {
		// TODO
		return null;
	}

	@Override
	public CollectionModel<EntityModel<Player>> toCollectionModel(
			Iterable<? extends Player> players) {
		return RepresentationModelAssembler.super.toCollectionModel(players);
	}
}
