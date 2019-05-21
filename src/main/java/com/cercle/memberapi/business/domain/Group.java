package com.cercle.memberapi.business.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.ZonedDateTime;
import java.util.UUID;


@AllArgsConstructor
@Data
@Entity(name = "`group`")
public class Group {

    @Id
    @Column(length = 128)
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    private String id;


    private String name;
    private Boolean active;
    private ZonedDateTime creationDate;
}
