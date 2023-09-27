package com.attornatusVaga.Teste.Dto;

import com.attornatusVaga.Teste.Entidades.Endereco;

public record EnderecoDto(Long id , String logradouro , String cep , Integer numero , String cidade ,  boolean principal) {
	
	public EnderecoDto (Endereco endereco) {
		this(endereco.getId() , endereco.getLogradouro() , endereco.getCep() , endereco.getNumero() , endereco.getCidade() ,  endereco.isPrincipal());
				
	}

}
