package com.toshaniFintech.user_service.mapper;

import com.toshaniFintech.user_service.dto.response.EnquiryFormLogResponse;
import com.toshaniFintech.user_service.entity.EnquiryFormLogEntity;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", builder = @Builder(disableBuilder = true))

public interface EnquiryFormLogMapper {
    EnquiryFormLogResponse toResponse(EnquiryFormLogEntity entity);

}
