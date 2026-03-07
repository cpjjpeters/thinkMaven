package be.ipeters.thinkmaven.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "ideas")
public class IdeaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;
    @Column(name = "IDEA")
    private String idea;
    @Column(name = "DESCRIPTION")
    private String description;
    @Column(name = "AUTHOR")
    private String author;
    @Column(name = "CATEGORY")
    private String category;

}
