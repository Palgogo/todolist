package by.palgogo.todolist.domain;

import javax.persistence.*;

@Entity
@Table(name = "task")
public class Task {

    @Id
    @GeneratedValue(generator = "sequenceGenerator", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "status", nullable = false)
   private Boolean doneStatus;
}
