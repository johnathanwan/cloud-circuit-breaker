package org.example

import mu.*
import org.springframework.cloud.client.circuitbreaker.ReactiveCircuitBreakerFactory
import org.springframework.stereotype.Service
import org.springframework.web.reactive.function.client.WebClient
import reactor.core.publisher.*

@Service
class BookService(circuitBreakerFactory: ReactiveCircuitBreakerFactory<*, *>) {

    companion object {
        val logger = KotlinLogging.logger {}
    }

    private val webClient = WebClient.builder().baseUrl("http://localhost:8090").build()
    private val readListCircuitBreaker = circuitBreakerFactory.create("recommended")

    fun readingList(): Mono<String> =
        readListCircuitBreaker.run(
            webClient.get().uri("/recommended").retrieve().bodyToMono(String::class.java)
        ) {
            logger.warn (it) { "Error making request to book service" }
            Mono.just("Cloud Native Java (O'Reilly)")
        }
}