package com.example.demo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

import static javax.persistence.GenerationType.SEQUENCE;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity(name ="Student")
@Table(
        name= "student",
        uniqueConstraints = {
                @UniqueConstraint(name= "student_email_unique", columnNames = "email")
        }
)
public class Student {
    @Id
    @SequenceGenerator(
            name= "student_sequence",
            sequenceName = "student_sequence",
            allocationSize = 1
    )
    @GeneratedValue( // otomatik 1 arttırmak
            strategy = SEQUENCE,
            generator="student_sequence"
    )
    @Column(
            name = "id",
            updatable = false
    )
    private Long id;
    @Column(
            name = "first_name",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String firstName;

    @Column(
            name = "last_name",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String lastName;
    @Column(
            name = "email",
            nullable = false,
            columnDefinition = "TEXT"

    )
    private String email;
    @Column(
            name = "age",
            nullable = false

    )
    private Integer age;

    public Student(String firstName, String lastName, String email, int age) {
        this.firstName= firstName;
        this.lastName = lastName;
        this.email = email;
        this.age= age;
    }
}
