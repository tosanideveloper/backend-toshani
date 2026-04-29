package com.toshaniFintech.user_service.mapper;

import com.toshaniFintech.user_service.dto.response.UserMasterResponse;
import com.toshaniFintech.user_service.entity.UserMasterEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMasterMapper {

    @Mapping(source = "entityMaster.entityUuid", target = "entityUuid")
    UserMasterResponse toUserDto(UserMasterEntity entity);
}