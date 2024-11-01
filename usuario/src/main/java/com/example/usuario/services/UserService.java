package com.example.usuario.services;

import java.util.List;

import javax.management.RuntimeErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.usuario.entities.User;
import com.example.usuario.repositories.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;

    @Transactional
    public User create(User user) {
        User userCriado = repository.save(user);
        return userCriado;
    }

    public User read(Long id) {
        return repository.findById(id).orElse(null);
    }

    public List<User> list() {
        List<User> users = (List<User>) repository.findAll();
        return users;
    }

    @Transactional
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Transactional
    public User update(User user) {
        if (repository.existsById(user.getId())) {
            return repository.save(user);
        } else {
            return null;
        }
    }
}
