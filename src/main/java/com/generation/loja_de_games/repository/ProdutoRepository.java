package com.generation.loja_de_games.repository;


import com.generation.loja_de_games.model.Produtos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProdutoRepository extends JpaRepository<Produtos, Long> {

    public List<Produtos> findAllByNomeContainingIgnoreCase(@Param("nome") String nome);

    public List<Produtos> findAllByPrecoGreaterThanOrderBOrderByPreco(float preco);
    public List<Produtos> findAllByPrecoLessThanOrderByPrecoDesc(float preco);
}
