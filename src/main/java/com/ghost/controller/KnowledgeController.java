package com.ghost.controller;

import com.ghost.entity.KnowledgeDocument;
import com.ghost.repository.KnowledgeDocumentRepository;
import com.ghost.service.RetrievalService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/knowledge")
public class KnowledgeController {

    private final KnowledgeDocumentRepository repository;
    private final RetrievalService retrievalService;

    public KnowledgeController(
            KnowledgeDocumentRepository repository,
            RetrievalService retrievalService) {
        this.repository = repository;
        this.retrievalService = retrievalService;
    }

    @GetMapping
    public List<KnowledgeDocument> getAllDocuments() {
        return repository.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public KnowledgeDocument createDocument(
            @Valid @RequestBody KnowledgeDocument document) {
        return repository.save(document);
    }

    @GetMapping("/search")
    public List<KnowledgeDocument> search(
            @RequestParam String query) {
        return retrievalService.retrieve(query);
    }
}
