package edu.egg.libreria.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;

@Entity
@Table(name = "publisher", indexes = {@Index(name = "idx_publisher_name", columnList = "publisher_name")})
@Getter
@Setter
@NoArgsConstructor
@SQLDelete(sql= "UPDATE publisher SET publisher_registration=false WHERE publisher_id = ?")
@Where(clause = "publisher_registration = true")
public class Publisher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "publisher_id")
    private Integer id;
    @Column(name = "publisher_name", nullable = false, length = 50)
    private String name;
    @Column(name = "publisher_registration", nullable = false)
    private boolean registration;
}
