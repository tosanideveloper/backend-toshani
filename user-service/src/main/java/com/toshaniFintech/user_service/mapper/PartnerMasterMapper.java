package com.toshaniFintech.user_service.mapper;

import com.toshaniFintech.user_service.dto.response.PartnerMasterResponse;
import com.toshaniFintech.user_service.entity.PartnerMasterEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PartnerMasterMapper {

    @Mapping(source = "clientMaster.clientUuid", target = "clientUuid")
    PartnerMasterResponse toResponseDto(PartnerMasterEntity entity);
}
