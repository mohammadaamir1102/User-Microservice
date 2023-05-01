package com.aamir.user.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "USER_MICRO")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_USER_ID")
    @SequenceGenerator(name = "SEQ_USER_ID", sequenceName = "SEQ_USER_ID", allocationSize = 1)
    @Column(name = "USER_ID", unique = true, nullable = false)
    private Long userId;

    @Column(name = "USER_NAME")
    private String userName;

    @Column(name = "USER_EMAIL")
    private String userEmail;
    @Column(name = "USER_ABOUT")
    private String about;

    @Column(name = "ACTIVE_USER")
    private Boolean activeUser = true;
    @JsonFormat(pattern = "dd-mm-yyyy")
    @Column(name = "USER_DOB")
    private Timestamp dob;
    @CreationTimestamp
    @Column(name = "CREATED_ON")
    private Timestamp createdOn;

    @UpdateTimestamp
    @Column(name = "UPDATED_ON")
    private Timestamp updatedOn;

    @Transient
    List<Rating> ratings = new ArrayList<>();

}
