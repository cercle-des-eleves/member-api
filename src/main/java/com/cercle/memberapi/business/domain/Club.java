package com.cercle.memberapi.business.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.time.ZonedDateTime;




@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@DiscriminatorValue("Club")
public class Club extends Group {

}
