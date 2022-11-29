package com.generation.loja_de_games.controller;

import com.generation.loja_de_games.model.Produtos;
import com.generation.loja_de_games.repository.CategoriaRepository;
import com.generation.loja_de_games.repository.ProdutoRepository;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/produtos")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ProdutosController {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private CategoriaRepository categoriaRepository;


    @GetMapping
    public ResponseEntity<List<Produtos>> getAll (){
        return ResponseEntity.ok(produtoRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Produtos> getById(@PathVariable Long id) {
        return produtoRepository.findById(id)
                .map(resposta -> ResponseEntity.ok(resposta))
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/nome/{nome}")
    public ResponseEntity<List<Produtos>> getByTitulo(@PathVariable String titulo){
        return ResponseEntity.ok(produtoRepository.findAllByNomeContainingIgnoreCase(titulo));
    }


    @PostMapping
    public ResponseEntity<Produtos> postPostagem(@Valid @RequestBody Produtos produtos){
        return ResponseEntity.status(HttpStatus.CREATED).body(produtoRepository.save(produtos));
    }

    @PutMapping
    public ResponseEntity<Produtos> putPostagem (@Valid @RequestBody Produtos produtos){
        return produtoRepository.findById((produtos.getId()))
                .map(resposta -> ResponseEntity.status(HttpStatus.OK)
                        .body(produtoRepository.save(produtos)))
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id) {
        Optional<Produtos> produtos = produtoRepository.findById(id);

        if(produtos.isEmpty())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        produtoRepository.deleteById(id);
    }


}
