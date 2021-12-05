package br.edu.uni7.tecnicas.restjpa.business;

import java.util.List;

import org.springframework.stereotype.Service;

import br.edu.uni7.tecnicas.restjpa.entity.Usuario;

@Service
public interface UsuarioBusiness {
	public boolean autenticar(String login, String senha);

	public void salvar(Usuario usuario);
	
	public List<Usuario> buscarTodos();
}
