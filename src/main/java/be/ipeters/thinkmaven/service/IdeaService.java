package be.ipeters.thinkmaven.service;

import be.ipeters.thinkmaven.model.IdeaDto;
import org.springframework.stereotype.Service;

import java.util.List;

public interface IdeaService {
    IdeaDto getIdeaById(Long id);
    IdeaDto saveIdea(IdeaDto ideaDto);
    IdeaDto updateIdea(IdeaDto ideaDto);
    void deleteIdeaById(Long id);
    void deleteIdea(IdeaDto ideaDto);
    List<IdeaDto> getAllIdeas() ;
    String addIdea(IdeaDto ideaDto);
}
