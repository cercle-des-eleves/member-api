package com.cercle.memberapi.business.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;


@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@DiscriminatorValue("Club")
public class Club extends Organization {

}
