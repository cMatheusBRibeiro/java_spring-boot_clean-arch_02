package br.com.matheusbragaribeiro.java_springboot_cleanarch_02.core.usecases.Authentication;

import br.com.matheusbragaribeiro.java_springboot_cleanarch_02.core.entities.Credentials;
import br.com.matheusbragaribeiro.java_springboot_cleanarch_02.entities.Token;

public interface LoginCase {

    Token run(Credentials credentials);

}
