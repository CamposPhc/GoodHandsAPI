package com.github.ProjetoGoodHands.GoodHands.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.github.ProjetoGoodHands.GoodHands.model.TemaPostagem;


public interface TemaPostagemRepository extends JpaRepository<TemaPostagem, Long>{
	
	public List<TemaPostagem> findAllByCausaContainingIgnoreCase(@Param("causa") String causa);

}
