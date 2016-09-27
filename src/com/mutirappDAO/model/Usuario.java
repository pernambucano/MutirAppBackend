package com.mutirappDAO.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Usuario {
	private int id;
	private String name;
	private String email;
	private String senha;
	private boolean status;
	private Set<Acao> acoes;
	private Set<Interesse> interesses;

	
	
	public Usuario(){}

	
	public Usuario(String name, String email, String senha, boolean status, Set<Acao> acoes) {
		this.name = name;
		this.email = email;
		this.senha = senha;
		this.status = status;
		this.acoes = acoes;
	}

	@OneToMany(mappedBy = "usuario", cascade=CascadeType.ALL)
	public Set<Acao> getAcoes() {
		return acoes;
	}


	public void setAcoes(Set<Acao> acoes) {
		this.acoes = acoes;
	}


	public Usuario(String name, String email, String senha, boolean status) {
		this.name = name;
		this.email = email;
		this.senha = senha;
		this.status = status;
	}

	public Usuario(String name, String email, String senha) {
		this.name = name;
		this.email = email;
		this.senha = senha;
	}

	public Usuario(String name, String email) {
		this.name = name;
		this.email = email;
	}

	public Usuario(String name) {
		this.name = name;
	}

	@OneToMany(mappedBy = "usuario")
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}


	@Override
	public String toString() {
		return "Usuario [id=" + id + ", name=" + name + ", email=" + email + ", senha=" + senha + ", status=" + status
				+ ", acoes=" + acoes + "]";
	}
	
}
