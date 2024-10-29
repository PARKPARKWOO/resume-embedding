package com.example.resume.business.service

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.springframework.stereotype.Service
import org.springframework.web.multipart.MultipartFile
import java.nio.file.Files
import java.nio.file.Paths

@Service
class FileUploadService {
    companion object {
        private val UPLOAD_DIR = Paths.get("/Users/park/Desktop/project/resume/resume/uploads")
    }

    suspend fun uploadDocument(multipartFile: MultipartFile): String {
        // s3 upload
        return saveLocal(multipartFile)
    }

    suspend fun saveLocal(multipartFile: MultipartFile): String {
        if (!Files.exists(UPLOAD_DIR)) {
            withContext(Dispatchers.IO) {
                Files.createDirectories(UPLOAD_DIR)
            }
        }

        return multipartFile.originalFilename?.let {
            val filePath = UPLOAD_DIR.resolve(it)
            Files.write(filePath, multipartFile.bytes)
            filePath.toString()
        } ?: ""
    }
}
