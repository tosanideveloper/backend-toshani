package com.toshaniFintech.user_service.repository;

import com.toshaniFintech.user_service.entity.UpiExpressAccountEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UpiExpressAccountRepository extends JpaRepository<UpiExpressAccountEntity, String> {

    @Query("SELECT u FROM UpiExpressAccountEntity u " +
            "WHERE (:search IS NULL OR :search = '' " +
            " OR (:searchByField = 'accountNo' AND LOWER(u.accountNo) LIKE LOWER(CONCAT('%', :search, '%'))) " +
            " OR (:searchByField = 'limitAmount' AND CAST(u.limitAmount as string) LIKE CONCAT('%', :search, '%'))) ")
    Page<UpiExpressAccountEntity> fetchAll(
            @Param("search") String search,
            @Param("searchByField") String searchByField,
            PageRequest pageRequest
    );
}