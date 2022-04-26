package edu.egg.libreria.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "publisher", indexes = {@Index(name = "idx_publisher_name", columnList = "publisher_name")})
@Getter
@Setter
@NoArgsConstructor
public class Publisher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "publisher_id")
    private int id;
    @Column(name = "publisher_name", nullable = false, length = 50)
    private String name;
    @Column(name = "publisher_registration", nullable = false)
    private boolean registration;
    @Column(name = "publisher_deregistration", nullable = false)
    private boolean deregistration;

}
