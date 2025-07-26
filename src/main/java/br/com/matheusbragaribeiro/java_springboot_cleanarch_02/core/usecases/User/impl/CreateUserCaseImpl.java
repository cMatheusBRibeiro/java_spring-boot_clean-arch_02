package br.com.matheusbragaribeiro.java_springboot_cleanarch_02.core.usecases.User.impl;

import br.com.matheusbragaribeiro.java_springboot_cleanarch_02.core.entities.User;
import br.com.matheusbragaribeiro.java_springboot_cleanarch_02.core.gateways.UserGateway;
import br.com.matheusbragaribeiro.java_springboot_cleanarch_02.core.usecases.User.CreateUserCase;

public class CreateUserCaseImpl implements CreateUserCase {

    private final UserGateway userGateway;

    public CreateUserCaseImpl(UserGateway userGateway) {
        this.userGateway = userGateway;
    }

    @Override
    public User createUser(User user) {
        return userGateway.createUser(user);
    }
}
