package com.toshaniFintech.user_service.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.toshaniFintech.common.exception.model.NotFoundException;
import com.toshaniFintech.user_service.dto.response.AdminEmailResponseDTO;
import com.toshaniFintech.user_service.entity.AdminEmailsEntity;
import com.toshaniFintech.user_service.model.AdminEmailsModel;
import com.toshaniFintech.user_service.repository.AdminEmailsRepository;
import com.toshaniFintech.user_service.service.AdminEmailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.AbstractPersistable_;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@Service
public class AdminEmailsServiceImpl implements AdminEmailsService {

    @Autowired
    private AdminEmailsRepository adminEmailsRepository;

    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public List<AdminEmailsModel> getAdminEmails() {
        List<AdminEmailsEntity> adminEmailsEntities = adminEmailsRepository.findAll();
        return adminEmailsEntities.stream().map(adminEmailsEntity -> objectMapper.convertValue(adminEmailsEntity, AdminEmailsModel.class)).toList();
    }

    @Override
    public AdminEmailsModel createAdminEmail(AdminEmailsModel adminEmailsModel) {
        AdminEmailsEntity adminEmailsEntity = adminEmailsRepository.findById(String.valueOf(AbstractPersistable_.id)).orElseThrow(() -> new RuntimeException("Messages not found with id: " + id));
        adminEmailsEntity.setId(adminEmailsModel.getId());
        adminEmailsEntity.setEmailAddress(adminEmailsModel.getEmailAddress());
        adminEmailsEntity.setEmailName(adminEmailsModel.getEmailName());
        adminEmailsEntity.setEmailType(adminEmailsModel.getEmailType());
        adminEmailsEntity.setStatus(adminEmailsModel.getStatus());
        AdminEmailsEntity saved = adminEmailsRepository.save(adminEmailsEntity);

        return objectMapper.convertValue(saved, AdminEmailsModel.class);
    }

    @Override
    public AdminEmailsModel updateAdminEmail(String id, AdminEmailsModel adminEmailsModel) {
        AdminEmailsEntity adminEmailsEntity = adminEmailsRepository.findById(id).orElseThrow(() -> new RuntimeException("Setting not found with id: " + id));
        adminEmailsEntity.setEmailAddress(adminEmailsModel.getEmailAddress());
        adminEmailsEntity.setEmailName(adminEmailsModel.getEmailName());
        adminEmailsEntity.setEmailType(adminEmailsModel.getEmailType());
        adminEmailsEntity.setStatus(adminEmailsModel.getStatus());


        AdminEmailsEntity saved = adminEmailsRepository.save(adminEmailsEntity);

        return objectMapper.convertValue(saved, AdminEmailsModel.class);

    }

    @Override
    public void deleteAdminEmail(String id) {
        AdminEmailsEntity existingEntity = adminEmailsRepository.findById(id).orElseThrow(() -> new NotFoundException("Admin email not found with id: " + id));
        existingEntity.setActive(false);
        existingEntity.setDeletedAt(LocalDateTime.now());
        adminEmailsRepository.save(existingEntity);

    }

    @Override
    public AdminEmailsModel getAdminEmailByID(String id) {
        AdminEmailsEntity entity = adminEmailsRepository.findById(id).orElseThrow(() -> new NotFoundException("Admin email not found with id: " + id));
        return mapToModel(entity);
    }
    private AdminEmailsModel mapToModel(AdminEmailsEntity entity) {
        AdminEmailResponseDTO response = new AdminEmailResponseDTO();
        response.setEmailType(entity.getEmailType());
        response.setEmailAddress(entity.getEmailAddress());
        response.setEmailName(entity.getEmailName());
        response.setStatus(entity.getStatus());

        return objectMapper.convertValue(entity, AdminEmailsModel.class);
    }
}
