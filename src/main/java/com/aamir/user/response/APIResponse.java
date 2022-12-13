package com.aamir.user.response;

import lombok.*;
import org.springframework.http.HttpStatus;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class APIResponse {
    private String message;
    private boolean success;
    private HttpStatus status;

}
