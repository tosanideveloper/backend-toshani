package com.toshaniFintech.user_service.mapper;

import com.toshaniFintech.user_service.dto.response.HierarchyMasterResponse;
import com.toshaniFintech.user_service.entity.HierarchyMasterEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface HierarchyMasterMapper {

    @Mapping(source = "clientMaster.clientUuid", target = "clientUuid")
    @Mapping(source = "partnerMaster.partnerUuid", target = "partnerUuid")
    @Mapping(source = "channelMaster.channelUuid", target = "channelUuid")
    HierarchyMasterResponse toDto(HierarchyMasterEntity entity);
}
