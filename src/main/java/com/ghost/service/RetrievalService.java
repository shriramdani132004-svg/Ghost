package com.ghost.service;

import com.ghost.entity.KnowledgeDocument;
import com.ghost.repository.KnowledgeDocumentRepository;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RetrievalService {

    private final KnowledgeDocumentRepository repository;

    public RetrievalService(KnowledgeDocumentRepository repository) {
        this.repository = repository;
    }

    public List<KnowledgeDocument> retrieve(String query) {

        if (query == null || query.isBlank()) {
            return List.of();
        }

        String[] keywords = query.toLowerCase()
                .split("\\s+");

        return repository.findAll()
                .stream()
                .filter(document -> {

                    String searchableText =
                            (document.getTitle() + " " +
                             document.getContent()).toLowerCase();

                    return Arrays.stream(keywords)
                            .anyMatch(searchableText::contains);
                })
                .collect(Collectors.toList());
    }
}
