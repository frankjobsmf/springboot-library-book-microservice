package com.library.bookmicroservice.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Column(name = "date_launch")
    private Date dateLaunch;
    private Integer stock;
    @Column(name = "author_id")
    private Long authorId;
    @Column(name = "category_id")
    private Long categoryId;

    @Transient
    private Author author;
    @Transient
    private Category category;
}
