package ru.udisondev.globus.customer.api;

import lombok.Data;
import ru.udisondev.globus.user.model.CreateUserRequest;

@Data
public class CreateCustomerRequest {

    private CreateUserRequest userData;
    private String organizationInn;

}
