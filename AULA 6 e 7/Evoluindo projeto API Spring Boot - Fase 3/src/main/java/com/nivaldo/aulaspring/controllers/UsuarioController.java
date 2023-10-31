package com.nivaldo.aulaspring.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nivaldo.aulaspring.entities.Usuario;
import com.nivaldo.aulaspring.services.UsuarioService;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping(value = "/usuario")
public class UsuarioController {
	
	@Autowired
	private UsuarioService service;

	@Operation(
			summary="Lista de usuários",
			description="Esse método retorna uma lista de usuários")
	@GetMapping
	public ResponseEntity<List<Usuario>> procuraTodos() {
		List<Usuario> listaDeUsuario = service.procuraTodos();
		return ResponseEntity.status(HttpStatus.OK).body(listaDeUsuario);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Usuario> procuraPorId(@PathVariable Integer id) {
		Usuario response = service.procuraPorId(id);
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}
	
	@PostMapping
	public ResponseEntity<String> adicionaUsuario(@RequestBody Usuario usuario) {
		String response = service.adicionaUsuario(usuario);
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<String> editarUsuario(@PathVariable Integer id, @RequestBody Usuario usuario) {
		String response = service.editarUsuario(id, usuario);
		return ResponseEntity.status(200).body(response);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> excluirUsuario(@PathVariable Integer id) {
		service.excluirUsuario(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
}
