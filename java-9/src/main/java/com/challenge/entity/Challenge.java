package com.challenge.entity;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalTime;
import java.util.Set;

@Entity
@EntityListeners(AuditingEntityListener.class)
public class Challenge implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull
    @Size(max = 100)
    private String name;

    @NotNull
    @Size(max = 50)
    private String slug;

    @NotNull
    @CreatedDate
    private LocalTime createdAt;

    @OneToMany(mappedBy = "challenge")
    private Set<Acceleration> accelerations;

    @OneToMany(mappedBy = "id.challenge")
    private Set<Submission> submissions;


}
