package be.ipeters.thinkmaven.service;

import be.ipeters.thinkmaven.entity.IdeaEntity;
import be.ipeters.thinkmaven.mapper.IdeaMapper;
import be.ipeters.thinkmaven.model.IdeaDto;
import be.ipeters.thinkmaven.repository.IdeaRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class IdeaServiceImpl implements IdeaService {

    public IdeaServiceImpl(IdeaRepository ideaRepository, IdeaMapper ideaMapper) {
        this.ideaRepository = ideaRepository;
        this.ideaMapper = ideaMapper;
    }

    @Override
    public IdeaDto getIdeaById(Long id) {
        return null;
    }
    private final IdeaRepository ideaRepository;
    private final IdeaMapper ideaMapper;

    @Override
    public IdeaDto saveIdea(IdeaDto ideaDto) {
        final IdeaEntity ideaEntity = this.ideaRepository.save(ideaMapper.toEntity(ideaDto));

        log.debug("Idea saved successfully ");
        return ideaMapper.toDto(ideaEntity);
    }

    @Override
    public IdeaDto updateIdea(IdeaDto ideaDto) {
        return null;
    }

    @Override
    public void deleteIdeaById(Long id) {

    }

    @Override
    public void deleteIdea(IdeaDto ideaDto) {

    }

    @Override
    public List<IdeaDto> getAllIdeas() {
        return List.of();
    }

    @Override
    public String addIdea(IdeaDto ideaDto) {
        return "";
    }
}
