package com.toshaniFintech.user_service.service;

import com.toshaniFintech.user_service.model.AdminEmailsModel;

import java.util.List;

public interface AdminEmailsService {
    List<AdminEmailsModel> getAdminEmails();

    AdminEmailsModel createAdminEmail(AdminEmailsModel adminEmailsModel);

    AdminEmailsModel updateAdminEmail(String id, AdminEmailsModel adminEmailsModel);

    void deleteAdminEmail(String id);

    AdminEmailsModel getAdminEmailByID(String id);
}
