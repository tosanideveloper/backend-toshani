package com.toshaniFintech.user_service.repository;

import com.toshaniFintech.user_service.entity.HolidayEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface HolidayRepository extends JpaRepository<HolidayEntity, String> {
}
