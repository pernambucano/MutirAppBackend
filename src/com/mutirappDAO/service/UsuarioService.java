package com.mutirappDAO.service;

import java.util.List;

import com.mutirappDAO.model.Acao;
import com.mutirappDAO.model.Usuario;

public interface UsuarioService {
	public List<Acao> listarAcoes(String email);
	public Usuario getUsuarioByEmail(String email);
	public void cadastrarUsuario(Usuario usuario);
	public void alterarUsuario(Usuario usuario);
}
