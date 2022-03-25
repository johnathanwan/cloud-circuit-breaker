package org.example

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Mono

@Suppress("SpellCheckingInspection")
@RestController
@SpringBootApplication
class BookstoreApplication {

    @RequestMapping("/recommended")
    fun readingList() =
        Mono.just("Spring in Action (Manning), Cloud Native Java (O'Reilly), Learning Spring Boot (Packt)")
}

fun main(args: Array<String>) {
    runApplication<BookstoreApplication>(*args)
}
