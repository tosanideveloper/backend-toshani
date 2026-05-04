package com.toshaniFintech.user_service.mapper;

import com.toshaniFintech.user_service.dto.response.HdfcVirtualLogResponse;
import com.toshaniFintech.user_service.entity.HdfcVirtualLogEntity;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", builder = @Builder(disableBuilder = true))
public interface HdfcVirtualLogMapper {
    HdfcVirtualLogResponse toResponse(HdfcVirtualLogEntity entity);
}
