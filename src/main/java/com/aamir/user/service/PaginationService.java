package com.aamir.user.service;

import com.aamir.user.dto.PaginationDTO;
import com.aamir.user.exception.ServiceException;
import org.springframework.data.domain.Pageable;

public interface PaginationService {
    Pageable getPagination(PaginationDTO paginationDTO) throws ServiceException;

}
