package br.com.matheusbragaribeiro.java_springboot_cleanarch_02.core.usecases.Authentication.impl;

import br.com.matheusbragaribeiro.java_springboot_cleanarch_02.core.entities.ChangePassword;
import br.com.matheusbragaribeiro.java_springboot_cleanarch_02.core.exceptions.NotFoundException;
import br.com.matheusbragaribeiro.java_springboot_cleanarch_02.core.gateways.AuthenticationGateway;
import br.com.matheusbragaribeiro.java_springboot_cleanarch_02.core.gateways.UserGateway;
import br.com.matheusbragaribeiro.java_springboot_cleanarch_02.core.usecases.Authentication.ChangePasswordCase;

public class ChangePasswordCaseImpl implements ChangePasswordCase {

    private final AuthenticationGateway authenticationGateway;
    private final UserGateway userGateway;

    public ChangePasswordCaseImpl(
            AuthenticationGateway authenticationGateway,
            UserGateway userGateway
    ) {
        this.authenticationGateway = authenticationGateway;
        this.userGateway = userGateway;
    }

    @Override
    public void run(Long userId, ChangePassword changePassword) {
        var user = userGateway
                .findUserById(userId)
                .orElseThrow(() -> new NotFoundException("User not found"));

        var currentPasswordEncrypted = authenticationGateway
                .encryptPassword(changePassword.getCurrentPassword());
        var newPasswordEncrypted = authenticationGateway
                .encryptPassword(changePassword.getNewPassword());
        var confirmPasswordEncrypted = authenticationGateway
                .encryptPassword(changePassword.getConfirmPassword());

        user.updatePassword(new ChangePassword(
                currentPasswordEncrypted,
                newPasswordEncrypted,
                confirmPasswordEncrypted
        ));

        userGateway.updateUser(user);
    }

}
