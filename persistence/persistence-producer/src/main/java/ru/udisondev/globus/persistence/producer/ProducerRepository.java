package ru.udisondev.globus.persistence.producer;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProducerRepository extends JpaRepository<Producer, UUID> {

}