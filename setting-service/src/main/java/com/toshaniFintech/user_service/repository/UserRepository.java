package com.toshaniFintech.user_service.repository;

import com.toshaniFintech.user_service.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, String> {



}
