package com.example.department_management_system.config

import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Lazy
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.dao.DaoAuthenticationProvider
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.core.AuthenticationException
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.web.SecurityFilterChain
import org.springframework.web.servlet.HandlerExceptionResolver

@Configuration
@EnableWebSecurity
class WebSecurityConfig(
    private val successUserHandler: SuccessUserHandler,
    @param:Qualifier("handlerExceptionResolver") private val handlerExceptionResolver: HandlerExceptionResolver,
    @param:Lazy private val userDetailsService: UserDetailsService
) {
    private val ADMIN = "/api/admin/**"
    private val HEAD_OF_DEPARTMENT = "/api/manager/**"
    private val COMPANY_MEMBER = "/api/customer/**"
    private val REGISTRATION = "/new/**"
    @Bean
    fun passwordEncoder(): BCryptPasswordEncoder {
        return BCryptPasswordEncoder()
    }

    @Bean
    @Throws(Exception::class)
    fun filterChain(https: HttpSecurity): SecurityFilterChain {
        https
            .authorizeRequests()
            .requestMatchers("/index", "/auth/**", "/", REGISTRATION).permitAll()
            .requestMatchers(ADMIN).hasAnyRole("ADMIN", "SUPERADMIN")
            .requestMatchers(HEAD_OF_DEPARTMENT).hasRole("HEAD OF DEPARTMENT")
            .requestMatchers(COMPANY_MEMBER).hasRole("COMPANY MEMBER")
            .anyRequest().authenticated()
            .and()
            .formLogin().successHandler(successUserHandler).permitAll()
            .and()
            .httpBasic()
            .authenticationEntryPoint { request: HttpServletRequest?, response: HttpServletResponse?, e: AuthenticationException? ->
                handlerExceptionResolver.resolveException(
                    request!!, response!!, null, e!!
                )
            }
        return https.build()
    }

    @Throws(Exception::class)
    protected fun configure(auth: AuthenticationManagerBuilder) {
        auth.userDetailsService(userDetailsService)
    }

    @Bean
    @Throws(Exception::class)
    fun authenticationManager(authConfiguration: AuthenticationConfiguration): AuthenticationManager {
        return authConfiguration.authenticationManager
    }

    @Bean
    fun authenticationProvider(): DaoAuthenticationProvider {
        val authProvider = DaoAuthenticationProvider()
        authProvider.setUserDetailsService(userDetailsService)
        authProvider.setPasswordEncoder(passwordEncoder())
        return authProvider
    }
}