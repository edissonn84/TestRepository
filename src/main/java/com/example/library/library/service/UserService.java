package com.example.library.library.service;

import com.example.library.library.model.Role;
import com.example.library.library.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface UserService {

    List<User> getAllUsers();

    Optional<User> getUserById(Long id);

    User createNewUser(User user);

    void editUser(User user);

    void deleteUser(Long id);

    List<Role> getAllRoles();

    Page<User> findPaginated(Pageable pageable);

    Page<User> findPaginatedByPid(Long pid, Pageable pageable);

}
