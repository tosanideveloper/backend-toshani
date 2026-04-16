package com.toshaniFintech.user_service.service.impl;

import com.toshaniFintech.user_service.dto.request.MatmReportRequestDTO;
import com.toshaniFintech.user_service.dto.response.MatmReportResponseDTO;
import com.toshaniFintech.user_service.entity.MatmReportEntity;
import com.toshaniFintech.user_service.repository.MatmReportRepository;
import com.toshaniFintech.user_service.service.MatmReportService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MatmReportServiceImpl implements MatmReportService {

    @Autowired
    private MatmReportRepository matmReportRepository;

    @Override
    public List<MatmReportResponseDTO> getMatmReport(MatmReportRequestDTO requestDTO) {

        List<MatmReportEntity> entities = matmReportRepository.findByTxnDateBetween(requestDTO.getStartDate(), requestDTO.getEndDate());

        return entities.stream().map(entity -> {
            MatmReportResponseDTO dto = new MatmReportResponseDTO();
            BeanUtils.copyProperties(entity, dto);
            return dto;
        }).toList();
    }
}