package ru.udisondev.globus.customer.api;

import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import ru.udisondev.globus.customer.service.CustomerInfo;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-02-11T20:13:03+0400",
    comments = "version: 1.5.3.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.4.2.jar, environment: Java 17.0.3 (Eclipse Adoptium)"
)
@Component
public class CustomerApiMapperImpl implements CustomerApiMapper {

    @Override
    public CustomerDto toDto(CustomerInfo customerInfo) {
        if ( customerInfo == null ) {
            return null;
        }

        CustomerDto.CustomerDtoBuilder customerDto = CustomerDto.builder();

        customerDto.id( customerInfo.getId() );
        customerDto.userId( customerInfo.getUserId() );
        customerDto.organizationId( customerInfo.getOrganizationId() );

        return customerDto.build();
    }
}
