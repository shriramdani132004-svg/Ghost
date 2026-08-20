package com.ghost.repository;

import com.ghost.entity.KnowledgeDocument;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KnowledgeDocumentRepository
        extends JpaRepository<KnowledgeDocument, Long> {
}
