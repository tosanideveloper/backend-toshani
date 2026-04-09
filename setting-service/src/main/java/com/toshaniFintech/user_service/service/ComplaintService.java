package com.toshaniFintech.user_service.service;

import com.toshaniFintech.user_service.dto.request.ComplaintRequest;
import com.toshaniFintech.user_service.dto.response.ComplaintResponse;

import java.util.List;

public interface ComplaintService {

    ComplaintResponse createComplaints(ComplaintRequest request);

    List<ComplaintResponse> getAllComplaints();

    static ComplaintResponse getComplaintsById() {
        return null;
    }

    ComplaintResponse getComplaintById(String complaintId);

    ComplaintResponse updateComplaints(String complaintId, ComplaintRequest request);

    String updateComplaints(ComplaintRequest request);

    ComplaintResponse updateComplaint(String complaintId, ComplaintRequest request);
}
