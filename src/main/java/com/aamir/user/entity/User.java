package com.aamir.user.entity;

import com.aamir.user.regex.RegexConstant;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "USER")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_USER_ID")
    @SequenceGenerator(name = "SEQ_USER_ID", sequenceName = "SEQ_USER_ID", allocationSize = 1)
    @Column(name = "USER_ID", unique = true, nullable = false)
    private Long userId;

    @NotBlank(message = "User Name is required & ALPHABETS ONLY !")
    @Pattern(regexp = RegexConstant.ALPHABETS_ONLY, message = "use ALPHABETS ONLY")
    @Column(name = "USER_NAME")
    private String userName;
    @Pattern(regexp = RegexConstant.EMAIL, message = "Mail Should be Proper !")
    @Column(name = "USER_EMAIL")
    private String userEmail;
    @Column(name = "ABOUT")
    private String about;

    @JsonFormat(pattern = "dd-MM-yyyy")
    @Column(name = "DATE_OF_BIRTH", columnDefinition = "insert your date of birth")
    private Timestamp dob;
    @Column(name = "CREATED_ON")
    private Timestamp createdOn;
    @Column(name = "UPDATED_ON")
    private Timestamp updatedOn;

    @Column(name = "ACTIVE_USER", insertable = true)
    private Boolean activeUser;

}
