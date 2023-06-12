package ru.yapridu.aptbooking.business_logic.models;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import ru.yapridu.aptbooking.business_logic.entities.BaseEntity;

@NoArgsConstructor(access = AccessLevel.PROTECTED, force = true)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@SuperBuilder(toBuilder = true)
public class VersionedModelDTO extends ModelDTO {

    private final Long version;

    public static VersionedModelDTO of(BaseEntity entity) {

        return VersionedModelDTO.builder()
            .id(entity.getId())
            .version(entity.getVersion())
            .build();
    }
}