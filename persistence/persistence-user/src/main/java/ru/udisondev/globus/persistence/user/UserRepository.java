package ru.udisondev.globus.persistence.user;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.udisondev.globus.persistence.enums.UserRole;
import ru.udisondev.globus.persistence.user.User;

import java.util.List;
import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {

    List<User> findAllByRole(UserRole role);
}
