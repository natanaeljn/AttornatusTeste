package com.attornatusVaga.Teste.Servicos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.attornatusVaga.Excecao.ExcecaoPessoa;
import com.attornatusVaga.Teste.Entidades.Endereco;
import com.attornatusVaga.Teste.Entidades.Pessoa;
import com.attornatusVaga.Teste.Repositorios.EnderecoRepositorio;
import com.attornatusVaga.Teste.Repositorios.PessoaRepositorio;

@Service
public class EnderecoServicos {

	@Autowired
	private EnderecoRepositorio enderecoRepositorio;
	@Autowired
	private PessoaRepositorio pessoaRepositorio;

	public Endereco criarEndereco(Long id, Endereco endereco) {
		try {

			Assert.notNull(id, "o Id nao pode ser nulo");
			Pessoa pessoa = pessoaRepositorio.findById(id).get();
			endereco.setPessoa(pessoa);
			return enderecoRepositorio.save(endereco);

		} catch (Exception e) {
			throw new ExcecaoPessoa(
					"Erro ao criar novo endereço , verifique se a Pessoa que voçe esta passando esta cadastrada ");
		}
	}

	public List<Endereco> listarEnderecos(Long id) {
		try {
			Assert.notNull(id, "o Id nao pode ser nulo");
			return enderecoRepositorio.buscarEnderecoPorPessoa(id);

		} catch (Exception e) {
			throw new ExcecaoPessoa("Erro ao realizar a consulta  , verifique se a pessoa se o ID esta correto ");
		}
	}

}
