package com.resoft.helpdesk.domain;

import java.util.HashSet;
import java.util.Set;

import com.resoft.helpdesk.domain.enums.Perfil;

public abstract class Pessoa {
	
	protected Integer id;
	protected String nome;
	protected String cpf;
	protected String email;
	protected String senha;
	protected Set<Perfil> perfis = new HashSet<>();

}
