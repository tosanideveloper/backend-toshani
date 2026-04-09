package com.toshaniFintech.user_service.repository;

import com.toshaniFintech.user_service.entity.ComplaintEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.Optional;

@Repository
public interface ComplaintRepository extends JpaRepository<ComplaintEntity, String> {
    static Optional<ComplaintEntity> findByComplaintId(String complaintId) {
        return null;
    }
    boolean existsByComplaintsId(String complaintsId);
}