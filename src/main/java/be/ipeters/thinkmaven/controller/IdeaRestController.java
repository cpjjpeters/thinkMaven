package be.ipeters.thinkmaven.controller;

import be.ipeters.thinkmaven.model.IdeaDto;
import be.ipeters.thinkmaven.service.IdeaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/api/v1/ideas")
public class IdeaRestController {
    private final IdeaService ideaService;

    public IdeaRestController(IdeaService ideaService) {
        this.ideaService = ideaService;
        log.info("IdeaRestController created");
    }

    @GetMapping(value = {"", "/", "/all"})
    public List<IdeaDto> getAllIdeas() {
        log.info("getAllIdeas called");
        return ideaService.getAllIdeas();
    }

    @PostMapping("/create")
    public String createIdea(@RequestBody IdeaDto ideaDto) {
        log.info("createIdea called");
        return ideaService.addIdea(ideaDto);
    }

    @PostMapping("/save")
    public IdeaDto saveIdea(@RequestBody IdeaDto ideaDto) {
        log.info("createIdea called");
        return ideaService.saveIdea(ideaDto);
    }
    @GetMapping(value = "/{id}")
    public ResponseEntity<IdeaDto> findById(@PathVariable(value = "id") Long id) {
        log.debug("findById: {}", id);
        IdeaDto ideaDto = ideaService.getIdeaById(id);
        return ResponseEntity.ok().body(ideaDto);
    }

    @PutMapping(value = "/update/{id}")
    public ResponseEntity<IdeaDto> update(@PathVariable("id") Long id, @RequestBody IdeaDto updateIdea) {
        log.debug("update: {}", id);
        updateIdea.setId(id);
        final IdeaDto updatedIdea = ideaService.updateIdea(updateIdea);
        return ResponseEntity.ok().body(updatedIdea);
    }

    @DeleteMapping(value = "/delete/{id}")
    public Map<String, Boolean> deleteById(@PathVariable("id") Long id) {
        log.debug("deleteById: {}", id);
        ideaService.deleteIdeaById(id);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }

}
