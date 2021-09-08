package br.com.codeguskr.solosidea.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.codeguskr.solosidea.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

	Optional<Usuario> findByEmail(String email);
	
}
