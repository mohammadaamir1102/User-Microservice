package com.aamir.user.entity;

import lombok.*;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Hotel {

    private Long hotelId;
    private String name;
    private String location;
    private String about;

}
