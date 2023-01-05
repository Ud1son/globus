package ru.udisondev.globus.customer.api;

import org.mapstruct.Mapper;
import ru.udisondev.globus.customer.service.CustomerInfo;

@Mapper(componentModel = "spring")
public interface CustomerApiMapper {
    CustomerDto toDto(CustomerInfo customerInfo);
}
