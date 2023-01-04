package ru.udisondev.globus.persistence.user;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;

import java.time.LocalDate;

@Data
@Embeddable
public class Profile {

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    private String middleName;

    @Column(nullable = false)
    private String phone;

    @Column(nullable = false)
    private String email;

    private LocalDate birthDay;


}
