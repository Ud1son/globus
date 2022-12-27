package ru.udisondev.globus.persistence.claim;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


@Data
public class ClaimId implements Serializable {

    private LocalDate claimDate;
    private Integer order;

    public static ClaimId fromString(String stringId) {
        var strings = stringId.split("/");
        var claimId = new ClaimId();
        claimId.setClaimDate(LocalDate.parse(strings[0], DateTimeFormatter.ofPattern("dd-MM-yyyy")));
        claimId.setOrder(Integer.parseInt(strings[1]));
        return claimId;
    }

    @Override
    public String toString() {
        return "%s/%d".formatted(claimDate.format(DateTimeFormatter.ofPattern("dd-MM-yyyy")), order);
    }
}

