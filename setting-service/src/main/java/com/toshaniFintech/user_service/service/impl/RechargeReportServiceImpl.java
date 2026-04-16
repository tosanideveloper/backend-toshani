package com.toshaniFintech.user_service.service.impl;

import com.toshaniFintech.user_service.dto.request.RechargeReportRequestDTO;
import com.toshaniFintech.user_service.dto.response.RechargeReportResponseDTO;
import com.toshaniFintech.user_service.entity.RechargeReportEntity;
import com.toshaniFintech.user_service.repository.RechargeReportRepository;
import com.toshaniFintech.user_service.service.RechargeReportService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RechargeReportServiceImpl implements RechargeReportService {

    @Autowired
    private RechargeReportRepository rechargeReportRepository;

    @Override
    public List<RechargeReportResponseDTO> getRechargeReport(RechargeReportRequestDTO requestDTO) {

        List<RechargeReportEntity> entities =
                rechargeReportRepository.findByTxnDateBetween(
                        requestDTO.getStartDate(),
                        requestDTO.getEndDate()
                );

        return entities.stream().map(entity -> {
            RechargeReportResponseDTO dto = new RechargeReportResponseDTO();
            BeanUtils.copyProperties(entity, dto);
            return dto;
        }).toList();
    }
}