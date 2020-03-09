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

import java.net.URISyntaxException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import local.example.data.assembler.PlayerRepresentationModelAssembler;
import local.example.data.entity.Player;
import local.example.data.exception.PlayerNotFoundException;
import local.example.data.repository.PlayerRepository;

@RepositoryRestController
@RequestMapping(path = "/api/players")
public class PlayerRestController {

	@Autowired
	PlayerRepository playerRepository;
	
	@Autowired
	PlayerRepresentationModelAssembler playerRepresentationModelAssembler;
	
	@PostMapping
	public ResponseEntity<?> create(@RequestBody Player player) 
			throws URISyntaxException {
		EntityModel<Player> entityModelOfPlayer;
		entityModelOfPlayer = playerRepresentationModelAssembler
				.toModel(playerRepository.save(player));
		return new ResponseEntity<>(entityModelOfPlayer, HttpStatus.CREATED);
	}
	
	@GetMapping(path = "/{id}")
	public ResponseEntity<?> read(@PathVariable Long id) 
			throws URISyntaxException {
		var player = playerRepository.findById(id)
				.orElseThrow(() -> new PlayerNotFoundException(id));
		EntityModel<Player> entityModelOfPlayer;
		entityModelOfPlayer = playerRepresentationModelAssembler.toModel(player);
		return new ResponseEntity<>(entityModelOfPlayer, HttpStatus.OK);
	}
	
	@GetMapping(path = "/nicknames/{nickname}")
	public ResponseEntity<?> readByNickname(@PathVariable String nickname) 
			throws URISyntaxException {
		Iterable<Player> players = playerRepository.findByNickname(nickname);
		CollectionModel<EntityModel<Player>> collectionModelOfPlayers;
		collectionModelOfPlayers = playerRepresentationModelAssembler
				.toCollectionModel(players);
		return new ResponseEntity<>(collectionModelOfPlayers, HttpStatus.OK);
	}
	
	@GetMapping
	public ResponseEntity<?> readAll() 
			throws URISyntaxException {
		Iterable<Player> players = playerRepository.findAll();
		CollectionModel<EntityModel<Player>> collectionModelOfPlayers;
		collectionModelOfPlayers = playerRepresentationModelAssembler
				.toCollectionModel(players);
		return new ResponseEntity<>(collectionModelOfPlayers, HttpStatus.OK);
	}
	
	@PutMapping(path = "/{id}")
	public ResponseEntity<?> putUpdate(
			@RequestBody Player playerUpdated, 
			@PathVariable Long id) 
			throws URISyntaxException {
		var temporaryEntityOfPlayer = playerRepository.findById(id)
				.map(player -> {
					player.setNickname(playerUpdated.getNickname());
					return playerRepository.save(player);
				})
				.orElseGet(() -> {
					return playerRepository.save(playerUpdated);
				});
		EntityModel<Player> entityModelOfPlayer;
		entityModelOfPlayer = playerRepresentationModelAssembler
				.toModel(temporaryEntityOfPlayer);
		return new ResponseEntity<>(entityModelOfPlayer, HttpStatus.OK);
	}
	
	@DeleteMapping(path = "/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) 
			throws URISyntaxException {
		playerRepository.deleteById(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
