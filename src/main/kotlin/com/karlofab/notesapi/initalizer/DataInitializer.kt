package com.karlofab.notesapi.initalizer

import com.karlofab.notesapi.repository.NotesRepository
import org.springframework.boot.ApplicationArguments
import com.karlofab.notesapi.domain.Note
import org.springframework.boot.ApplicationRunner

class DataInitializer(private val repository: NotesRepository) : ApplicationRunner {

    @Throws(Exception::class)
    override fun run(args: ApplicationArguments) {
        listOf("Note 1", "Note 2", "Note 3").forEach {
            repository.save(Note(title = it, user = "user"))
        }
        repository.findAll().forEach { println(it) }
    }
}