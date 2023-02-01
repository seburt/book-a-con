package com.seburt.bookacon.core.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

@Entity
public class ConferenceEntity extends BasicEntity{

    @Column(name = "headcount")
    protected Integer headcount;

    @Column(name = "scheduleSlot")
    protected Integer scheduleSlot;

    @Column(name = "occupation")
    protected Integer occupation;

}
