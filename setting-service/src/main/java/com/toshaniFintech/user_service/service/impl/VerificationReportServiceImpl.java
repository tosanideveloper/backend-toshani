package com.toshaniFintech.user_service.service.impl;

import com.toshaniFintech.user_service.dto.request.VerificationReportRequestDTO;
import com.toshaniFintech.user_service.dto.response.VerificationReportResponseDTO;
import com.toshaniFintech.user_service.entity.VerificationReportEntity;
import com.toshaniFintech.user_service.repository.VerificationReportRepository;
import com.toshaniFintech.user_service.service.VerificationReportService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VerificationReportServiceImpl implements VerificationReportService {

    @Autowired
    private VerificationReportRepository verificationReportRepository;

    @Override
    public List<VerificationReportResponseDTO> getVerificationReport(VerificationReportRequestDTO requestDTO) {

        List<VerificationReportEntity> entities =
                verificationReportRepository.findByTxnDateBetween(
                        requestDTO.getStartDate(),
                        requestDTO.getEndDate()
                );

        return entities.stream().map(entity -> {
            VerificationReportResponseDTO dto = new VerificationReportResponseDTO();
            BeanUtils.copyProperties(entity, dto);
            return dto;
        }).toList();
    }
}