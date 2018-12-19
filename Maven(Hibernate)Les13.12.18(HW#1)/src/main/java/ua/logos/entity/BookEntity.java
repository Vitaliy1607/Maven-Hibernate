package ua.logos.entity;

//- isbn(не null, до 50 символів, унікальне)
//- назва книги(не null, до 150 символів)
//- опис
//- дата публікації(не null)

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString(callSuper = true, exclude = {"takenBook", "bookCategory", "author"})

@Entity
@Table(name = "book")
public class BookEntity extends BaseEntity {

    @Column(nullable = false, length = 50, unique = true)
    private String isbn;

    @Column(nullable = false, length = 150)
    private String bookName;

    @Column(columnDefinition = "text")
    private String description;

    @Column(columnDefinition = "Date")
    private String pubDate;

    @OneToMany(mappedBy = "book")
    private List<TakenBook> takenBook;

    @OneToMany(mappedBy = "book")
    private List<BookCategoryEntity> bookCategory;

    //book - author (*-*)
    @ManyToMany
    @JoinTable(name = "book_author",
            joinColumns = @JoinColumn(name = "book_id")
            ,inverseJoinColumns = @JoinColumn(name = "author_id"))
    private List<AuthorEntity> author;

}
