package com.ghost.service;

import com.ghost.entity.KnowledgeDocument;
import com.ghost.repository.KnowledgeDocumentRepository;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class RetrievalServiceTest {

    @Test
    void shouldReturnRelevantDocuments() {

        KnowledgeDocumentRepository repository =
                mock(KnowledgeDocumentRepository.class);

        KnowledgeDocument spring = new KnowledgeDocument();
        spring.setTitle("Spring Boot");
        spring.setContent(
                "Spring Boot is used for Java backend development."
        );

        KnowledgeDocument database = new KnowledgeDocument();
        database.setTitle("PostgreSQL");
        database.setContent(
                "PostgreSQL stores relational application data."
        );

        when(repository.findAll())
                .thenReturn(List.of(spring, database));

        RetrievalService service =
                new RetrievalService(repository);

        List<KnowledgeDocument> results =
                service.retrieve("spring backend");

        assertEquals(1, results.size());
        assertEquals("Spring Boot", results.get(0).getTitle());

        verify(repository, times(1)).findAll();
    }
}
