package com.example.usuario.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import com.example.usuario.entities.User;

@SpringBootTest
@ActiveProfiles("test")
@Transactional
public class UserServiceTestI {
    @Autowired
    UserService service;

    @Test
    public void criarUsuarioComSucesso() {
        // GIVEN
        User userDummy = new User();
        userDummy.setEmail("email@gmail.com");
        userDummy.setUsername("username");
        userDummy.setPassword("senha");

        // WHEN
        var userCriado = service.create(userDummy);

        // THEN
        assertNotNull(userCriado);
        assertNotNull(userCriado.getId());
        assertEquals(userDummy.getUsername(), userCriado.getUsername());
        assertEquals(userDummy.getEmail(), userCriado.getEmail());
    }

    @Test
    public void listarUsuarios() {
        // GIVEN
        User userUm = new User();
        userUm.setEmail("email1@gmail.com");
        userUm.setUsername("username1");
        userUm.setPassword("senha1");

        User userDois = new User();
        userDois.setEmail("email2@gmail.com");
        userDois.setUsername("username2");
        userDois.setPassword("senha2");

        service.create(userUm);
        service.create(userDois);

        // WHEN
        List<User> users = service.list();

        // THEN
        assertNotNull(users);
        assertTrue(users.size() >= 2);
        assertTrue(users.stream().anyMatch(u -> u.getUsername().equals("username1")));
        assertTrue(users.stream().anyMatch(u -> u.getUsername().equals("username2")));
    }

    @Test
    public void atualizarUsuario() {
        // GIVEN
        User userUm = new User();
        userUm.setEmail("email1@gmail.com");
        userUm.setUsername("username1");
        userUm.setPassword("senha1");

        User createdUser = service.create(userUm);

        // Atualizando alguns campos obrigatórios
        createdUser.setUsername("updatedUsername");
        createdUser.setEmail("updatedEmail@gmail.com");

        // WHEN
        User updatedUser = service.update(createdUser);

        // THEN
        assertNotNull(updatedUser);
        assertEquals(createdUser.getId(), updatedUser.getId());
        assertEquals("updatedUsername", updatedUser.getUsername());
        assertEquals("updatedEmail@gmail.com", updatedUser.getEmail());
    }

    @Test
    public void deletarUsuario() {
        // GIVEN
        User userUm = new User();
        userUm.setEmail("email1@gmail.com");
        userUm.setUsername("username1");
        userUm.setPassword("senha1");

        User createdUser = service.create(userUm);

        // WHEN
        service.delete(createdUser.getId());
        User deletedUser = service.read(createdUser.getId());

        // THEN
        assertNull(deletedUser);
    }

    @Test
    public void lerUsuarioPorId() {
        // GIVEN
        User userUm = new User();
        userUm.setEmail("email1@gmail.com");
        userUm.setUsername("username1");
        userUm.setPassword("senha1");

        User createdUser = service.create(userUm);

        // WHEN
        User foundUser = service.read(createdUser.getId());

        // THEN
        assertNotNull(foundUser);
        assertEquals(createdUser.getId(), foundUser.getId());
        assertEquals("username1", foundUser.getUsername());
    }
}
