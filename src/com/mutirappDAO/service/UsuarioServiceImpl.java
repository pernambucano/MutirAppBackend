package com.mutirappDAO.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.mutirappDAO.model.Acao;
import com.mutirappDAO.model.Usuario;
import com.mutirappDAO.repository.UsuarioRepository;

public class UsuarioServiceImpl implements UsuarioService {
	@Autowired
	private UsuarioRepository usuarioRepository;

	@Override
	public List<Acao> listarAcoes(String email) {
		List<Acao> lista =  (List<Acao>) usuarioRepository.findByEmail(email).getAcoes();
		return lista;
	}

	@Override
	public Usuario getUsuarioByEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void cadastrarUsuario(Usuario usuario) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void alterarUsuario(Usuario usuario) {
		// TODO Auto-generated method stub
		
	}
}
