package com.mutirappDAO.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.mutirappDAO.model.Usuario;

public interface UsuarioRepository extends CrudRepository<Usuario, Integer> {
	Usuario findByEmail(String email);
	List<Usuario> findByName(String name);
	
}
