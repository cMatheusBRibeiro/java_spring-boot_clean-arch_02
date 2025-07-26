package br.com.matheusbragaribeiro.java_springboot_cleanarch_02.core.entities;

public class ChangePassword {

    private final String currentPassword;
    private final String newPassword;
    private final String confirmPassword;

    public ChangePassword(
            String currentPassword,
            String newPassword,
            String confirmPassword
    ) {
        this.currentPassword = currentPassword;
        this.newPassword = newPassword;
        this.confirmPassword = confirmPassword;
    }

    public String getCurrentPassword() {
        return currentPassword;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

}
