package com.example.resume.business.service

import org.springframework.ai.document.Document
import org.springframework.ai.vectorstore.VectorStore
import org.springframework.stereotype.Service

@Service
class RetrieveService(
    private val vectorStore: VectorStore,
) {
    suspend fun retrieve(query: String): List<Document> {
        return vectorStore.similaritySearch(query)
    }

    suspend fun register(documents: List<Document>) {
        vectorStore.add(documents)
    }
}
