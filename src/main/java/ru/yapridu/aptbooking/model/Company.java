package ru.yapridu.aptbooking.model;

import lombok.*;
import ru.yapridu.aptbooking.model.security.User;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;

@Entity
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
//@Table(name = "company")
public class Company implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn
    @NotEmpty
    private User owningUser;

    @Size(min = 3, message = "Имя не может быть короче 3 знаков.")
    private String name;

    @NotEmpty
    private String address;

    @NotEmpty
    private String contact;

    @NotEmpty
    private String officialCompanyDetails;

    @NotEmpty
    private String description;

    @NotEmpty
    private Date createdDate;

    private Date modifiedDate;

    @NotEmpty
    private Integer version;
}