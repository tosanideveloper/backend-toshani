package com.toshaniFintech.user_service.mapper;

import com.toshaniFintech.user_service.dto.response.ChannelMasterResponse;
import com.toshaniFintech.user_service.entity.ChannelMasterEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ChannelMasterMapper {

    @Mapping(source = "clientMaster.clientUuid", target = "clientUuid")
    @Mapping(source = "partnerMaster.partnerUuid", target = "partnerUuid")
    ChannelMasterResponse toDto(ChannelMasterEntity entity);
}
