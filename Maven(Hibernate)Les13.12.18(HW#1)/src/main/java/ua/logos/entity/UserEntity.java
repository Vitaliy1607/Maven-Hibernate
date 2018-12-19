package ua.logos.entity;

// імя(не null, до 50 символів)
//- номер тел.(не null, до 15 символів, унікальне)
//- email(не null, до 50 символів, унікальне)
//- дата народження(не null)  (Date або LocalDate)
//- деталі(кількість символів без ліміту)
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString(callSuper = true , exclude = {"addressUser", "takenBook"})

@Entity
@Table(name = "users")
public class UserEntity extends BaseEntity {

    @Column(nullable = false, length = 50)
    private String name;

    @Column(nullable = false, length = 15, unique = true)
    private long telNumber;

    @Column(nullable = false, length = 50, unique = true)
    private String email;

    @Column(columnDefinition = "Date", nullable = false)
    private int birthDay;

    @Column(columnDefinition = "text")
    private String details;
  //  user - address (* - 1)
    @ManyToOne
    @JoinColumn(name = "address_id")
    private AddressEntity addressUser;

    @OneToMany(mappedBy = "user")
    private List<TakenBook> takenBook;

    //user - library (* - *)

    @ManyToMany
    @JoinTable(name = "user_library",
    joinColumns = @JoinColumn(name = "user_id"),
    inverseJoinColumns = @JoinColumn(name = "library_id"))
    private List<LibraryEntity> libraryEntity;

}
