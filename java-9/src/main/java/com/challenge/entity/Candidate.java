package com.challenge.entity;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalTime;

@Entity
@EntityListeners(AuditingEntityListener.class)
public class Candidate implements Serializable {

    @EmbeddedId
    private CandidateKey id;

    @NotNull
    private int status;

    @NotNull
    @CreatedDate
    private LocalTime createdAt;
}
