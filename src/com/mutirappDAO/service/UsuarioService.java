package com.mutirappDAO.service;

import java.util.Date;
import java.util.List;

import com.mutirappDAO.model.Acao;
import com.mutirappDAO.model.Usuario;

public interface UsuarioService {
	public List<Acao> listarAcoes(String email);
	public Usuario getUsuarioByEmail(String email);
	public void cadastrarUsuario(Usuario usuario);
	public void alterarUsuario(Usuario usuario);
	public void deleteUsuarioByEmail(String email);
	public List<Acao> getAcoesCadastradasPorEmail(String email);
	public List<Acao> getAcoesInteressadasPorEmail(String email);
	public void inserirInteresse(Usuario usuario, Acao a, Date data);
	
}
