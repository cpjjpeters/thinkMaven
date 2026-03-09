package be.ipeters.thinkmaven.service;

import be.ipeters.thinkmaven.model.IdeaDto;
import org.springframework.stereotype.Service;

import java.util.List;

public interface IdeaService {
    IdeaDto getIdeaById(Long id);
    IdeaDto updateIdea(IdeaDto ideaDto);
    void deleteIdeaById(Long id);
    List<IdeaDto> getAllIdeas() ;

    IdeaDto saveIdea(IdeaDto ideaDto);

    String addIdea(IdeaDto ideaDto);
}
