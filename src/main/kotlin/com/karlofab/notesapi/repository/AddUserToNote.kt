package com.karlofab.notesapi.repository

import org.springframework.data.rest.core.annotation.RepositoryEventHandler
import org.springframework.stereotype.Component
import com.karlofab.notesapi.domain.Note
import org.springframework.data.rest.core.annotation.HandleBeforeCreate
import org.springframework.security.core.context.SecurityContextHolder

@Component
@RepositoryEventHandler(Note::class)
class AddUserToNote {

    @HandleBeforeCreate
    fun handleCreate(note: Note) {
        val username: String = SecurityContextHolder.getContext().authentication.name
        println("Creating note: $note with user: $username")
        note.user = username
    }
}