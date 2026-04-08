package com.toshaniFintech.common.repository;

import com.toshaniFintech.common.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface UsersRepository extends JpaRepository<Users, String> {

    Optional<Users> findByEmailIgnoreCase(String email);

    boolean existsByUserNameIgnoreCase(String userName);

    boolean existsByEmailIgnoreCase(String email);

    Optional<Users> findByUserName(String username);
}
