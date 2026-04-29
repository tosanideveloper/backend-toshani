package com.toshaniFintech.user_service.mapper;

import com.toshaniFintech.user_service.dto.response.TransactionLogBackupReportResponse;
import com.toshaniFintech.user_service.entity.TransactionLogBackupReportEntity;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", builder = @Builder(disableBuilder = true))
public interface TransactionLogBackupReportMapper {
    TransactionLogBackupReportResponse toResponse(TransactionLogBackupReportEntity entity);

}
