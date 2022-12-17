package com.aamir.user.service.impl;

import com.aamir.user.constant.ErrorConstant;
import com.aamir.user.dto.PaginationDTO;
import com.aamir.user.exception.ServiceError;
import com.aamir.user.exception.ServiceException;
import com.aamir.user.service.PaginationService;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class PaginationServiceImpl implements PaginationService {
    @Override
    public Pageable getPagination(PaginationDTO paginationDTO) throws ServiceException {
        if (StringUtils.isEmpty(paginationDTO.getOffset()) && StringUtils.isEmpty(paginationDTO.getPageNumber())) {
            ServiceError serviceError = new ServiceError(ErrorConstant.OFFSET_AND_PAGE_NUMBER_ERROR_CODE,
                    ErrorConstant.OFFSET_AND_PAGE_NUMBER_MESSAGE);
            throw new ServiceException(serviceError, HttpStatus.BAD_REQUEST);
        }
        return PageRequest.of(paginationDTO.getPageNumber(), paginationDTO.getPageNumber(), Sort.by("userId").descending());
    }
}
