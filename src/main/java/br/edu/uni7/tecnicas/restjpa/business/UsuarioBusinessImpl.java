package br.edu.uni7.tecnicas.restjpa.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.edu.uni7.tecnicas.restjpa.entity.Usuario;
import br.edu.uni7.tecnicas.restjpa.entity.Usuario.StatusType;
import br.edu.uni7.tecnicas.restjpa.persistence.UsuarioRepository;

@Component
public class UsuarioBusinessImpl implements UsuarioBusiness {
	@Autowired
	private UsuarioRepository repository;

	@Override
	public boolean autenticar(String login, String senha) {
		boolean result = false;

		Usuario usuario = repository.findByLoginAndStatus(login, StatusType.Ativo);
		if (usuario != null) {
			if (usuario.getSenha().equals(senha)) {
				result = true;
			}
		}

		return result;
	}

	@Override
	public void salvar(Usuario usuario) {
		repository.save(usuario);
	}

	@Override
	public List<Usuario> buscarTodos() {
		return repository.findAll();
	}
}
