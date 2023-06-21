package com.example.department_management_system.config

import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.security.core.Authentication
import org.springframework.security.core.authority.AuthorityUtils
import org.springframework.security.web.authentication.AuthenticationSuccessHandler
import org.springframework.stereotype.Component
import java.io.IOException

@Component
class SuccessUserHandler : AuthenticationSuccessHandler {
    @Throws(IOException::class)
    override fun onAuthenticationSuccess(
        httpServletRequest: HttpServletRequest,
        httpServletResponse: HttpServletResponse,
        authentication: Authentication
    ) {
        val authorities = AuthorityUtils.authorityListToSet(authentication.authorities)
        if (authorities.contains("ROLE_ADMIN")) {
            httpServletResponse.sendRedirect("/admin")
        } else if (authorities.contains("ROLE_HEAD_OF_DEPARTMENT")) {
            httpServletResponse.sendRedirect("/head_of_department")
        } else if(authorities.contains("COMPANY_MEMBER")){
            httpServletResponse.sendRedirect("/employee")
        } else {
            httpServletResponse.sendRedirect("/")
        }
    }
}