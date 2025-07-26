package br.com.matheusbragaribeiro.java_springboot_cleanarch_02.core.usecases.User;

import br.com.matheusbragaribeiro.java_springboot_cleanarch_02.core.entities.User;

public interface CreateUserCase {

    User createUser(User user);

}
