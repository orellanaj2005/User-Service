package com.smartlogix.userservice.controller;

import com.smartlogix.userservice.model.Usuario;
import com.smartlogix.userservice.service.UsuarioService;
import com.smartlogix.userservice.config.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UsuarioService service;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Usuario user) {

        Usuario usuario = service.login(user.getUsername(), user.getPassword());

        String token = JwtUtil.getInstance().generateToken(usuario.getUsername());

        return ResponseEntity.ok(Map.of(
                "token", token
        ));
    }
}