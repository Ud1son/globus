package ru.udisondev.globus.producer.api;

import lombok.Data;
import ru.udisondev.globus.user.model.CreateUserRequest;

@Data
public class CreateProducerRequest {

    private CreateUserRequest userData;
    private String organizationInn;
}
