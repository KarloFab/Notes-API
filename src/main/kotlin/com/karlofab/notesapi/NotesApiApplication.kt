package com.karlofab.notesapi

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.boot.web.servlet.FilterRegistrationBean
import org.springframework.context.annotation.Bean
import org.springframework.core.Ordered
import org.springframework.web.cors.CorsConfiguration
import org.springframework.web.cors.UrlBasedCorsConfigurationSource
import org.springframework.web.filter.CorsFilter

@SpringBootApplication
class NotesApiApplication

fun main(args: Array<String>) {
	runApplication<NotesApiApplication>(*args)
}

@Bean
fun simpleCorsFilter(): FilterRegistrationBean<CorsFilter> {
	val source = UrlBasedCorsConfigurationSource()
	val config = CorsConfiguration()
	config.allowCredentials = true
	config.allowedOrigins = listOf("https://localhost:4200")
	config.allowedHeaders = listOf("*")
	config.allowedMethods = listOf("*")
	source.registerCorsConfiguration("/**", config)
	val bean = FilterRegistrationBean(CorsFilter(source))
	bean.order = Ordered.HIGHEST_PRECEDENCE
	return bean
}