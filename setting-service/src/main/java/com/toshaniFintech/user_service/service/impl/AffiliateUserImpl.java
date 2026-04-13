package com.toshaniFintech.user_service.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.toshaniFintech.common.exception.model.BadRequestException;
import com.toshaniFintech.common.exception.model.NotFoundException;
import com.toshaniFintech.common.exception.model.UnprocessableEntityException;
import com.toshaniFintech.user_service.entity.AffiliateUserEntity;
import com.toshaniFintech.user_service.entity.ApiPartnerServiceEntity;
import com.toshaniFintech.user_service.entity.CallBackLogEntity;
import com.toshaniFintech.user_service.entity.SettingEntity;
import com.toshaniFintech.user_service.model.AffiliateUserModel;
import com.toshaniFintech.user_service.model.ApiPartnerServiceModel;
import com.toshaniFintech.user_service.model.CallBackLogModel;
import com.toshaniFintech.user_service.repository.AffiliateUserRepository;
import com.toshaniFintech.user_service.repository.CallBackLogRepository;
import com.toshaniFintech.user_service.service.AffiliateUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.AbstractPersistable_;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@Service
public class AffiliateUserImpl implements AffiliateUserService {

    @Autowired
    private AffiliateUserRepository affiliateUserRepository;

    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public List<AffiliateUserModel> getAffiliateUSer() {
        List<AffiliateUserEntity> affiliateUserEntityList = affiliateUserRepository.findAll();
        return affiliateUserEntityList.stream().map(affiliateUSer -> objectMapper.convertValue(affiliateUserEntityList, AffiliateUserModel.class)).toList();
    }

    @Override
    public AffiliateUserModel createAffiliateUser(AffiliateUserModel affiliateUserModel) {
        if (affiliateUserRepository.findByMobileNumber(affiliateUserModel.getMobileNumber()).isPresent()) {
            throw new UnprocessableEntityException(
                    "Setting already exists with key: " + affiliateUserModel.getMobileNumber()
            );
        }
        AffiliateUserEntity affiliateUserEntity = affiliateUserRepository.findById(String.valueOf(AbstractPersistable_.id)).orElseThrow(() -> new NotFoundException("User not found with mobile number: " + id));
        affiliateUserEntity.setSerialNo(affiliateUserModel.getSerialNo());
        affiliateUserEntity.setName(affiliateUserModel.getName());
        affiliateUserEntity.setStatus(affiliateUserModel.getStatus());
        affiliateUserEntity.setEmail(affiliateUserModel.getEmail());
        affiliateUserEntity.setAction(affiliateUserModel.getAction());
        affiliateUserEntity.setJoinedON(affiliateUserModel.getJoinedON());

        AffiliateUserEntity saved = affiliateUserRepository.save(affiliateUserEntity);

        return objectMapper.convertValue(saved, AffiliateUserModel.class);
    }

    @Override
    public void deleteUser(String id) {
        AffiliateUserEntity existingEntity = affiliateUserRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Affiliate User not found with id: " + id));

        if (!existingEntity.isActive()) {
            throw new BadRequestException("Affiliate User already deleted");
        }
        existingEntity.setActive(false);
        existingEntity.setDeletedAt(LocalDateTime.now());
        affiliateUserRepository.save(existingEntity);
    }

}
