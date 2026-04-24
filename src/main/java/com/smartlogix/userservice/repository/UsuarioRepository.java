package com.smartlogix.userservice.repository;

import com.smartlogix.userservice.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    // Buscar usuario por username (para login)
    Optional<Usuario> findByUsername(String username);

}