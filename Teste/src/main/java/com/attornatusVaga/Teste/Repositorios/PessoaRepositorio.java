package com.attornatusVaga.Teste.Repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.attornatusVaga.Teste.Entidades.Pessoa;

import jakarta.transaction.Transactional;


@Repository
@Transactional
public interface PessoaRepositorio extends JpaRepository<Pessoa, Long>{
	
	List <Pessoa> findBynome(String nome);


}
