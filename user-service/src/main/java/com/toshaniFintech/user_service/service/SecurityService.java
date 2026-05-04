package com.toshaniFintech.user_service.service;

import com.toshaniFintech.common.dto.response.APIResponse;
import com.toshaniFintech.user_service.dto.request.*;
import com.toshaniFintech.user_service.dto.response.AuthenticatorSetupResponse;
import com.toshaniFintech.user_service.dto.response.SecurityStatusResponse;

public interface SecurityService {

    void setMpin(String username, MpinSetRequest request);

    void verifyMpin(String username, MpinVerifyRequest request);

    void changeMpin(String username, ChangeMpinRequest request);

    void disableMpin(String username, MpinVerifyRequest request);

    SecurityStatusResponse getMpinStatus(String username);

    void initiateForgotMpin(String username, ForgotMpinInitiateRequest request);

    void resetForgotMpin(String username, ForgotMpinResetRequest request);

    SecurityStatusResponse getAuthenticatorStatus(String username);

    AuthenticatorSetupResponse setupAuthenticator(String username);

    void verifyAuthenticator(String username, OtpVerifyRequest request);

    void disableAuthenticator(String username, OtpVerifyRequest request);

    void initiateAuthenticatorReset(String username);

    void confirmAuthenticatorReset(String username, AuthenticatorResetConfirmRequest request);
}