package br.com.matheusbragaribeiro.java_springboot_cleanarch_02.core.gateways;

import br.com.matheusbragaribeiro.java_springboot_cleanarch_02.core.entities.User;

import java.util.Optional;

public interface UserGateway {
    Optional<User> findUserByUsernameAndPassword(String username, String password);

    Optional<User> findUserById(Long userId);

    User updateUser(User user);

    User createUser(User user);
}
