package com.example.resume.common.config

import org.springframework.ai.embedding.EmbeddingModel
import org.springframework.ai.openai.OpenAiEmbeddingModel
import org.springframework.ai.openai.api.OpenAiApi
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class OpenAiConfig(
    @Value("\${spring.ai.openai.api-key}")
    val openAiKey: String,
) {
    @Bean
    fun model(): EmbeddingModel = OpenAiEmbeddingModel(OpenAiApi(openAiKey))

//    @Bean
//    fun redisStack(): VectorStore {
//        val config = RedisVectorStoreConfig.builder()
//            .wit
//    }
}
