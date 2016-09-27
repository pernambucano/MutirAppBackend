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
import com.mutirappDAO.model.TipoCategoria;
import com.mutirappDAO.model.TipoStatus;
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
		/*
		 * Usuarios
		 * 
		 */
		Usuario usuarioA = new Usuario("Bruna");
		usuarioA.setEmail("contatobruna@contato.com");
		usuarioA.setSenha("12345");
		usuarioA.setStatus(true);
		
		
		Usuario usuarioB = new Usuario("Fagner");
		usuarioB.setEmail("contatofagner@contato.com");
		usuarioB.setSenha("123456");
		usuarioB.setStatus(true);
		
		
		/*
		 * acoes
		 * 
		 */
		Acao acaoA = new Acao("Limpar Jardim");
		acaoA.setDescricao("Necessario que seja realizada uma capinagem, e podagem do local informado.");
		acaoA.setEndBairro("Iputinga");
		acaoA.setEndCidade("Recife");
		acaoA.setEndRua("Rua da Oportunidade de fazer algo");
		acaoA.setEndUf("PE");
		acaoA.setEndReferencia("Fica por próximo ao lugar por ai");
		acaoA.setEndCep("50000000");
		acaoA.setDataOcorrencia(new Date());
		acaoA.setDataCadastro(new Date());
		acaoA.setCategoria(TipoCategoria.MEIO_AMBIENTE);
		acaoA.setStatus(TipoStatus.EM_ABERTO);
		acaoA.setUsuario(usuarioA);
		
		
		Acao acaoB = new Acao("Vazamento de àgua");
		acaoB.setDescricao("Necessario a para realizarmos a ação.");
		acaoB.setEndBairro("Boa vista");
		acaoB.setEndCidade("Recife");
		acaoB.setEndRua("Rua da qualquer");
		acaoB.setEndUf("PE");
		acaoB.setEndReferencia("Fica por ali");
		acaoB.setEndCep("5000011");
		acaoB.setDataOcorrencia(new Date());
		acaoB.setDataCadastro(new Date());
		acaoB.setCategoria(TipoCategoria.ANIMAIS);
		acaoB.setStatus(TipoStatus.EM_ABERTO);
		acaoB.setUsuario(usuarioB);  	// Banco salva?
		/*
		 * Interesseres
		 * 
		 */
		Interesse intA = new Interesse();
		intA.setUsuario(usuarioA);
		intA.setAcao(acaoB);
		intA.setData(new Date());
		
		
		Interesse intB = new Interesse();
		intB.setUsuario(usuarioB);
		intB.setAcao(acaoA);
		intB.setData(new Date());
		
		
		usuarioA.getInteresses().add(intA);
		usuarioB.getInteresses().add(intB); 
		
		acaoRepository.save(acaoB);
		acaoRepository.save(acaoA);

		
		usuarioRepository.save(usuarioA); 
		usuarioRepository.save(usuarioB);
		
		
	}

	
}
