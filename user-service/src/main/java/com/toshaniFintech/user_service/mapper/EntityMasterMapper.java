package com.toshaniFintech.user_service.mapper;

import com.toshaniFintech.user_service.dto.response.EntityMasterResponse;
import com.toshaniFintech.user_service.entity.EntityMasterEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface EntityMasterMapper {

    @Mapping(source = "clientMaster.clientUuid", target = "clientUuid")
    @Mapping(source = "partnerMaster.partnerUuid", target = "partnerUuid")
    @Mapping(source = "channelMaster.channelUuid", target = "channelUuid")
    @Mapping(source = "hierarchyMaster.hirarchyUuid", target = "hirarchyUuid")
    EntityMasterResponse toDto(EntityMasterEntity entity);
}
