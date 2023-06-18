package ru.yapridu.aptbooking.business_logic.entities;

import lombok.*;
import lombok.experimental.FieldNameConstants;
import lombok.experimental.SuperBuilder;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;
import java.util.List;
import java.util.UUID;

@NoArgsConstructor  //(access = AccessLevel.PRIVATE, force = true)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@Setter
@EqualsAndHashCode(callSuper = true, onlyExplicitlyIncluded = true)
@FieldNameConstants
@SuperBuilder(toBuilder = true)
@Entity
public class Company extends BaseEntity {

    private UUID ownerId;

    private String name;

    private String address;

    private String contact;

    private String officialDetails;

    private String description;

    @OneToMany(mappedBy = "company")
    private List<Service> services;
}
