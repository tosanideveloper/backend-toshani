package com.toshaniFintech.user_service.service.impl;

import com.toshaniFintech.user_service.dto.request.ModifyReportRequestDTO;
import com.toshaniFintech.user_service.dto.response.ModifyReportResponseDTO;
import com.toshaniFintech.user_service.entity.ModifyReportEntity;
import com.toshaniFintech.user_service.repository.ModifyReportRepository;
import com.toshaniFintech.user_service.service.ModifyReportService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ModifyReportServiceImpl implements ModifyReportService {

    @Autowired
    private ModifyReportRepository modifyReportRepository;

    @Override
    public List<ModifyReportResponseDTO> getModifyReport(ModifyReportRequestDTO requestDTO) {

        List<ModifyReportEntity> entities =
                modifyReportRepository.findByTxnDateBetween(
                        requestDTO.getStartDate(),
                        requestDTO.getEndDate()
                );

        return entities.stream().map(entity -> {
            ModifyReportResponseDTO dto = new ModifyReportResponseDTO();
            BeanUtils.copyProperties(entity, dto);
            return dto;
        }).toList();
    }
}