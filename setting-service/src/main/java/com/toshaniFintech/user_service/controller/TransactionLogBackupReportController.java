package com.toshaniFintech.user_service.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.toshaniFintech.common.dto.response.PaginatedResponse;
import com.toshaniFintech.user_service.dto.request.TransactionLogBackupReportRequest;
import com.toshaniFintech.user_service.dto.response.TransactionLogBackupReportResponse;
import com.toshaniFintech.user_service.service.TransactionLogBackupReportService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/transaction-log-backup-report")
@Tag(name = "Transaction Log Backup Report Service API", description = "APIs for Transaction Log Backup Report Service CRUD")
public class TransactionLogBackupReportController {
    @Autowired
    private TransactionLogBackupReportService transactionLogBackupReportService;

    @Autowired
    private ObjectMapper objectMapper;

    @PostMapping("/all")
    @Operation(summary = "Transaction Log Backup Report",
            description = "Get Transaction Log Backup Report with pagination and advanced filter")
    @ApiResponses(value = {@ApiResponse(responseCode = "200",
            description = "Transaction Log Backup Report fetched successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid input data"),
            @ApiResponse(responseCode = "500", description = "Internal server error")})
    public ResponseEntity<PaginatedResponse<TransactionLogBackupReportResponse>> fetchTransactionLogBackupReport
            (@Valid @RequestBody TransactionLogBackupReportRequest transactionLogBackupReportRequest) {

        return new ResponseEntity<>(transactionLogBackupReportService.fetchTransactionLogBackupReport
                (transactionLogBackupReportRequest), HttpStatus.OK);
    }
}
