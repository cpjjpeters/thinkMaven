package be.ipeters.thinkmaven.model;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class IdeaDto {

    private Long id;
    private String idea;
    private String description;
    private String author;
    private String category;
    
}
