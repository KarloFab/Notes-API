package com.karlofab.notesapi.repository

import com.karlofab.notesapi.domain.Note
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.rest.core.annotation.RepositoryRestResource

@RepositoryRestResource
interface NotesRepository : JpaRepository<Note, Long> {
     fun findAllByUser(name: String?): List<Note>
}