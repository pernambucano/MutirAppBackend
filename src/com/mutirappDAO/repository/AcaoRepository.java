package com.mutirappDAO.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;

import com.mutirappDAO.model.Acao;

public interface AcaoRepository  extends CrudRepository<Acao, Integer>{
	// criar servico que pega as 10 acoes mais recentes
	public Acao findByTitulo(String titulo);
	public List<Acao> findFirst10ByOrderByTituloAsc();
}
