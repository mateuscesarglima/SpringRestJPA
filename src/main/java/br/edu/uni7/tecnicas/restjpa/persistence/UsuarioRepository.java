package br.edu.uni7.tecnicas.restjpa.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.uni7.tecnicas.restjpa.entity.Usuario;
import br.edu.uni7.tecnicas.restjpa.entity.Usuario.StatusType;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
	public Usuario findByLoginAndStatus(String login, StatusType statusType);
}
