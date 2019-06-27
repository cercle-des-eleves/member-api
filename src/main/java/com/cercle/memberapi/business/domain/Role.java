package com.cercle.memberapi.business.domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@AllArgsConstructor
@Entity
public class Role {

    @Id
    @Column(length = 128,updatable = false, nullable = false)
    @GeneratedValue(generator="system-id")
    @GenericGenerator(name="system-id", strategy = "id")
    private String id;
    private String name;
}
