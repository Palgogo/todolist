package by.palgogo.todolist.domain;

import javax.persistence.*;

public class Category {
    @Id
    @GeneratedValue(generator = "sequenceGenerator", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;
}
