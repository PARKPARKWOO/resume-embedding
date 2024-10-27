package com.example.resume.common.config

import org.springframework.ai.embedding.EmbeddingModel
import org.springframework.ai.openai.OpenAiEmbeddingModel
import org.springframework.ai.openai.api.OpenAiApi
import org.springframework.ai.vectorstore.RedisVectorStore
import org.springframework.ai.vectorstore.RedisVectorStore.RedisVectorStoreConfig
import org.springframework.ai.vectorstore.VectorStore
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import redis.clients.jedis.JedisPooled

@Configuration
class OpenAiConfig(
    @Value("\${spring.ai.openai.api-key}")
    val openAiKey: String,
) {
    @Bean
    fun embeddingModel(): EmbeddingModel = OpenAiEmbeddingModel(OpenAiApi(openAiKey))

    @Bean
    fun redisStack(jedisPooled: JedisPooled): VectorStore {
        val config: RedisVectorStoreConfig = RedisVectorStoreConfig.builder()
            .build()
        return RedisVectorStore(config, embeddingModel(), jedisPooled, false)
    }
}

data class ResumeDto(
    val feedback: String,
    val question: String,
)
