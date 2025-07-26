package br.com.matheusbragaribeiro.java_springboot_cleanarch_02.entities;

public class Token {

    private String type;
    private String token;

    public Token(String type, String token) {
        this.type = type;
        this.token = token;
    }

    public String getType() {
        return type;
    }

    public String getToken() {
        return token;
    }

}
