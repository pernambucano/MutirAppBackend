package com.mutirappDAO;

import java.util.Date;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.mutirappDAO.model.Acao;
import com.mutirappDAO.model.Interesse;
import com.mutirappDAO.model.Usuario;
import com.mutirappDAO.repository.AcaoRepository;
import com.mutirappDAO.repository.UsuarioRepository;

@SpringBootApplication
public class Application implements CommandLineRunner{
	private static final Logger logger = LoggerFactory.getLogger(Application.class);
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private AcaoRepository acaoRepository;
	

	public static void main(String[] args) throws Exception {
		SpringApplication.run(Application.class, args);
	}


	@Override
	@Transactional
	public void run(String... arg0) throws Exception {
		Usuario usuarioA = new Usuario("Paulo");
		
		Acao acaoA = new Acao("Limpar Jardim");
		
		Interesse i = new Interesse();
		i.setUsuario(usuarioA);
		i.setAcao(acaoA);
		i.setData(new Date());
		
		usuarioA.getInteresses().add(i); // cascade = CascadeType.All
		
		acaoRepository.save(acaoA);
		usuarioRepository.save(usuarioA);
		
	}

	
}
