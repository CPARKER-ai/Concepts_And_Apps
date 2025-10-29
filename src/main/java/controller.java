package org.concepts3060.pa03project.controller;

import org.concepts3060.pa03project.DTO;
import org.concepts3060.pa03project.service.ResourcesService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/resources")
public class ResourcesController {

    private static final Logger logger = LoggerFactory.getLogger(ResourcesController.class);
    private final ResourcesService service;

    // Constructor-based Dependency Injection
    public ResourcesController(ResourcesService service) {
        this.service = service;
    }

    // GET /api/resources?category=&q=
    @GetMapping
    public List<DTO> getResources(
            @RequestParam Optional<String> category,
            @RequestParam Optional<String> q
    ) {
        logger.info("GET /api/resources called with category={} and q={}", category.orElse("none"), q.orElse("none"));
        return service.findByFilters(category, q);
    }

    // GET /api/resources/{id}
    @GetMapping("/{id}")
    public ResponseEntity<DTO> getResourceById(@PathVariable String id) {
        logger.info("GET /api/resources/{} called", id);
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}

