package com.example.resume.presentation

import com.example.resume.business.facade.ResumeFacade
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.multipart.MultipartFile

@RestController
@RequestMapping("/api/v1/registration")
class RegistrationController(
    private val resumeFacade: ResumeFacade,
) {
    @PostMapping(path = ["/resume"], consumes = ["multipart/form-data"])
    suspend fun registerResume(
        @RequestParam("resume")
        resume: MultipartFile,
    ) {
        if (!resume.contentType.equals("application/pdf")) {
            println("invalid file format only pdf")
        }
        resumeFacade.upload(resume)
    }
}
