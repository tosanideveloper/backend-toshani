package com.toshaniFintech.user_service.service.impl;

import com.toshaniFintech.common.dto.response.PaginatedResponse;
import com.toshaniFintech.common.utils.Utility;
import com.toshaniFintech.user_service.dto.request.UserMasterFetchRequestDTO;
import com.toshaniFintech.user_service.dto.request.UserMasterRequestDTO;
import com.toshaniFintech.user_service.dto.response.UserMasterResponse;
import com.toshaniFintech.user_service.entity.EntityMasterEntity;
import com.toshaniFintech.user_service.entity.UserMasterEntity;
import com.toshaniFintech.user_service.mapper.UserMasterMapper;
import com.toshaniFintech.user_service.repository.EntityMasterRepository;
import com.toshaniFintech.user_service.repository.UserMasterRepository;
import com.toshaniFintech.user_service.service.UserMasterService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
@Service
public class UserMasterServiceImpl implements UserMasterService {

    @Autowired
    private UserMasterRepository repository;

    @Autowired
    private EntityMasterRepository entityRepo;

    @Autowired
    private UserMasterMapper mapper;

    @Override
    public UserMasterResponse create(UserMasterRequestDTO request) {

        EntityMasterEntity entity = entityRepo.findByEntityUuid(request.getEntityUuid())
                .orElseThrow(() -> new RuntimeException("Entity not found"));

        UserMasterEntity user = new UserMasterEntity();
        user.setUserUuid(UUID.randomUUID().toString());
        user.setUsername(request.getUsername());
        user.setPassword(request.getPassword());
        user.setEmailId(request.getEmailId());
        user.setMobileNo(request.getMobileNo());
        user.setFirstName(request.getFirstName());
        user.setMiddleName(request.getMiddleName());
        user.setLastName(request.getLastName());
        user.setEntityMaster(entity);
        user.setEntityAdmin(request.getEntityAdmin());
        user.setRole(request.getRole());
        user.setUserType(request.getUserType());
        user.setSettlementType(request.getSettlementType());

        return mapper.toUserDto(repository.save(user));
    }

    @Override
    public UserMasterResponse update(String uuid, UserMasterRequestDTO request) {

        UserMasterEntity user = repository.findByUserUuid(uuid)
                .orElseThrow(() -> new RuntimeException("User not found"));

        user.setUsername(request.getUsername());
        user.setEmailId(request.getEmailId());
        user.setMobileNo(request.getMobileNo());

        return mapper.toUserDto(repository.save(user));
    }

    @Override
    public UserMasterResponse getByUuid(String uuid) {
        return mapper.toUserDto(
                repository.findByUserUuid(uuid)
                        .orElseThrow(() -> new RuntimeException("User not found"))
        );
    }

    @Override
    public PaginatedResponse<UserMasterResponse> getAll(UserMasterFetchRequestDTO request) {

        PageRequest page = Utility.pageRequest(
                request.getPageNo(),
                request.getPageSize(),
                request.getSortBy(),
                request.getOrderBy()
        );

        Page<UserMasterEntity> data = repository.fetchUsers(
                request.getUsername(),
                request.getSearch(),
                request.getSearchByField(),
                page
        );

        List<UserMasterResponse> list = data.getContent()
                .stream()
                .map(mapper::toUserDto)
                .toList();

        return Utility.paginatedResponseForSubList(
                data.getNumber(),
                data.getTotalPages(),
                data.getSize(),
                data.getNumberOfElements(),
                data.getTotalElements(),
                list
        );
    }
}
