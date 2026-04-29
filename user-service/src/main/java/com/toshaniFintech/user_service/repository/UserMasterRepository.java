package com.toshaniFintech.user_service.repository;

import com.toshaniFintech.user_service.entity.UserMasterEntity;
import org.springframework.data.domain.*;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserMasterRepository extends JpaRepository<UserMasterEntity, Long> {

    Optional<UserMasterEntity> findByUserUuid(String uuid);

    @Query("""
        SELECT u FROM UserMasterEntity u
        JOIN u.entityMaster e
        WHERE (:user_type IS NULL OR e.user_type = :user_type)
        AND (:username IS NULL OR LOWER(u.username) LIKE LOWER(CONCAT('%', :username, '%')))
        AND (
            :search IS NULL OR :search = '' OR
            (:searchByField = 'username' AND LOWER(u.username) LIKE LOWER(CONCAT('%', :search, '%')))
        )
    """)
    Page<UserMasterEntity> fetchUsers(
            @Param("username") String username,
            @Param("search") String search,
            @Param("searchByField") String searchByField,
            PageRequest page
    );
}