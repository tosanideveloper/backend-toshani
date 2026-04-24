package com.toshaniFintech.user_service.repository;

import com.toshaniFintech.user_service.entity.UsersEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends JpaRepository<UsersEntity, Long> {

}
