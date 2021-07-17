package com.example.library.library.repository;

import com.example.library.library.model.Role;
import com.example.library.library.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByLogin(String login);

    @Query("select r from Role r")
    List<Role> getAllRoles();

    @Query("select u from User u where u.pid = :pid")
    Page<User> findPaginationByPid(@Param("pid")Long pid,  Pageable pageable);

}
