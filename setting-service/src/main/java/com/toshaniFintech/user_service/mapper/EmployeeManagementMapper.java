package com.toshaniFintech.user_service.mapper;

import com.toshaniFintech.user_service.dto.response.EmployeeManagementResponseDTO;
import com.toshaniFintech.user_service.entity.EmployeeManagementEntity;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", builder = @Builder(disableBuilder = true))
public interface EmployeeManagementMapper {
    EmployeeManagementResponseDTO toResponseDto(EmployeeManagementEntity employeeManagementEntity);
}
