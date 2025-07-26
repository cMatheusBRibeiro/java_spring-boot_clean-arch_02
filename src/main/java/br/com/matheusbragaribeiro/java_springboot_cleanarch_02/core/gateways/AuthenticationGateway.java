package br.com.matheusbragaribeiro.java_springboot_cleanarch_02.core.gateways;

import br.com.matheusbragaribeiro.java_springboot_cleanarch_02.entities.Token;

public interface AuthenticationGateway {
    Token createToken(Object user);

    String encryptPassword(String password);
}
