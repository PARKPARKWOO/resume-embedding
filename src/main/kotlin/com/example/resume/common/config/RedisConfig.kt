package com.example.resume.common.config

import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import redis.clients.jedis.JedisPool
import redis.clients.jedis.JedisPooled

@Configuration
class RedisConfig(
) {
    @Bean
    fun jedisPooled(): JedisPooled {
        return JedisPooled("localhost", 8001)
    }
}