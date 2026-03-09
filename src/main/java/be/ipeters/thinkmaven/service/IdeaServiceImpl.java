package be.ipeters.thinkmaven.service;

import be.ipeters.thinkmaven.entity.IdeaEntity;
import be.ipeters.thinkmaven.mapper.IdeaMapper;
import be.ipeters.thinkmaven.model.IdeaDto;
import be.ipeters.thinkmaven.repository.IdeaRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class IdeaServiceImpl implements IdeaService {
    private final IdeaRepository ideaRepository;
    private final IdeaMapper ideaMapper;

    public IdeaServiceImpl(IdeaRepository ideaRepository, IdeaMapper ideaMapper) {
        this.ideaRepository = ideaRepository;
        this.ideaMapper = ideaMapper;
    }

    @Override
    public IdeaDto getIdeaById(Long id) {
        return this.ideaRepository.findById(id)
                .map(this.ideaMapper::toDto)
                .orElseThrow();
    }

    @Override
    public IdeaDto saveIdea(IdeaDto ideaDto) {
        final IdeaEntity ideaEntity = this.ideaRepository.save(ideaMapper.toEntity(ideaDto));

        log.debug("Idea saved successfully ");
        return ideaMapper.toDto(ideaEntity);
    }

    @Override
    public String addIdea(IdeaDto ideaDto) {
        IdeaEntity ideaEntity = this.ideaRepository.save(ideaMapper.toEntity(ideaDto));
        log.debug("Idea added successfully ");
        return "Idea added with ID: " + ideaEntity.getId();
    }
    @Override
    public IdeaDto updateIdea(IdeaDto ideaDto) {
        if (ideaDto.getId() == null) {
            throw new IllegalArgumentException("Idea ID must not be null for update");
        }
        IdeaEntity ideaEntity = this.ideaRepository.findById(ideaDto.getId())
                .orElseThrow(() -> new RuntimeException("Idea not found with id: " + ideaDto.getId()));
        
        ideaEntity.setIdea(ideaDto.getIdea());
        ideaEntity.setDescription(ideaDto.getDescription());
        ideaEntity.setAuthor(ideaDto.getAuthor());
        ideaEntity.setCategory(ideaDto.getCategory());
        
        final IdeaEntity updatedEntity = this.ideaRepository.save(ideaEntity);
        log.debug("Idea updated successfully ");
        return ideaMapper.toDto(updatedEntity);
    }

    @Override
    public void deleteIdeaById(Long id) {
        this.ideaRepository.deleteById(id);
    }

    @Override
    public List<IdeaDto> getAllIdeas() {
        return this.ideaRepository.findAll().stream()
                .map(this.ideaMapper::toDto)
                .toList();
    }

}
