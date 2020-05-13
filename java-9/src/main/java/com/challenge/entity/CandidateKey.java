package com.challenge.entity;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Embeddable
public class CandidateKey implements Serializable {

    @ManyToOne
    private User user;

    @ManyToOne
    private Acceleration acceleration;

    @ManyToOne
    private Company company;

}