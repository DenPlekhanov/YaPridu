package ru.yapridu.aptbooking.business_logic.models;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import ru.yapridu.aptbooking.business_logic.entities.BaseEntity;

import java.util.UUID;

@NoArgsConstructor(access = AccessLevel.PROTECTED, force = true)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@SuperBuilder(toBuilder = true)
public class ModelDTO {

    private final UUID id;

    public static ModelDTO of(BaseEntity entity) {

        return ModelDTO.builder()
            .id(entity.getId())
            .build();
    }

}
