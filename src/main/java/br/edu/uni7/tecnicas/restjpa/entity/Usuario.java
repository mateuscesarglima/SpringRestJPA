package br.edu.uni7.tecnicas.restjpa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Usuario {
	public static enum StatusType {
		Ativo, Bloqueado, Desativado
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@Column(unique = true)
	private String login;
	private String senha;

	@Enumerated(EnumType.STRING)
	private StatusType status;

	public Usuario() {
		this(null, "", "");
	}

	public Usuario(Integer id, String login, String senha) {
		this.id = id;
		this.login = login;
		this.senha = senha;
		this.status = StatusType.Bloqueado;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public StatusType getStatus() {
		return status;
	}

	public void setStatus(StatusType status) {
		this.status = status;
	}
}
