package com.mutirappDAO.repository;

import org.springframework.data.repository.CrudRepository;

import com.mutirappDAO.model.Acao;

public interface AcaoRepository  extends CrudRepository<Acao, Integer>{
	// criar servico que pega as 10 acoes mais recentes
}
