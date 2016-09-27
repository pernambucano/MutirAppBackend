package com.mutirappDAO.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Interesse implements Serializable{
	private Usuario usuario;
	private Acao acao;
	private Date data;
	
	public Interesse(){}

	@Id
	@ManyToOne
	@JoinColumn(name = "usuario_id")
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	@Id
	@ManyToOne
	@JoinColumn(name = "acao_id")
	public Acao getAcao() {
		return acao;
	}

	public void setAcao(Acao acao) {
		this.acao = acao;
	}

	@Column(name="data")
	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "Interesse [usuario=" + usuario + ", acao=" + acao + ", data=" + data + "]";
	}
}
