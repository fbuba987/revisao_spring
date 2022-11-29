package com.generation.loja_de_games.repository;

import com.generation.loja_de_games.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

    public List<Categoria>findAllByTipoContainingIgnoreCase(@Param("tipo") String tipo);

}
