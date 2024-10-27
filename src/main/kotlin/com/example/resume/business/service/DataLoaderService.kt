package com.example.resume.business.service

import org.springframework.ai.document.Document
import org.springframework.ai.reader.pdf.PagePdfDocumentReader
import org.springframework.ai.transformer.splitter.TokenTextSplitter
import org.springframework.stereotype.Service

@Service
class DataLoaderService {
    suspend fun load(path: String): List<Document> {
        val pagePdfDocumentReader = PagePdfDocumentReader(path)
        val tokenTextSplitter = TokenTextSplitter()
        return tokenTextSplitter.apply(pagePdfDocumentReader.get())
    }
}
