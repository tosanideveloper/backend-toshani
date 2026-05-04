package com.toshaniFintech.user_service.service.impl;

import com.toshaniFintech.common.exception.model.NotFoundException;
import com.toshaniFintech.user_service.dto.request.ComplaintRequest;
import com.toshaniFintech.user_service.dto.response.ComplaintResponse;
import com.toshaniFintech.user_service.entity.ComplaintEntity;
import com.toshaniFintech.user_service.repository.ComplaintRepository;
import com.toshaniFintech.user_service.service.ComplaintService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ComplaintServiceImpl implements ComplaintService {

    @Autowired
    private ComplaintRepository complaintRepository;

    @Override
    public ComplaintResponse createComplaint(ComplaintRequest request) {
        ComplaintEntity entity = mapToEntity(request);
        return mapToModel(complaintRepository.save(entity));
    }

    @Override
    public List<ComplaintResponse> getAllComplaints() {
        return complaintRepository.findAll()
                .stream()
                .map(this::mapToModel)
                .collect(Collectors.toList());
    }

    @Override
    public ComplaintResponse getComplaintById(String id) {
        ComplaintEntity entity = complaintRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Complaint not found with id: " + id));
        return mapToModel(entity);
    }

    @Override
    public ComplaintResponse getComplaintsId(String id) {
        return getComplaintById(id);
    }

    @Override
    public ComplaintResponse updateComplaint(String id, ComplaintRequest request) {

        ComplaintEntity entity = complaintRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Complaint not found"));

        entity.setComplaintId(request.getComplaintId());
        entity.setComplaintOn(request.getComplaintOn());
        entity.setAgentDetails(request.getAgentDetails());
        entity.setRequestUrl(request.getRequestUrl());
        entity.setRequest(request.getRequest());
        entity.setResponse(request.getResponse());
        entity.setAttachment(request.getAttachment());
        entity.setStatus(request.getStatus());
        entity.setMessages(request.getMessages());

        return mapToModel(complaintRepository.save(entity));
    }

    private ComplaintResponse mapToModel(ComplaintEntity entity) {
        ComplaintResponse res = new ComplaintResponse();

        res.setId(entity.getId());
        res.setComplaintId(entity.getComplaintId());
        res.setComplaintOn(entity.getComplaintOn());
        res.setAgentDetails(entity.getAgentDetails());
        res.setRequestUrl(entity.getRequestUrl());
        res.setRequest(entity.getRequest());
        res.setResponse(entity.getResponse());
        res.setAttachment(entity.getAttachment());
        res.setStatus(entity.getStatus());
        res.setMessages(entity.getMessages());

        return res;
    }

    // ✅ DTO → ENTITY
    private ComplaintEntity mapToEntity(ComplaintRequest request) {
        ComplaintEntity entity = new ComplaintEntity();

        entity.setComplaintId(request.getComplaintId());
        entity.setComplaintOn(request.getComplaintOn());
        entity.setAgentDetails(request.getAgentDetails());
        entity.setRequestUrl(request.getRequestUrl());
        entity.setRequest(request.getRequest());
        entity.setResponse(request.getResponse());
        entity.setAttachment(request.getAttachment());
        entity.setStatus(request.getStatus());
        entity.setMessages(request.getMessages());

        return entity;
    }
}