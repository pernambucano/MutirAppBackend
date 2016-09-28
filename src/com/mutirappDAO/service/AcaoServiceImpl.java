package com.mutirappDAO.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.mutirappDAO.model.Acao;
import com.mutirappDAO.repository.AcaoRepository;

@Service
public class AcaoServiceImpl implements AcaoService {

	@Autowired
	AcaoRepository acaoRepository;
	
	@Override
	public List<Acao> listarTodasAcoes() {
		return (List<Acao>) acaoRepository.findAll();
	}

	@Override
	public Acao getAcaoByTitulo(String titulo) {
		return acaoRepository.findByTitulo(titulo); 
	}

	@Override
	public void cadastrarAcao(Acao acao) {
		acaoRepository.save(acao);
	}

	@Override
	public void alterarAcao(Acao acao) {
		// TODO Auto-generated method stub
	}

	@Override
	public void deleteAcaoByTitulo(String titulo) {
		acaoRepository.delete(this.getAcaoByTitulo(titulo));
	}

	@Override
	public List<Acao> getUltimasAcoes() {
		return acaoRepository.findFirst10ByOrderByTituloAsc();
	}

}
