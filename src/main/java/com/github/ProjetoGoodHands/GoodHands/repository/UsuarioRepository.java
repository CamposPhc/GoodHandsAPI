package com.github.ProjetoGoodHands.GoodHands.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.github.ProjetoGoodHands.GoodHands.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

	public Optional<Usuario> findByUsuario(String usuario);

}
