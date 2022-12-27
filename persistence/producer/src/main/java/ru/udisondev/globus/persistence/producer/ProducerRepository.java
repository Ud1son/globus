package ru.udisondev.globus.persistence.producer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface ProducerRepository extends JpaRepository<Producer, UUID> {

}
