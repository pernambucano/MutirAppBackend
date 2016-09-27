package com.mutirappDAO.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Acao {
	private int id;
	private Usuario usuario;
	private TipoCategoria Categoria;
	private String titulo;
	private String descricao;
	private Date dataCadastro;
	private Date dataOcorrencia;
	private String endCep;
	private String endUf;
	private String endCidade;
	private String endRua;
	private String endBairro;
	private String endReferencia;
	private TipoStatus status;
	private String observacoes;
	private Set<Interesse> interesses;
	
	public Acao(){}
	
	public Acao(String titulo){
		this.titulo = titulo;
		interesses = new HashSet<>();
	}

	@OneToMany(mappedBy = "acao")
	public Set<Interesse> getInteresses() {
		return interesses;
	}

	public void setInteresses(Set<Interesse> interesses) {
		this.interesses = interesses;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@ManyToOne
	@JoinColumn(name = "usuario_id")
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public TipoCategoria getCategoria() {
		return Categoria;
	}

	public void setCategoria(TipoCategoria categoria) {
		Categoria = categoria;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Date getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public Date getDataOcorrencia() {
		return dataOcorrencia;
	}

	public void setDataOcorrencia(Date dataOcorrencia) {
		this.dataOcorrencia = dataOcorrencia;
	}

	public String getEndCep() {
		return endCep;
	}

	public void setEndCep(String endCep) {
		this.endCep = endCep;
	}

	public String getEndUf() {
		return endUf;
	}

	public void setEndUf(String endUf) {
		this.endUf = endUf;
	}

	public String getEndCidade() {
		return endCidade;
	}

	public void setEndCidade(String endCidade) {
		this.endCidade = endCidade;
	}

	public String getEndRua() {
		return endRua;
	}

	public void setEndRua(String endRua) {
		this.endRua = endRua;
	}

	public String getEndBairro() {
		return endBairro;
	}

	public void setEndBairro(String endBairro) {
		this.endBairro = endBairro;
	}

	public String getEndReferencia() {
		return endReferencia;
	}

	public void setEndReferencia(String endReferencia) {
		this.endReferencia = endReferencia;
	}

	public TipoStatus getStatus() {
		return status;
	}

	public void setStatus(TipoStatus status) {
		this.status = status;
	}

	public String getObservacoes() {
		return observacoes;
	}

	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}

}
