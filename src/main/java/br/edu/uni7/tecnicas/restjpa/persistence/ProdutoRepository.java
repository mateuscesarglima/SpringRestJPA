package br.edu.uni7.tecnicas.restjpa.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.uni7.tecnicas.restjpa.entity.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Integer>{

}
