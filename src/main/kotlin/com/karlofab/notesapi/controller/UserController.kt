package com.karlofab.notesapi.controller

import com.karlofab.notesapi.repository.NotesRepository
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import java.security.Principal
import com.karlofab.notesapi.domain.Note
import org.springframework.security.core.annotation.AuthenticationPrincipal
import org.springframework.security.oauth2.core.oidc.user.OidcUser

@RestController
class UserController(val repository: NotesRepository){

    @GetMapping("/user/notes")
    fun notes(principal: Principal): List<Note> {
        println("Fetching notes for user: ${principal.name}")
        val notes = repository.findAllByUser(principal.name)
        return if(notes.isEmpty()){
            listOf()
        } else {
            notes
        }
    }

    @GetMapping("/user")
    fun user(@AuthenticationPrincipal user: OidcUser) : OidcUser {
        return user
    }
}