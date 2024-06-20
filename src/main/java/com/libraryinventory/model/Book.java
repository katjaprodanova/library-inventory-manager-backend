package com.libraryinventory.model;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
@Data
@Entity
@Getter
@Setter
@Table(name = "books")
public class Book implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String bookName;

    private String author;

    @ManyToOne
    private Category category;

    private Long numberOfPages;

    @Column(length = 4000)
    private String description;

    @Column(length = 5000)
    private String imgUrl;
}
