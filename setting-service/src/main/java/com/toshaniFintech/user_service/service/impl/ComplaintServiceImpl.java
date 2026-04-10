package com.toshaniFintech.user_service.service.impl;


import com.toshaniFintech.common.exception.model.NotFoundException;
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
    public ComplaintResponse createComplaint(ComplaintRequest complaintRequest) {

        if (complaintRepository.findByComplaintId(complaintRequest.getComplaintId()).isPresent()) {
            throw new UnprocessableEntityException(
                    "Complaint already exists with key: " + complaintRequest.getComplaintId()
            );
        }
        ComplaintEntity entity = mapToEntity(complaintRequest);
        ComplaintEntity savedEntity = complaintRepository.save(entity);
        return mapToModel(savedEntity);
    }

    private ComplaintResponse mapToModel(ComplaintEntity savedEntity) {
        return null;
    }

    @Override
    public List<ComplaintResponse> getAllComplaints() {
        List<ComplaintEntity> complaints = complaintRepository.findAll();
        return complaints.stream()
                .map(this::mapToModel)
                .collect(Collectors.toList());
    }

    @Override
    public ComplaintResponse getComplaintById(String id) {
        return null;
    }

    @Override
    public ComplaintResponse getComplaintsId(String id) {
        ComplaintEntity entity = complaintRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Complaint not found with id: " + id));
        return mapToModel(entity);
    }

    @Override
    public ComplaintResponse updateComplaint(String id, ComplaintRequest complaintRequest) {
        ComplaintEntity existingEntity = complaintRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Complaint not found with id: " + id));

        existingEntity.setComplaintId(complaintRequest.getComplaintId());
        existingEntity.setAgentDetails(complaintRequest.getAgentDetails());
        existingEntity.setRequestUrl(complaintRequest.getRequestUrl());
        existingEntity.setRequest(complaintRequest.getRequest());
        existingEntity.setResponse(complaintRequest.getResponse());
        existingEntity.setComplaintOn(complaintRequest.getComplaintOn());
        existingEntity.setAttachment(complaintRequest.getAttachment());
        existingEntity.setStatus(complaintRequest.getStatus());
        existingEntity.setMessages(complaintRequest.getMessages());

        ComplaintEntity updatedEntity = complaintRepository.save(existingEntity);
        return mapToModel(updatedEntity);
    }
    private ComplaintEntity mapToEntity(ComplaintRequest complaintRequest) {
        ComplaintEntity entity = new ComplaintEntity();
        entity.setComplaintId(complaintRequest.getComplaintId());
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

