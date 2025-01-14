package com.tiba.whatsapp_api.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, String> {

    @Query("SELECT u FROM User u WHERE u.email = :email")
    Optional<User> findUserByEmail(@Param("email") String email);

    @Query("SELECT u FROM User u WHERE u.id != :publicId")
    List<User> findAllUsersExceptSelf(@Param("publicId") String publicId);

    @Query("SELECT u FROM User u WHERE u.id = :publicId")
    Optional<User> findUserByPublicId(@Param("publicId") String publicId);

}