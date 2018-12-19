package ua.logos.entity;
//5: taken_book
//- дата коли взяли книгу(не null, default поточна дата і година) .
//- дата до коли потрібно повернути книгу(не null).


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.query.criteria.internal.expression.function.CurrentTimeFunction;
import org.hibernate.query.criteria.internal.expression.function.CurrentTimestampFunction;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@ToString

@Entity
@Table
public class TakenBook extends BaseEntity {

    @Column()
    private LocalDateTime takeDate;

    @Column(columnDefinition = "date" , nullable = false)
    private String returnDate;
  //  taken_book - book (* - 1)
    @ManyToOne
    @JoinColumn(name = "book_id")
    private BookEntity book;
 //   taken_book - user (* - 1)
    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;
}
