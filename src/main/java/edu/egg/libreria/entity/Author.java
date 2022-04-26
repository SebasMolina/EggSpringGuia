package edu.egg.libreria.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "author", indexes = {@Index(name = "idx_author_name", columnList = "author_name")})
@Getter
@Setter
@NoArgsConstructor
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "author_id")
    private int id;
    @Column(name = "author_name", nullable = false, length = 50)
    private String name;
    @Column(name = "author_registration", nullable = false)
    private boolean registration;
    @Column(name = "author_deregistration", nullable = false)
    private boolean deregistration;

}
