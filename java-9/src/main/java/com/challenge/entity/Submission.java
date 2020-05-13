package com.challenge.entity;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalTime;

@Entity
@EntityListeners(AuditingEntityListener.class)
public class Submission implements Serializable {

    @EmbeddedId
    private SubmissionKey id;

    @NotNull
    private float score;

    @NotNull
    @CreatedDate
    private LocalTime createdAt;
}
