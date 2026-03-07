package be.ipeters.thinkmaven.controller;

import be.ipeters.thinkmaven.model.IdeaDto;
import be.ipeters.thinkmaven.service.IdeaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/v1/ideas")
public class IdeaRestController {
    private final IdeaService ideaService;

    public IdeaRestController(IdeaService ideaService) {
        this.ideaService = ideaService;
        log.info("IdeaRestController created");
    }

    @GetMapping(value = {"/", "/all",""})
    public List<IdeaDto> getAllIdeas() {
        log.info("getAllIdeas called");
        return ideaService.getAllIdeas();
    }
}
