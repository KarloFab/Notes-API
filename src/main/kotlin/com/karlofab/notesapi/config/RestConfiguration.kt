package com.karlofab.notesapi.config

import org.springframework.context.annotation.Configuration
import org.springframework.data.rest.core.config.RepositoryRestConfiguration
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer
import com.karlofab.notesapi.domain.Note

@Configuration
class RestConfiguration : RepositoryRestConfigurer {
    override fun configureRepositoryRestConfiguration(config: RepositoryRestConfiguration?) {
        config?.exposeIdsFor(Note::class.java)
        config?.setBasePath("/api")
    }
}