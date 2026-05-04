package com.toshaniFintech.user_service.repository;

import com.toshaniFintech.user_service.entity.EmployeeManagementEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface EmployeeManagementRepository extends JpaRepository<EmployeeManagementEntity, String> {

    boolean existsByEmail(String email);

    boolean existsByEmployeeCode(String employeeCode);

    @Query("SELECT e FROM EmployeeManagementEntity e " +
            "WHERE (:status IS NULL OR e.status IN :status) " +
            "AND e.createDate BETWEEN :startDate AND :endDate " +
            "AND (:search IS NULL OR :search = '' " +
            "   OR (:searchByField = 'employeeCode' AND LOWER(e.employeeCode) LIKE LOWER(CONCAT('%', :search, '%'))) " +
            "   OR (:searchByField = 'name' AND LOWER(e.name) LIKE LOWER(CONCAT('%', :search, '%'))) " +
            "   OR (:searchByField = 'email' AND LOWER(e.email) LIKE LOWER(CONCAT('%', :search, '%'))) " +
            "   OR (:searchByField = 'mobile' AND LOWER(e.mobile) LIKE LOWER(CONCAT('%', :search, '%'))) " +
            "   OR (:searchByField = 'status' AND LOWER(e.status) LIKE LOWER(CONCAT('%', :search, '%'))) " +
            ")")
    Page<EmployeeManagementEntity> fetchAllEmployee(
            @Param("status") List<String> status,
            @Param("startDate") LocalDate startDate,
            @Param("endDate") LocalDate endDate,
            @Param("search") String search,
            @Param("searchByField") String searchByField,
            PageRequest pageRequest
    );
}