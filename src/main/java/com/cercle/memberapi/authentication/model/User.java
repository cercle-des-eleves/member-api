package com.cercle.memberapi.authentication.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.ZonedDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@Entity()
public class User {
    @Id
    @Column(length = 128,updatable = false, nullable = false)
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    private String id;
    private String mail;
    private String password;
    private String[] roles;
}
