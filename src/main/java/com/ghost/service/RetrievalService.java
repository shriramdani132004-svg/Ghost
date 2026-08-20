package com.ghost.service;

import com.ghost.entity.KnowledgeDocument;
import com.ghost.repository.KnowledgeDocumentRepository;
import org.springframework.stereotype.Service;

import java.util.*;
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

        Set<String> keywords = Arrays.stream(query.toLowerCase().trim().split("\\s+"))
                .filter(word -> word.length() > 2)
                .collect(Collectors.toSet());

        return repository.findAll()
                .stream()
                .map(document -> new ScoredDocument(
                        document,
                        calculateScore(document, keywords)))
                .filter(result -> result.score() > 0)
                .sorted(Comparator.comparingInt(ScoredDocument::score).reversed())
                .map(ScoredDocument::document)
                .toList();
    }

    private int calculateScore(
            KnowledgeDocument document,
            Set<String> keywords) {

        String title = document.getTitle().toLowerCase();
        String content = document.getContent().toLowerCase();

        int score = 0;

        for (String keyword : keywords) {
            if (title.contains(keyword)) {
                score += 3;
            }

            if (content.contains(keyword)) {
                score += 1;
            }
        }

        return score;
    }

    private record ScoredDocument(
            KnowledgeDocument document,
            int score) {
    }
}
