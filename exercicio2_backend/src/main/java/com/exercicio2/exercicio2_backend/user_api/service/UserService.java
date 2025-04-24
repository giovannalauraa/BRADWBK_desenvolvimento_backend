package com.exercicio2.exercicio2_backend.user_api.service;

import com.exercicio2.exercicio2_backend.user_api.model.User;
import com.exercicio2.exercicio2_backend.user_api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> listarTodos() {
        return userRepository.findAll();
    }

    public Optional<User> buscarPorLogin(String login) {
        return userRepository.findById(login);
    }

    public User salvar(User user) {
        return userRepository.save(user);
    }

    public User atualizar(String login, User user) {
        if (!userRepository.existsById(login)) {
            throw new RuntimeException("Usuário não encontrado com login: " + login);
        }
        user.setLogin(login);
        return userRepository.save(user);
    }

    public void deletar(String login) {
        if (!userRepository.existsById(login)) {
            throw new RuntimeException("Usuário não encontrado com login: " + login);
        }
        userRepository.deleteById(login);
    }
}
