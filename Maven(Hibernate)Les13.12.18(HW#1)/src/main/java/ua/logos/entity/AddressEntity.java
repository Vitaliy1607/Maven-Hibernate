//6: address
//- країна(не null, до 50 символів)
//- місто(не null, до 80 символів)
//- вулиця(не null, до 120 символів)
//- номер будинку(не null)
//- номер квартири(не null)

package ua.logos.entity;



import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString(callSuper = true , exclude = {"users", "library"})

@Entity
@Table(name = "address")
public class AddressEntity extends BaseEntity {


    @Column(nullable = false, length = 50)
    private String country;

    @Column(nullable = false, length = 80)
    private String city;

    @Column(nullable = false, length = 120)
    private String street;

    @Column(nullable = false)
    private int houseNumber;

    @Column(nullable = false)
    private int roomNumber;

    @OneToMany(mappedBy = "addressUser")
    private List<UserEntity> users;

    @OneToMany(mappedBy = "addressLib")
    private List<LibraryEntity> library;
}
