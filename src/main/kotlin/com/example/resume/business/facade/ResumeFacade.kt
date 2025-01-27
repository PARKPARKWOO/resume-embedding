package com.example.resume.business.facade

import com.example.resume.business.service.DataLoaderService
import com.example.resume.business.service.FileUploadService
import com.example.resume.business.service.VectorStoreDriver
import org.springframework.stereotype.Service
import org.springframework.web.multipart.MultipartFile

@Service
class ResumeFacade(
    private val vectorStoreDriver: VectorStoreDriver,
    private val fileUploadService: FileUploadService,
    private val dataLoaderService: DataLoaderService,
) {
    suspend fun upload(multipartFile: MultipartFile) {
        // file upload
        val cdnPath = fileUploadService.uploadDocument(multipartFile)
        // data load
        val documents = dataLoaderService.load(cdnPath)
        // add database
        vectorStoreDriver.register(documents)
    }
}
