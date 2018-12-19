package ua.logos.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@ToString

@Entity
@Table(name = "library")
public class LibraryEntity extends BaseEntity{

    private String libraryName;

  //  library - address (* - 1)

    @ManyToOne
    @JoinColumn(name = "address_id")
    private AddressEntity addressLib;
}
