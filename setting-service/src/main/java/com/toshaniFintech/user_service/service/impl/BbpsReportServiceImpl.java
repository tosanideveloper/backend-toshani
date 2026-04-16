package com.toshaniFintech.user_service.service.impl;

import com.toshaniFintech.user_service.dto.request.BbpsReportRequestDTO;
import com.toshaniFintech.user_service.dto.response.BbpsReportResponseDTO;
import com.toshaniFintech.user_service.entity.BbpsReportEntity;
import com.toshaniFintech.user_service.repository.BbpsReportRepository;
import com.toshaniFintech.user_service.service.BbpsReportService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BbpsReportServiceImpl implements BbpsReportService {

    @Autowired
    private BbpsReportRepository bbpsReportRepository;

    @Override
    public List<BbpsReportResponseDTO> getBbpsReport(BbpsReportRequestDTO requestDTO) {

        List<BbpsReportEntity> entities =
                bbpsReportRepository.findByTxnDateBetween(
                        requestDTO.getStartDate(),
                        requestDTO.getEndDate()
                );

        return entities.stream().map(entity -> {
            BbpsReportResponseDTO dto = new BbpsReportResponseDTO();
            BeanUtils.copyProperties(entity, dto);
            return dto;
        }).toList();
    }
}