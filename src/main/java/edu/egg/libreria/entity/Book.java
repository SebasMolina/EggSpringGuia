package edu.egg.libreria.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "book")
@Getter
@Setter
@NoArgsConstructor
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id")
    private int id;
    @Column(name = "book_isbn", unique = true, nullable = false)
    private String isbn;
    @Column(name = "book_title", nullable = false, length = 100)
    private String title;
    @Column(name = "book_year", nullable = false, columnDefinition = "DATE")
    private LocalDate year;
    @Column(name = "book_copies", nullable = false)
    private int copies;
    @Column(name = "book_borrowed_copies", nullable = false)
    private int borrowedCopies;
    @Column(name = "book_remaining_copies", nullable = false)
    private int remainingCopies;
    @Column(name = "book_registration", nullable = false)
    private boolean registration;
    @Column(name = "book_deregistration", nullable = false)
    private boolean deregistration;
    @ManyToOne(fetch = FetchType.EAGER)
    private Author author;
    @ManyToOne(fetch = FetchType.EAGER)
    private Publisher publisher;

}
