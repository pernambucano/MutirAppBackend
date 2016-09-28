package com.mutirappDAO.service;

import java.util.Date;
import java.util.List;

import com.mutirappDAO.model.Acao;
import com.mutirappDAO.model.Usuario;

public interface AcaoService {
	public List<Acao> listarTodasAcoes();
	public Acao getAcaoByTitulo(String titulo);
	public void cadastrarAcao(Acao acao);
	public void alterarAcao(Acao acao);
	public void deleteAcaoByTitulo(String titulo);
	public List<Acao> getUltimasAcoes(); // 10 acoes
}
