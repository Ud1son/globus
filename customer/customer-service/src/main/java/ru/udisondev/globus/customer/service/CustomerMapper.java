package ru.udisondev.globus.customer.service;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import ru.udisondev.globus.persistence.customer.Customer;

@Mapper(componentModel = "spring")
public interface CustomerMapper {

    @Mappings({
            @Mapping(target = "id", ignore = true),
            @Mapping(target = "creationDateTime", ignore = true),
            @Mapping(target = "lastUpdateDateTime", ignore = true),
    })
    Customer toEntity(CustomerDataProvider customer);

    CustomerInfo toDto(Customer customer);
}
