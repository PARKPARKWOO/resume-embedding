package com.example.resume.business.service

import org.springframework.ai.document.Document
import org.springframework.ai.reader.pdf.PagePdfDocumentReader
import org.springframework.ai.transformer.splitter.TokenTextSplitter
import org.springframework.core.io.PathResource
import org.springframework.core.io.Resource
import org.springframework.stereotype.Service

@Service
class DataLoaderService {
    suspend fun load(path: String): List<Document> {
        val localResource = getLocalResource(path)
        val pagePdfDocumentReader = PagePdfDocumentReader(localResource)

        // s3 변경 시 사용
//        val pagePdfDocumentReader = PagePdfDocumentReader(path)
        val tokenTextSplitter = TokenTextSplitter()
        return tokenTextSplitter.apply(pagePdfDocumentReader.get())
    }

    suspend fun getLocalResource(path: String): Resource = PathResource(path)
}
