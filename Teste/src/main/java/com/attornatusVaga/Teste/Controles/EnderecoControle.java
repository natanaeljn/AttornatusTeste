package com.attornatusVaga.Teste.Controles;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.attornatusVaga.Teste.Entidades.Endereco;
import com.attornatusVaga.Teste.Servicos.EnderecoServicos;

@RestController
@RequestMapping("/endereco")
public class EnderecoControle {

	@Autowired
	private EnderecoServicos enderecoServicos;

	@PostMapping("/criarEndereco")
	public ResponseEntity<Endereco> criarEnd(@RequestParam("idPessoa") Long idPessoa, @RequestBody Endereco endereco) {

		return ResponseEntity.ok(this.enderecoServicos.criarEndereco(idPessoa, endereco));
	}

	@GetMapping("/listarEnderecos")
	public ResponseEntity<List<Endereco>> listarEnderecos(@RequestParam("id") Long id) {
		return ResponseEntity.status(HttpStatus.OK).body(this.enderecoServicos.listarEnderecos(id));
	}

}
