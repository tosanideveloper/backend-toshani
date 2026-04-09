package com.toshaniFintech.common.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Page;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaginatedResponse<T> {
    private List<T> data;
    private long pageNumber;
    private long pageSize;
    private long totalElements;
    private long totalPages;
    private long numberOfElements;

    public PaginatedResponse(Page<?> page){
        this.pageNumber = page.getNumber();

        this.numberOfElements = page.getNumberOfElements();
        this.totalElements = page.getTotalElements();

        this.pageSize = page.getSize();
        this.totalPages = page.getTotalPages();
    }
}
