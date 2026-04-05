package com.toshaniFintech.user_service.repository;

import com.toshaniFintech.user_service.entity.HolidayListEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HolidayListRepository extends JpaRepository<HolidayListEntity, Long> {
}
