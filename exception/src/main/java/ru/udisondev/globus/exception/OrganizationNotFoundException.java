package ru.udisondev.globus.exception;

public class OrganizationNotFoundException extends RuntimeException {

    private OrganizationNotFoundException(String message) {
        super(message);
    }

    public static OrganizationNotFoundException byInn(String inn) {
        return new OrganizationNotFoundException("Organization with inn: %s not found!".formatted(inn));

    }
}
