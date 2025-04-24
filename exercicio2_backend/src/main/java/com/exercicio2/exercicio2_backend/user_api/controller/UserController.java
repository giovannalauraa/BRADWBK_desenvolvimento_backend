package com.exercicio2.exercicio2_backend.user_api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.exercicio2.exercicio2_backend.user_api.model.User;
import com.exercicio2.exercicio2_backend.user_api.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> listarUsuarios() {
        return userService.listarTodos();
    }

    @GetMapping("/{login}")
    public User buscarPorLogin(@PathVariable String login) {
        return userService.buscarPorLogin(login)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado com login: " + login));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public User criarUsuario(@RequestBody User user) {
        return userService.salvar(user);
    }

    @PutMapping("/{login}")
    public User atualizarUsuario(@PathVariable String login, @RequestBody User user) {
        return userService.atualizar(login, user);
    }

    @DeleteMapping("/{login}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletarUsuario(@PathVariable String login) {
        userService.deletar(login);
    }
}
