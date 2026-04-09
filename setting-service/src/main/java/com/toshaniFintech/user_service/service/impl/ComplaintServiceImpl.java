package com.toshaniFintech.user_service.service.impl;


import com.toshaniFintech.common.exception.model.UnprocessableEntityException;
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
    public ComplaintResponse createComplaints(ComplaintRequest complaintRequest) {

        if (ComplaintRepository.findByComplaintId(complaintRequest.getComplaintId()).isPresent()) {
            throw new UnprocessableEntityException(
                    "Complaints already exists with id: " + complaintRequest.getComplaintId()
            );
        }

        ComplaintEntity entity = mapToEntity(complaintRequest);
        ComplaintEntity savedEntity = complaintRepository.save(entity);
        return mapToResponse(savedEntity);
    }

    @Override
    public List<ComplaintResponse> getAllComplaints() {
        List<ComplaintEntity> complaints = complaintRepository.findAll();
        return complaints.stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public ComplaintResponse getComplaintById(String complaintId) {
        ComplaintEntity entity = ComplaintRepository.findByComplaintId(complaintId)
                .orElseThrow(() -> new RuntimeException("Complaint not found with ID: " + complaintId));
        return mapToResponse(entity);
    }

    @Override
    public ComplaintResponse updateComplaints(String complaintId, ComplaintRequest request) {
        return null;
    }

    @Override
    public String updateComplaints(ComplaintRequest request) {
        return "";
    }

    @Override
    public ComplaintResponse updateComplaint(String complaintId, ComplaintRequest request) {
        return null;
    }

    private ComplaintEntity mapToEntity(ComplaintRequest complaintRequest) {
        ComplaintEntity entity = new ComplaintEntity();
        entity.setComplaintsId(complaintRequest.getComplaintId());
        entity.setAgentDetails(complaintRequest.getAgentDetails());
        entity.setRequestUrl(complaintRequest.getRequestUrl());
        entity.setRequest(complaintRequest.getRequest());
        entity.setResponse(complaintRequest.getResponse());
        entity.setComplaintOn(complaintRequest.getComplaintOn());
        entity.setAttachment(complaintRequest.getAttachment());
        entity.setStatus(complaintRequest.getStatus());
        entity.setMessages(complaintRequest.getMessages());
        return entity;
    }

    private ComplaintResponse mapToResponse(ComplaintEntity entity) {
        ComplaintResponse response = new ComplaintResponse();
        response.setComplaintId(entity.getComplaintsId());
        response.setAgentDetails(entity.getAgentDetails());
        response.setRequestUrl(entity.getRequestUrl());
        response.setRequest(entity.getRequest());
        response.setResponse(entity.getResponse());
        response.setComplaintOn(entity.getComplaintOn());
        response.setAttachment(entity.getAttachment());
        response.setStatus(entity.getStatus());
        response.setMessages(entity.getMessages());
        return response;
    }
}

