package br.com.matheusbragaribeiro.java_springboot_cleanarch_02.core.usecases.Authentication.impl;

import br.com.matheusbragaribeiro.java_springboot_cleanarch_02.core.entities.Credentials;
import br.com.matheusbragaribeiro.java_springboot_cleanarch_02.core.exceptions.NotFoundException;
import br.com.matheusbragaribeiro.java_springboot_cleanarch_02.core.gateways.AuthenticationGateway;
import br.com.matheusbragaribeiro.java_springboot_cleanarch_02.core.gateways.UserGateway;
import br.com.matheusbragaribeiro.java_springboot_cleanarch_02.core.usecases.Authentication.LoginCase;
import br.com.matheusbragaribeiro.java_springboot_cleanarch_02.entities.Token;

public class LoginCaseImpl implements LoginCase {

    private final AuthenticationGateway authenticationGateway;
    private final UserGateway userGateway;

    public LoginCaseImpl (
            AuthenticationGateway authenticationGateway,
            UserGateway userGateway
    ) {
        this.authenticationGateway = authenticationGateway;
        this.userGateway = userGateway;
    }

    @Override
    public Token run(Credentials credentials) {
        var user = userGateway
                .findUserByUsernameAndPassword(credentials.getUsername(), credentials.getPassword())
                .orElseThrow(() -> new NotFoundException("User not found"));

        return authenticationGateway.createToken(user);
    }

}
