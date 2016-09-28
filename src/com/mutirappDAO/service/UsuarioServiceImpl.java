package com.mutirappDAO.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mutirappDAO.model.Acao;
import com.mutirappDAO.model.Interesse;
import com.mutirappDAO.model.Usuario;
import com.mutirappDAO.repository.UsuarioRepository;

@Service
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
		return usuarioRepository.findByEmail(email);
	}

	@Override
	public void cadastrarUsuario(Usuario usuario) {
		usuarioRepository.save(usuario);
	}

	@Override
	public void alterarUsuario(Usuario usuario) {
		// alterar usuario
	}

	@Override
	public void deleteUsuarioByEmail(String email) {
		usuarioRepository.delete(usuarioRepository.findByEmail(email));
	}
	
	public List<Acao> getAcoesCadastradasPorEmail(String email){
		int user_id = usuarioRepository.findByEmail(email).getId();
		List<Object> lista =usuarioRepository.getAcoesCriadasById(user_id);
		List<Acao> listaDeAcoes = new ArrayList<Acao>();
		for (Object o: lista){
			listaDeAcoes.add(((Acao)o));
		}
		
		return listaDeAcoes;
	}

	@Override
	public List<Acao> getAcoesInteressadasPorEmail(String email) {
		int user_id = usuarioRepository.findByEmail(email).getId();
		List<Object> lista =usuarioRepository.getAcoesInteressadasById(user_id);
		List<Acao> listaDeAcoes = new ArrayList<Acao>();
		for (Object o: lista){
			listaDeAcoes.add(((Interesse)o).getAcao());
		}
		
		return listaDeAcoes;
	}

	@Override
	public void inserirInteresse(Usuario usuario, Acao acao, Date data) {
		Interesse interesse = new Interesse();
		interesse.setUsuario(usuario);
		interesse.setAcao(acao);
		interesse.setData(data);
		
		usuario.getInteresses().add(interesse);
	}
	
	
	
	
}
