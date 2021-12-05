package br.edu.uni7.tecnicas.restjpa.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.edu.uni7.tecnicas.restjpa.entity.Fornecedor;
import br.edu.uni7.tecnicas.restjpa.entity.Produto;
import br.edu.uni7.tecnicas.restjpa.persistence.ProdutoRepository;

@RestController
public class ProdutoController {
	@Autowired
	private ProdutoRepository repository;

	@GetMapping(path = "/produtos")
	public ResponseEntity<List<Produto>> buscarTodos() {
		ResponseEntity<List<Produto>> response = 
				new ResponseEntity<List<Produto>>(HttpStatus.NO_CONTENT);
		
		List<Produto> produtos = repository.findAll();
		if (!produtos.isEmpty()) {
			// response = ResponseEntity.ok(produtos);
			response = new ResponseEntity<List<Produto>>(produtos, HttpStatus.OK);
		} 
		
		return response;
	}

	@PostMapping(path = "/produtos")
	public ResponseEntity<Produto> criar(@RequestParam String nome, @RequestParam Double preco, @RequestBody Fornecedor fornecedor) {
		
		Produto p = new Produto(null, nome, preco);
		
		p.getFornecedores().add(fornecedor);
		fornecedor.getProdutos().add(p);

		repository.save(p);

		return new ResponseEntity<Produto>(HttpStatus.CREATED);
	}

	@DeleteMapping(path = "/produtos/{id}")
	public ResponseEntity<Integer> removerProduto(
			@PathVariable(name = "id") Integer id) {
		ResponseEntity<Integer> response = null;
		
		Optional<Produto> fromDB = repository.findById(id);
		if (fromDB.isPresent()) {
			repository.deleteById(id);

			response = ResponseEntity.ok(id);
		} else {
			response = new ResponseEntity<Integer>(HttpStatus.NOT_FOUND);
		}

		return response;
	}

	@PutMapping(path = "/produtos")
	public ResponseEntity<Produto> atualizar(@RequestBody Produto produto) {
		ResponseEntity<Produto> response = 
				new ResponseEntity<Produto>(HttpStatus.NOT_FOUND);
		
		Optional<Produto> fromDB = repository.findById(produto.getId());
		if (fromDB.isPresent()) {
			repository.save(produto);
	
			response = ResponseEntity.ok(produto);
		}
		
		return response;
	}
}
