package com.ghost.service;

import com.ghost.entity.KnowledgeDocument;
import com.ghost.repository.KnowledgeDocumentRepository;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RetrievalServiceTest {

    @Test
    void shouldReturnDocumentsMatchingQuery() {

        KnowledgeDocumentRepository repository =
                new KnowledgeDocumentRepository() {
                    @Override
                    public List<KnowledgeDocument> findAll() {
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

                        return List.of(spring, database);
                    }

                    @Override public List<KnowledgeDocument> findAll(
                            org.springframework.data.domain.Sort sort) {
                        return findAll();
                    }

                    @Override public <S extends KnowledgeDocument> S save(S entity) {
                        throw new UnsupportedOperationException();
                    }

                    @Override public <S extends KnowledgeDocument> List<S> saveAll(
                            Iterable<S> entities) {
                        throw new UnsupportedOperationException();
                    }

                    @Override public java.util.Optional<KnowledgeDocument> findById(Long id) {
                        throw new UnsupportedOperationException();
                    }

                    @Override public boolean existsById(Long id) {
                        throw new UnsupportedOperationException();
                    }

                    @Override public long count() {
                        throw new UnsupportedOperationException();
                    }

                    @Override public void deleteById(Long id) {
                        throw new UnsupportedOperationException();
                    }

                    @Override public void delete(KnowledgeDocument entity) {
                        throw new UnsupportedOperationException();
                    }

                    @Override public void deleteAllById(Iterable<? extends Long> ids) {
                        throw new UnsupportedOperationException();
                    }

                    @Override public void deleteAll(Iterable<? extends KnowledgeDocument> entities) {
                        throw new UnsupportedOperationException();
                    }

                    @Override public void deleteAll() {
                        throw new UnsupportedOperationException();
                    }

                    @Override public <S extends KnowledgeDocument> java.util.Optional<S> findOne(
                            org.springframework.data.domain.Example<S> example) {
                        throw new UnsupportedOperationException();
                    }

                    @Override public <S extends KnowledgeDocument> List<S> findAll(
                            org.springframework.data.domain.Example<S> example) {
                        throw new UnsupportedOperationException();
                    }

                    @Override public <S extends KnowledgeDocument> List<S> findAll(
                            org.springframework.data.domain.Example<S> example,
                            org.springframework.data.domain.Sort sort) {
                        throw new UnsupportedOperationException();
                    }

                    @Override public <S extends KnowledgeDocument> long count(
                            org.springframework.data.domain.Example<S> example) {
                        throw new UnsupportedOperationException();
                    }

                    @Override public <S extends KnowledgeDocument> boolean exists(
                            org.springframework.data.domain.Example<S> example) {
                        throw new UnsupportedOperationException();
                    }

                    @Override public java.util.Optional<KnowledgeDocument> findOne(
                            org.springframework.data.domain.Specification<KnowledgeDocument> spec) {
                        throw new UnsupportedOperationException();
                    }
                };

        RetrievalService service = new RetrievalService(repository);

        List<KnowledgeDocument> results =
                service.retrieve("spring backend");

        assertEquals(1, results.size());
        assertEquals("Spring Boot", results.get(0).getTitle());
    }
}
