package be.ipeters.thinkmaven.entity;

import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "ideas")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
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
