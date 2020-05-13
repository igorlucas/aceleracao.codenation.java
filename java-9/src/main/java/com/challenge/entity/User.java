package com.challenge.entity;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalTime;
import java.util.Set;


@Entity
@EntityListeners(AuditingEntityListener.class)
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    @NotNull
    @Size(max = 100)
    private String fullName;

    @Size(max = 100)
    @NotNull
    @Email
    private String email;

    @NotNull
    @Size(max = 50)
    private String nickname;


    @NotNull
    @Size(max = 255)
    private String password;

    @CreatedDate
    @NotNull
    private LocalTime createdAt;

    @OneToMany(mappedBy = "id.user")
    private Set<Submission> submissions;

    @OneToMany(mappedBy = "id.user")
    private Set<Candidate> candidates;
}
