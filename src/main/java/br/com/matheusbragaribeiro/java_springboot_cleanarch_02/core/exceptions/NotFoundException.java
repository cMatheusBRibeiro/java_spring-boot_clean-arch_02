package br.com.matheusbragaribeiro.java_springboot_cleanarch_02.core.exceptions;

public class NotFoundException extends RuntimeException {

    public NotFoundException(String message) {
        super(message);
    }

}
