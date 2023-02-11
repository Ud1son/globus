package ru.udisondev.globus.customer.service;

import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import ru.udisondev.globus.persistence.customer.Customer;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-02-11T20:13:03+0400",
    comments = "version: 1.5.3.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.4.2.jar, environment: Java 17.0.3 (Eclipse Adoptium)"
)
@Component
public class CustomerMapperImpl implements CustomerMapper {

    @Override
    public Customer toEntity(CustomerDataProvider customer) {
        if ( customer == null ) {
            return null;
        }

        Customer customer1 = new Customer();

        customer1.setUserId( customer.getUserId() );
        customer1.setOrganizationId( customer.getOrganizationId() );

        return customer1;
    }

    @Override
    public CustomerInfo toDto(Customer customer) {
        if ( customer == null ) {
            return null;
        }

        CustomerInfo.CustomerInfoBuilder customerInfo = CustomerInfo.builder();

        customerInfo.id( customer.getId() );
        customerInfo.userId( customer.getUserId() );
        customerInfo.organizationId( customer.getOrganizationId() );

        return customerInfo.build();
    }
}
