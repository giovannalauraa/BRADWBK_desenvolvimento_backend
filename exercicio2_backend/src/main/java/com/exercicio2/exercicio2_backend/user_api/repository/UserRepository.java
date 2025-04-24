package com.exercicio2.exercicio2_backend.user_api.repository;

import com.exercicio2.exercicio2_backend.user_api.model.User;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class UserRepository {
    private final Map<String, User> usuarios = new HashMap<>();

    public List<User> findAll() {
        return new ArrayList<>(usuarios.values());
    }

    public Optional<User> findById(String login) {
        return Optional.ofNullable(usuarios.get(login));
    }

    public User save(User user) {
        usuarios.put(user.getLogin(), user);
        return user;
    }

    public void deleteById(String login) {
        usuarios.remove(login);
    }

    public boolean existsById(String login) {
        return usuarios.containsKey(login);
    }
}
