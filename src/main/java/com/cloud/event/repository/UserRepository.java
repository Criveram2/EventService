package com.cloud.event.repository;

import com.cloud.event.domain.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface UserRepository extends JpaRepository<Users,String> {

    Users findUserByEmailAndPassword(String email, String password);

    Users save(Users user);

    Users findByIdUser(Integer idUser);

    Users findByEmail(String email);
}
