package com.github.ProjetoGoodHands.GoodHands.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.github.ProjetoGoodHands.GoodHands.model.TemaPostagem;
import com.github.ProjetoGoodHands.GoodHands.repository.TemaPostagemRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/temas")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class TemaPostagemController {

@Autowired
private TemaPostagemRepository temaPostagemRepository;

@GetMapping
private ResponseEntity<List<TemaPostagem>> getAll(){
	return ResponseEntity.ok(temaPostagemRepository.findAll());
}
@GetMapping("/{id}")
public ResponseEntity<TemaPostagem> getById(@PathVariable Long id) {
	return temaPostagemRepository.findById(id).map(resposta -> ResponseEntity.ok(resposta))
			.orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
}
@GetMapping("/temas/{causa}")
public ResponseEntity<List<TemaPostagem>> getByCausa(@PathVariable String causa){
	return ResponseEntity.ok(temaPostagemRepository.findAllByCausaContainingIgnoreCase(causa));
	
}
@PostMapping
public ResponseEntity<TemaPostagem> post(@Valid @RequestBody TemaPostagem temapostagem ) {
	return ResponseEntity.status(HttpStatus.CREATED).body(temaPostagemRepository.save(temapostagem));
}
@PutMapping
public ResponseEntity<TemaPostagem> put(@Valid @RequestBody TemaPostagem temapostagem) {
	return temaPostagemRepository.findById(temapostagem.getId())
			.map(resposta -> ResponseEntity.status(HttpStatus.OK).body(temaPostagemRepository.save(temapostagem)))
			.orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
}
@ResponseStatus(HttpStatus.NO_CONTENT)
@DeleteMapping("{id}")
public void delete(@PathVariable Long id) {
	Optional<TemaPostagem> postagem = temaPostagemRepository.findById(id);

	if (postagem.isEmpty())
		throw new ResponseStatusException(HttpStatus.NOT_FOUND);

	temaPostagemRepository.deleteById(id);

}
}
