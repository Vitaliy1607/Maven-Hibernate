package ua.logos.entity;
//3: author
//- імя(не null)
//- прізвище(не null)
//- роки життя
//- біографія(text)

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString

@Entity
@Table(name = "author")
public class AuthorEntity extends BaseEntity {

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(columnDefinition = "date")
    private String birthDate;

    @Column(columnDefinition = "date")
    private String deadDate;

    @Column(columnDefinition = "text")
    private String biography;
}
