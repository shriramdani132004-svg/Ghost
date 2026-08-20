# Ghost

A work-in-progress AI knowledge retrieval backend built with Spring Boot and PostgreSQL.

## Current Features

- Knowledge document storage
- PostgreSQL persistence
- REST APIs
- Keyword-based context retrieval
- Relevance scoring for retrieved documents
- Request validation
- Retrieval service tests

## REST API

| Method | Endpoint | Description |
|---|---|---|
| GET | /api/knowledge | Get all knowledge documents |
| POST | /api/knowledge | Add a knowledge document |
| GET | /api/knowledge/search?query= | Retrieve relevant documents |

## Architecture

Client -> REST Controller -> Retrieval Service -> Repository -> PostgreSQL

## Retrieval Flow

1. Receive a search query.
2. Split the query into keywords.
3. Compare keywords against document titles and content.
4. Give title matches a higher relevance score.
5. Give content matches a lower relevance score.
6. Sort matching documents by relevance.
7. Return the most relevant documents.

## Example

A query such as spring backend can retrieve a knowledge document containing Spring Boot and Java backend information.

## Tech Stack

- Java
- Spring Boot
- Spring Data JPA
- Hibernate
- PostgreSQL
- Maven
- JUnit
- Mockito

## Status

Work in Progress

The current implementation focuses on the knowledge storage and retrieval foundation. Semantic/vector retrieval and LLM integration are planned future improvements.

## Planned

- Embedding generation
- pgvector semantic search
- LLM integration
- Context-aware response generation
- React interface
