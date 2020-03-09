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
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import local.example.data.assembler.PieceRepresentationModelAssembler;
import local.example.data.entity.Piece;
import local.example.data.exception.PieceNotFoundException;
import local.example.data.repository.PieceRepository;

@RepositoryRestController
@RequestMapping(path = "/api/pieces")
public class PieceRestController {

	@Autowired
	PieceRepository pieceRepository;
	
	@Autowired
	PieceRepresentationModelAssembler pieceRepresentationModelAssembler;
	
	@PostMapping
	public ResponseEntity<?> create(@RequestBody Piece piece) 
			throws URISyntaxException {
		EntityModel<Piece> entityModelOfPiece;
		entityModelOfPiece = pieceRepresentationModelAssembler
				.toModel(pieceRepository.save(piece));
		return new ResponseEntity<>(entityModelOfPiece, HttpStatus.CREATED);
	}
	
	@GetMapping(path = "/{id}")
	public ResponseEntity<?> read(@PathVariable Long id) 
			throws URISyntaxException {
		var piece = pieceRepository.findById(id)
				.orElseThrow(() -> new PieceNotFoundException(id));
		EntityModel<Piece> entityModelOfPiece;
		entityModelOfPiece = pieceRepresentationModelAssembler.toModel(piece);
		return new ResponseEntity<>(entityModelOfPiece, HttpStatus.OK);
	}
	
	@GetMapping(path = "/titles/{title}")
	public ResponseEntity<?> readByNickname(@PathVariable String title) 
			throws URISyntaxException {
		Iterable<Piece> pieces = pieceRepository.findByTitle(title);
		CollectionModel<EntityModel<Piece>> collectionModelOfPieces;
		collectionModelOfPieces = pieceRepresentationModelAssembler
				.toCollectionModel(pieces);
		return new ResponseEntity<>(collectionModelOfPieces, HttpStatus.OK);
	}
	
	@GetMapping(path = "/acts/{act}")
	public ResponseEntity<?> readByAct(@PathVariable String act) 
			throws URISyntaxException {
		Iterable<Piece> pieces = pieceRepository.findByTitle(act);
		CollectionModel<EntityModel<Piece>> collectionModelOfPieces;
		collectionModelOfPieces = pieceRepresentationModelAssembler
				.toCollectionModel(pieces);
		return new ResponseEntity<>(collectionModelOfPieces, HttpStatus.OK);
	}
	
	@GetMapping(path = "/sessions/{session}")
	public ResponseEntity<?> readBySession(@PathVariable String session) 
			throws URISyntaxException {
		Iterable<Piece> pieces = pieceRepository.findByTitle(session);
		CollectionModel<EntityModel<Piece>> collectionModelOfPieces;
		collectionModelOfPieces = pieceRepresentationModelAssembler
				.toCollectionModel(pieces);
		return new ResponseEntity<>(collectionModelOfPieces, HttpStatus.OK);
	}
	
	@GetMapping(path = "/scripts/{script}")
	public ResponseEntity<?> readByScript(@PathVariable String script) 
			throws URISyntaxException {
		Iterable<Piece> pieces = pieceRepository.findByTitle(script);
		CollectionModel<EntityModel<Piece>> collectionModelOfPieces;
		collectionModelOfPieces = pieceRepresentationModelAssembler
				.toCollectionModel(pieces);
		return new ResponseEntity<>(collectionModelOfPieces, HttpStatus.OK);
	}
	
	@GetMapping
	public ResponseEntity<?> readAll() 
			throws URISyntaxException {
		Iterable<Piece> pieces = pieceRepository.findAll();
		CollectionModel<EntityModel<Piece>> collectionModelOfPieces;
		collectionModelOfPieces = pieceRepresentationModelAssembler
				.toCollectionModel(pieces);
		return new ResponseEntity<>(collectionModelOfPieces, HttpStatus.OK);
	}
	
	@PutMapping(path = "/{id}")
	public ResponseEntity<?> putUpdate(
			@RequestBody Piece pieceUpdated, 
			@PathVariable Long id) 
			throws URISyntaxException {
		var temporaryEntityOfPiece = pieceRepository.findById(id)
				.map(piece -> {
					piece.setTitle(pieceUpdated.getTitle());
					piece.setAct(pieceUpdated.getAct());
					piece.setSession(pieceUpdated.getSession());
					piece.setScript(pieceUpdated.getScript());
					return pieceRepository.save(piece);
				})
				.orElseGet(() -> {
					return pieceRepository.save(pieceUpdated);
				});
		EntityModel<Piece> entityModelOfPiece;
		entityModelOfPiece = pieceRepresentationModelAssembler
				.toModel(temporaryEntityOfPiece);
		return new ResponseEntity<>(entityModelOfPiece, HttpStatus.OK);
	}
	
	@PatchMapping(path = "/{id}")
	public ResponseEntity<?> patchUpdate(
			@RequestBody Piece pieceUpdated, 
			@PathVariable Long id) 
			throws URISyntaxException {
		var temporaryEntityOfPiece = pieceRepository.findById(id)
				.map(piece -> {
					if (pieceUpdated.getTitle() != null) {
						piece.setTitle(pieceUpdated.getTitle());
					}
					if (pieceUpdated.getAct() != null) {
						piece.setAct(pieceUpdated.getAct());
					}
					if (pieceUpdated.getSession() != null) {
						piece.setSession(pieceUpdated.getSession());
					}
					if (pieceUpdated.getScript() != null) {
						piece.setScript(pieceUpdated.getScript());
					}
					return pieceRepository.save(piece);
				})
				.orElseGet(() -> {
					return pieceRepository.save(pieceUpdated);
				});
		EntityModel<Piece> entityModelOfPiece;
		entityModelOfPiece = pieceRepresentationModelAssembler
				.toModel(temporaryEntityOfPiece);
		return new ResponseEntity<>(entityModelOfPiece, HttpStatus.OK);
	}
	
	@DeleteMapping(path = "/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) 
			throws URISyntaxException {
		pieceRepository.deleteById(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
