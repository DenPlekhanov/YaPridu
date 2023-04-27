package ru.yapridu.aptbooking.business_logic.entities;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.UUID;

@Entity
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "company")
public class CompanyOld implements Serializable {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;

    //@ManyToOne(fetch = FetchType.EAGER)
    //@JoinColumn
//    @NotEmpty //TODO Разобраяться с валидацией.
    //private UserOld owningUser;

    //@Size(min = 2, message = "Имя не может быть короче 2 знаков.")
    private String name;

//    @NotEmpty
    private String address;

//    @NotEmpty
    private String contact;

//    @NotEmpty
    private String officialCompanyDetails;

//    @NotEmpty
    private String description;

//    @NotEmpty
//    private Date createdDate;
//
//    private Date modifiedDate;

//    @NotEmpty
    private Integer version;
}
