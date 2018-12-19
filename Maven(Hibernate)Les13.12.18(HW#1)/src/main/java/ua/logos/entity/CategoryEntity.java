package ua.logos.entity;

//4: category
//- назва категорії(не null, до 50 символів, унікальне)
//- опис категорії


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@ToString

@Entity
@Table(name = "category")
public class CategoryEntity extends BaseEntity {

    @Column(nullable = false, length = 50, unique = true)
    private String categoryName;

    @Column(columnDefinition = "text")
    private String categoryDescription;

    @OneToMany(mappedBy = "category")
    private List<BookCategoryEntity> bookCategory;
}
