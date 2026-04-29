package com.toshaniFintech.user_service.repository;

import com.toshaniFintech.user_service.entity.EnquiryFormLogEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface EnquiryFormLogRepository extends JpaRepository<EnquiryFormLogEntity, String> {

    @Query("SELECT a FROM EnquiryFormLogEntity a " +
            "WHERE a.enquiryDate BETWEEN :startDate AND :endDate " +
            "AND ( :search IS NULL OR :search = '' " +
            "   OR (:searchByField = 'name' AND LOWER(a.name) LIKE LOWER(CONCAT('%', :search, '%'))) " +
            "   OR (:searchByField = 'mobileNumber' AND LOWER(a.mobileNumber) LIKE LOWER(CONCAT('%', :search, '%'))) " +
            "   OR (:searchByField = 'emailId' AND LOWER(a.emailId) LIKE LOWER(CONCAT('%', :search, '%'))) " +
            "   OR (:searchByField = 'companyName' AND LOWER(a.companyName) LIKE LOWER(CONCAT('%', :search, '%'))) )")
    Page<EnquiryFormLogEntity> fetchEnquiryFormLog(
            @Param("startDate") String startDate,
            @Param("endDate") String endDate,
            @Param("search") String search,
            @Param("searchByField") String searchByField,
            PageRequest page
    );
}
