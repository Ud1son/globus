package ru.udisondev.globus.exception;

public class OrganizationIsExistException extends RuntimeException {

    private OrganizationIsExistException(String message) {
        super(message);
    }

    public static OrganizationIsExistException byInn(String inn) {
        return new OrganizationIsExistException("Organization with inn: %s is already exist!".formatted(inn));
    }
}
