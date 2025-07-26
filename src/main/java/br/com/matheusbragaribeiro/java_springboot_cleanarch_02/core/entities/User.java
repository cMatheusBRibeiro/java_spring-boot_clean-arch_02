package br.com.matheusbragaribeiro.java_springboot_cleanarch_02.core.entities;

public class User {

    private Long id;
    private String name;
    private String email;
    private String phone;
    private Credentials credentials;

    public User(
            Long id,
            String name,
            String email,
            String phone,
            Credentials credentials
    ) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.credentials = credentials;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public Credentials getCredentials() {
        return credentials;
    }

    public void updatePassword(ChangePassword changePassword) {
        isCurrentPasswordDifferentToUserPassword(changePassword.getCurrentPassword());
        isNewPasswordEqualsToUserPassword(changePassword.getNewPassword());
        isNewPasswordDifferentToConfirmPassword(
                changePassword.getNewPassword(),
                changePassword.getConfirmPassword()
        );

        credentials = new Credentials(
                credentials.getUsername(),
                changePassword.getNewPassword()
        );
    }

    private void isCurrentPasswordDifferentToUserPassword(String currentPassword) {
        if (!credentials.getPassword().equals(currentPassword)) {
            throw new RuntimeException("Current password is incorrect");
        }
    }

    private void isNewPasswordEqualsToUserPassword(String newPassword) {
        if (credentials.getPassword().equals(newPassword)) {
            throw new RuntimeException("Current password is incorrect");
        }
    }

    private void isNewPasswordDifferentToConfirmPassword(String newPassword, String confirmPassword) {
        if (!newPassword.equals(confirmPassword)) {
            throw new RuntimeException("Current password is incorrect");
        }
    }
}
