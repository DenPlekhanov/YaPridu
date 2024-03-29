package ru.yapridu.aptbooking.model.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "t_user")
public class User {
    public User(String username) {
        this.username = username;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(min = 2, message = "Не меньше 2 знаков")
    private String username;

//    @NotEmpty //TODO Разобраяться с валидацией.
//    private Date createdDate;
//
//    private Date modifiedDate;

//    @NotEmpty
    private Integer version;
}
