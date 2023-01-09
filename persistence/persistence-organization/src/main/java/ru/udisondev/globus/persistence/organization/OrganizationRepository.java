package ru.udisondev.globus.persistence.organization;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface OrganizationRepository extends JpaRepository<Organization, UUID> {

    Optional<Organization> findFirstByInn(String inn);

    boolean existsByInn(String inn);
}
