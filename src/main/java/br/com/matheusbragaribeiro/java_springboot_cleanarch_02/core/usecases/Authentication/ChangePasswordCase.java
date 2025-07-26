package br.com.matheusbragaribeiro.java_springboot_cleanarch_02.core.usecases.Authentication;

import br.com.matheusbragaribeiro.java_springboot_cleanarch_02.core.entities.ChangePassword;

public interface ChangePasswordCase {

    void run(Long userId, ChangePassword changePassword);

}
