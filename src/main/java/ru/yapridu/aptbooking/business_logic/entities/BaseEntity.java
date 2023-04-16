package ru.yapridu.aptbooking.business_logic.entities;

import io.ebean.annotation.WhenCreated;
import io.ebean.annotation.WhenModified;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;
import java.time.Instant;
import java.util.UUID;

@NoArgsConstructor(access = AccessLevel.PROTECTED, force = true)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@EqualsAndHashCode(callSuper = false, onlyExplicitlyIncluded = true)
@SuperBuilder(toBuilder = true)
@MappedSuperclass
public class BaseEntity {

    @Id
    @EqualsAndHashCode.Include
    private final UUID id;

    @WhenCreated
    private final Instant createdDate;

    @WhenModified
    private final Instant modifiedDate;

    @Version
    private final Long version;

}
