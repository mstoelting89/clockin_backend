package com.clockin.clockin_backend.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);

    @Transactional
    @Modifying
    @Query("UPDATE User SET enabled = true WHERE email = ?1")
    int enableUser(String email);

    @Transactional
    @Modifying
    @Query("UPDATE User SET locked = false WHERE email = ?1")
    int unlockUser(String email);
}
