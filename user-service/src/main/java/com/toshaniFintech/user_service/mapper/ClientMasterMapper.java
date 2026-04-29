package com.toshaniFintech.user_service.mapper;

import com.toshaniFintech.user_service.dto.response.ClientMasterResponse;
import com.toshaniFintech.user_service.entity.ClientMasterEntity;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", builder = @Builder(disableBuilder = true))
public interface ClientMasterMapper {

    ClientMasterResponse toResponseDto(ClientMasterEntity entity);
}