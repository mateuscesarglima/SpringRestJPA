package br.edu.uni7.tecnicas.restjpa.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Fornecedor {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	private String nome;

	@Column(unique = true)
	private String cnpj;

	@ManyToMany
	@JoinTable(name = "fornecedor_produto", 
		joinColumns = @JoinColumn(name = "fornecedor_id"), 
		inverseJoinColumns = @JoinColumn(name = "produto_id"))
	@JsonIgnore
	private List<Produto> produtos = new ArrayList<Produto>();

	public Fornecedor() {
	}

	public Fornecedor(Integer id, String nome, String cnpj) {
		this.id = id;
		this.nome = nome;
		this.cnpj = cnpj;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}
}
