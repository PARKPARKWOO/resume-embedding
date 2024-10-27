package com.example.resume.business.service

import org.springframework.ai.document.Document
import org.springframework.stereotype.Service
import org.springframework.web.multipart.MultipartFile

@Service
class FileUploadService {
    suspend fun uploadDocument(multipartFile: MultipartFile): String {
        // s3 upload
        return "cdn path"
    }
}
