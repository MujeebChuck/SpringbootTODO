package io.javaproject.springbootstarter.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import io.javaproject.springbootstarter.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
     User findByUserName(String username);
}
