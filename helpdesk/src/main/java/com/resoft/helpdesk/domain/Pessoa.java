package com.resoft.helpdesk.domain;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import com.resoft.helpdesk.domain.enums.Perfil;

import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode
public abstract class Pessoa {

	protected Integer id;
	protected String nome;
	protected String cpf;
	protected String email;
	protected String senha;
	// ele é inicializado para não dar erro de pointexception
	// Set -> apenas um perfil por pessoa, não aceita mais de um.
	// só vou gravar o código
	protected Set<Integer> perfis = new HashSet<>();
	protected LocalDate dataCriacao = LocalDate.now();

	public Pessoa() {
		super();
		//Para cada Pessoa criado inicialmente tem que ser Cliente
		addPerfil(Perfil.CLIENTE);
	}

	public Pessoa(Integer id, String nome, String cpf, String email, String senha) {
		super();
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.email = email;
		this.senha = senha;
		addPerfil(Perfil.CLIENTE);
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

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
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

	public Set<Perfil> getPerfis() {
		// converter a lista de inteiros para Perfil, onde recebo um código e retorno um
		// Perfil
		return perfis.stream().map(x -> Perfil.toEnum(x)).collect(Collectors.toSet());
	}

	// adicionar um perfil na lista
	// por isto tem add
	public void addPerfil(Perfil perfil) {
		this.perfis.add(perfil.getCodigo());
	}

	public LocalDate getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(LocalDate dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

}
