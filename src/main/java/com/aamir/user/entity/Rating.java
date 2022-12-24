package com.aamir.user.entity;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Rating {

    private Long ratingId;
    private Long userId;
    private Long hotelId;
    private Integer rating;
    private String feedBack;
}
