package com.toshaniFintech.user_service.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.toshaniFintech.common.dto.response.PaginatedResponse;
import com.toshaniFintech.common.utils.Utility;
import com.toshaniFintech.user_service.dto.request.EmployeeManagementGetAllRequest;
import com.toshaniFintech.user_service.dto.response.EmployeeManagementResponseDTO;
import com.toshaniFintech.user_service.dto.response.MatmCommissionResponseDTO;
import com.toshaniFintech.user_service.entity.EmployeeManagementEntity;
import com.toshaniFintech.user_service.entity.MatmCommissionEntity;
import com.toshaniFintech.user_service.mapper.EmployeeManagementMapper;
import com.toshaniFintech.user_service.model.EmployeeManagementModel;
import com.toshaniFintech.user_service.model.MatmCommissionModel;
import com.toshaniFintech.user_service.repository.EmployeeManagementRepository;
import com.toshaniFintech.user_service.service.EmployeeManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeManagementImpl implements EmployeeManagementService {
    @Autowired
    private EmployeeManagementRepository employeeManagementRepository;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private EmployeeManagementMapper employeeManagementMapper;

    @Override
    public EmployeeManagementModel createEmployee(EmployeeManagementModel employeeManagementModel) {

        EmployeeManagementEntity employeeManagementEntity =
                objectMapper.convertValue(employeeManagementModel, EmployeeManagementEntity.class);

        EmployeeManagementEntity saved = employeeManagementRepository.save(employeeManagementEntity);

        return objectMapper.convertValue(saved, EmployeeManagementModel.class);
    }
    @Override
    public PaginatedResponse<EmployeeManagementResponseDTO> getAllEmployee(
            EmployeeManagementGetAllRequest employeeManagementGetAllRequest) {

        PageRequest page = Utility.pageRequest(
                employeeManagementGetAllRequest.getPageNo(),
                employeeManagementGetAllRequest.getPageSize(),
                employeeManagementGetAllRequest.getSortBy(),
                employeeManagementGetAllRequest.getOrderBy()
        );

        Page<EmployeeManagementEntity> paginatedContent =
                employeeManagementRepository.fetchAllEmployee(
                        employeeManagementGetAllRequest.getStatus(),
                        employeeManagementGetAllRequest.getSearch(),
                        employeeManagementGetAllRequest.getSearchByField(),
                        page
                );

        List<EmployeeManagementResponseDTO> responseDTOS = new ArrayList<>();
        paginatedContent.getContent().forEach(content ->
                responseDTOS.add(employeeManagementMapper.toResponseDto(content))
        );

        return Utility.paginatedResponseForSubList(
                paginatedContent.getNumber(),
                paginatedContent.getTotalPages(),
                paginatedContent.getSize(),
                paginatedContent.getNumberOfElements(),
                paginatedContent.getTotalElements(),
                responseDTOS
        );
    }
    @Override
    public EmployeeManagementResponseDTO getByIdEmployee(String id) {

        EmployeeManagementEntity employeeManagementEntity = employeeManagementRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee management not found with id: " + id));

        return employeeManagementMapper.toResponseDto(employeeManagementEntity);
    }
    @Override
    public EmployeeManagementResponseDTO updateEmployee(String id, EmployeeManagementModel employeeManagementModel) {

        EmployeeManagementEntity employeeManagementEntity = employeeManagementRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee management not found with id: " + id));

        employeeManagementEntity.setEmployeeCode(employeeManagementModel.getEmployeeCode());
        employeeManagementEntity.setName(employeeManagementModel.getName());
        employeeManagementEntity.setEmail(employeeManagementModel.getEmail());
        employeeManagementEntity.setMobile(employeeManagementModel.getMobile());
        employeeManagementEntity.setStatus(employeeManagementModel.getStatus());

        EmployeeManagementEntity updatedEntity = employeeManagementRepository.save(employeeManagementEntity);

        return employeeManagementMapper.toResponseDto(updatedEntity);
    }
    @Override
    public void deleteEmployee(String id) {

        EmployeeManagementEntity employeeManagementEntity = employeeManagementRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee management not found with id: " + id));

        employeeManagementRepository.delete(employeeManagementEntity);
    }
}
