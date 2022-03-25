package org.example

import org.springframework.boot.*
import org.springframework.boot.autoconfigure.*
import org.springframework.web.bind.annotation.*

@RestController
@SpringBootApplication
class ReadingApplication(val bookService: BookService) {

    @RequestMapping("/to-read")
    fun toRead() = bookService.readingList()
}

fun main(args: Array<String>) {
    runApplication<ReadingApplication>(*args)
}