package com.mutirappDAO;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.mutirappDAO.model.Acao;
import com.mutirappDAO.model.TipoCategoria;
import com.mutirappDAO.model.TipoStatus;
import com.mutirappDAO.model.Usuario;
import com.mutirappDAO.service.AcaoService;
import com.mutirappDAO.service.UsuarioService;

@SpringBootApplication
public class Application implements CommandLineRunner {
	private static final Logger logger = LoggerFactory.getLogger(Application.class);

	@Autowired
	private UsuarioService usuarioS;

	@Autowired
	private AcaoService acaoS;

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

		// Usuario usuarioS = new Usuario("Bruna magalhaes buffao baudel");
		// usuarioS.setEmail("contatobruna@contato.com");
		// usuarioS.setSenha("12345");
		// usuarioS.setStatus(true);
		//
		//
		// usuarioRepository.save(usuarioS);

		Usuario usuarioY = new Usuario("Wolowits");
		usuarioY.setEmail("contatowolowits@contato.com");
		usuarioY.setSenha("12345");
		usuarioY.setStatus(true);

//		usuarioRepository.save(usuarioY);
		usuarioS.cadastrarUsuario(usuarioY);

		Usuario usuarioX = new Usuario("Leonard");
		usuarioX.setEmail("contatoleonard@contato.com");
		usuarioX.setSenha("12345");
		usuarioX.setStatus(true);

//		usuarioRepository.save(usuarioX);
		usuarioS.cadastrarUsuario(usuarioX);


		Usuario usuarioZ = new Usuario("Sheldon");
		usuarioZ.setEmail("contatosheldon@contato.com");
		usuarioZ.setSenha("12345");
		usuarioZ.setStatus(true);

//		usuarioRepository.save(usuarioZ);
		usuarioS.cadastrarUsuario(usuarioZ);


		Usuario usuarioB = new Usuario("Fagner");
		usuarioB.setEmail("contatofagner@contato.com");
		usuarioB.setSenha("123456");
		usuarioB.setStatus(true);

//		usuarioRepository.save(usuarioA);
//		usuarioRepository.save(usuarioB);
		
		usuarioS.cadastrarUsuario(usuarioA);
		usuarioS.cadastrarUsuario(usuarioB);


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
		acaoA.setEndReferencia("Fica por pr�ximo ao lugar por ai");
		acaoA.setEndCep("50000000");
		acaoA.setDataOcorrencia(new Date());
		acaoA.setDataCadastro(new Date());
		acaoA.setCategoria(TipoCategoria.MEIO_AMBIENTE);
		acaoA.setStatus(TipoStatus.EM_ABERTO);
		acaoA.setUsuario(usuarioA);

		Acao acaoB = new Acao("Vazamento de �gua");
		acaoB.setDescricao("Necessario a para realizarmos a a��o.");
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
		acaoB.setUsuario(usuarioB); // Banco salva?

		
//		acaoRepository.save(acaoB);
//		acaoRepository.save(acaoA);
		
		
		acaoS.cadastrarAcao(acaoA);
		acaoS.cadastrarAcao(acaoB);
		
		
		System.out.println("Descricao de Limpar Jardim"+ acaoS.getAcaoByTitulo("Limpar Jardim").getDescricao());
		System.out.println("Imprimindo as ultimas acoes");
		List<Acao> lista1 = acaoS.getUltimasAcoes();
		for(Acao a : lista1){
			System.out.println(a.getTitulo());
		}

		
		System.out.println("Imprimindo as todas acoes");
		List<Acao> lista2 = acaoS.listarTodasAcoes();
		for(Acao a : lista2){
			System.out.println(a.getTitulo());
		}
		
		
		/*
		 * Interesseres
		 * 
		 */
		
//		Interesse intA = new Interesse();
//		intA.setUsuario(usuarioA);
//		intA.setAcao(acaoB);
//		intA.setData(new Date());
//
//		Interesse intB = new Interesse();
//		intB.setUsuario(usuarioB);
//		intB.setAcao(acaoA);
//		intB.setData(new Date());
//
//		Interesse intC = new Interesse();
//		intC.setUsuario(usuarioX);
//		intC.setAcao(acaoB);
//		intC.setData(new Date());
//
//		Interesse intD = new Interesse();
//		intD.setUsuario(usuarioX);
//		intD.setAcao(acaoA);
//		intD.setData(new Date());

//		usuarioA.getInteresses().add(intA);
//		usuarioB.getInteresses().add(intB);

		// usuarioX.getInteresses().add(intC); // repetido
//		usuarioX.getInteresses().add(intD); // repetido

//		usuarioX.getInteresses().add(intC);

		usuarioS.inserirInteresse(usuarioA, acaoB, new Date());
		usuarioS.inserirInteresse(usuarioB, acaoA, new Date());
		usuarioS.inserirInteresse(usuarioX, acaoB, new Date());


		
		// imprimir as acoes criadas usando a query
		System.out.println("Acoes Criadas de " + usuarioA.getName());
		List<Acao> listaCriadas = usuarioS.getAcoesCadastradasPorEmail(usuarioA.getEmail());
		for (Acao a : listaCriadas) {
			System.out.println(a.getTitulo());
		}

		// imprimir as acoes criadas usando a query
		System.out.println("Acoes Interessadas de " + usuarioA.getName());
		List<Acao> listaInteressadas = usuarioS.getAcoesInteressadasPorEmail(usuarioA.getEmail());
		for (Acao a : listaInteressadas) {
			System.out.println(a.getTitulo());
		}

	}

}
