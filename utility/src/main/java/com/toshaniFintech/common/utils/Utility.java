package com.toshaniFintech.common.utils;

import com.toshaniFintech.common.dto.response.PaginatedResponse;
import lombok.Data;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.util.List;

@Data
public class Utility {
    public static PageRequest pageRequest(int pageNo, int pageSize, String sortBy, String orderType) {

        PageRequest page = null;
        if (AppConstant.DESC.equalsIgnoreCase(orderType)) {
            page = PageRequest.of(pageNo, pageSize, Sort.by(sortBy).descending());
        } else {
            page = PageRequest.of(pageNo, pageSize, Sort.by(sortBy).ascending());
        }
        return page;
    }

    public static <T> PaginatedResponse<T> paginatedResponseForSubList(
            int number,
            int totalPages,
            int size,
            int numberOfElements,
            long totalElements,
            List<T> data
    ) {
        PaginatedResponse<T> pageResponse = new PaginatedResponse<>();
        pageResponse.setPageNumber(number);
        pageResponse.setTotalPages(totalPages);
        pageResponse.setPageSize(size);
        pageResponse.setNumberOfElements(numberOfElements);
        pageResponse.setTotalElements(totalElements);
        pageResponse.setContent(data);
        return pageResponse;
    }
}