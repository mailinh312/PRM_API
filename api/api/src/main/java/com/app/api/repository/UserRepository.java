package com.app.api.repository;

import com.app.api.model.User;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.lang.NonNull;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface UserRepository extends ListCrudRepository<User, Integer> {
    @Transactional
    @Modifying
    @Query("update User u set u.password = ?1, u.address = ?2, u.phone = ?3 where u.id = ?4")
    void updateUser(@NonNull String password, String address, String phone, @NonNull Integer id);

    Optional<User> findByUsernameIgnoreCase(String username);

    User findByUsernameAndPassword(String username, String password);
}
