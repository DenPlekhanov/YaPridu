package ru.yapridu.aptbooking.business_logic.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldNameConstants;
import lombok.experimental.SuperBuilder;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@EqualsAndHashCode(callSuper = true, onlyExplicitlyIncluded = true)
@FieldNameConstants
@SuperBuilder(toBuilder = true)
@Entity
public class Service extends BaseEntity {

    private String name;

    @ManyToOne()
    @JsonIgnore()
    private Company company;

}
