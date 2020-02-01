package com.karlofab.notesapi.domain

import com.fasterxml.jackson.annotation.JsonIgnore
import org.springframework.data.annotation.Id
import javax.persistence.Entity
import javax.persistence.GeneratedValue

@Entity
class Note(@Id @GeneratedValue var id: Long? = null,
           var title: String? = null,
           var text: String? = null,
           @JsonIgnore var user: String? = null)