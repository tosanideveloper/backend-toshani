package com.toshaniFintech.user_service.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.toshaniFintech.common.dto.response.PaginatedResponse;
import com.toshaniFintech.user_service.entity.Aeps1ReportEntity;
import com.toshaniFintech.user_service.model.Aeps1ReportModel;
import com.toshaniFintech.user_service.repository.Aeps1ReportRepository;
import com.toshaniFintech.user_service.service.Aeps1ReportService;
import jakarta.persistence.criteria.Predicate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

@Service
public class Aeps1ReportServiceImpl implements Aeps1ReportService {

    @Autowired
    private Aeps1ReportRepository aeps1ReportRepository;

    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public PaginatedResponse<Aeps1ReportModel> createAepsReport(Aeps1ReportModel aeps1ReportModel) {

        int pageNo = aeps1ReportModel.getPageNo() != null ? aeps1ReportModel.getPageNo().intValue() : 0;
        int pageSize = aeps1ReportModel.getPageSize() != null ? aeps1ReportModel.getPageSize().intValue() : 10;

        Pageable pageable = PageRequest.of(
                pageNo,
                pageSize,
                Sort.by(Sort.Direction.DESC, "createdDate")
        );

        Specification<Aeps1ReportEntity> specification = (root, query, cb) -> {
            List<Predicate> predicates = new ArrayList<>();

            // date range
            if (StringUtils.hasText(aeps1ReportModel.getStartDate())
                    && StringUtils.hasText(aeps1ReportModel.getEndDate())) {
                predicates.add(cb.between(
                        root.get("txnDate"),
                        aeps1ReportModel.getStartDate(),
                        aeps1ReportModel.getEndDate()
                ));
            }

            // order id filter
            if (!CollectionUtils.isEmpty(aeps1ReportModel.getOrderId())) {
                predicates.add(root.get("orderID").in(aeps1ReportModel.getOrderId()));
            }

            // txn id filter
            if (!CollectionUtils.isEmpty(aeps1ReportModel.getTxnId())) {
                predicates.add(root.get("txnID").in(aeps1ReportModel.getTxnId()));
            }

            // txn type filter
            if (!CollectionUtils.isEmpty(aeps1ReportModel.getTxnType())
                    && !aeps1ReportModel.getTxnType().contains("ALL")) {
                predicates.add(root.get("txnType").in(aeps1ReportModel.getTxnType()));
            }

            // status filter
            if (!CollectionUtils.isEmpty(aeps1ReportModel.getStatus())
                    && !aeps1ReportModel.getStatus().contains("ALL")) {
                predicates.add(root.get("txnStatus").in(aeps1ReportModel.getStatus()));
            }

            // search + searchByField
            if (StringUtils.hasText(aeps1ReportModel.getSearch())
                    && StringUtils.hasText(aeps1ReportModel.getSearchByField())) {

                String field = aeps1ReportModel.getSearchByField();

                if ("txnID".equals(field)
                        || "orderID".equals(field)
                        || "bankName".equals(field)
                        || "aadhaarNo".equals(field)
                        || "rrn".equals(field)
                        || "txnType".equals(field)
                        || "txnStatus".equals(field)) {

                    predicates.add(cb.like(
                            cb.lower(root.get(field).as(String.class)),
                            "%" + aeps1ReportModel.getSearch().toLowerCase() + "%"
                    ));
                }
            }

            return cb.and(predicates.toArray(new Predicate[0]));
        };

        Page<Aeps1ReportEntity> pageData = aeps1ReportRepository.findAll(specification, pageable);

        List<Aeps1ReportModel> modelList = pageData.getContent().stream().map(entity -> {
            Aeps1ReportModel model = new Aeps1ReportModel();
            model.setId(entity.getId());
            model.setTxnDate(entity.getTxnDate());
            model.setTxnID(entity.getTxnID());
            model.setOrderID(entity.getOrderID());
            model.setBankName(entity.getBankName());
            model.setAadhaarNo(entity.getAadhaarNo());
            model.setAmount(entity.getAmount());
            model.setRrn(entity.getRrn());
            return model;
        }).toList();

        PaginatedResponse<Aeps1ReportModel> response = new PaginatedResponse<>(pageData);
        response.setContent(modelList);

        return response;
    }
}