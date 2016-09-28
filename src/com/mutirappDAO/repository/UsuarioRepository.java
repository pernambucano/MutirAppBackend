package com.mutirappDAO.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.mutirappDAO.model.Usuario;

public interface UsuarioRepository extends CrudRepository<Usuario, Integer> {
	Usuario findByEmail(String email);
	List<Usuario> findByName(String name);
	
	@Query("from Acao where usuario_id = :usuarioId") 
	List<Object> getAcoesCriadasById(@Param("usuarioId") int usuario_id);
	
	
	@Query("from Interesse where usuario_id = :usuarioId")
	List<Object> getAcoesInteressadasById(@Param("usuarioId") int usuarioId);
	
	
}
