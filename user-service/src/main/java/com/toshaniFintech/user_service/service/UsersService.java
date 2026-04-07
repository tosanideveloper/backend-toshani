package com.toshaniFintech.user_service.service;

import com.toshaniFintech.user_service.dto.request.ForgotPasswordRequest;
import com.toshaniFintech.user_service.dto.request.ResetPasswordRequest;
import com.toshaniFintech.user_service.dto.request.UsersRequest;
import com.toshaniFintech.common.dto.response.UsersResponse;

import java.util.List;


public interface UsersService {

    UsersResponse createUser(UsersRequest request);

    List<UsersResponse> getAllUsersForSuperAdmin();

    void forgotPassword(ForgotPasswordRequest request);

    void resetPassword(ResetPasswordRequest request);
}
