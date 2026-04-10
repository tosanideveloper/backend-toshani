package com.toshaniFintech.user_service.service;

import com.toshaniFintech.user_service.dto.request.ComplaintRequest;
import com.toshaniFintech.user_service.dto.request.SettingRequest;
import com.toshaniFintech.user_service.dto.response.ComplaintResponse;
import com.toshaniFintech.user_service.dto.response.SettingResponse;

import java.util.List;

public interface ComplaintService {
    ComplaintResponse createComplaint(ComplaintRequest complaintRequest);

    List<ComplaintResponse> getAllComplaints();

    ComplaintResponse getComplaintById(String id);

    ComplaintResponse getComplaintsId(String id);

    ComplaintResponse updateComplaint(String id, ComplaintRequest complaintModel);

}
