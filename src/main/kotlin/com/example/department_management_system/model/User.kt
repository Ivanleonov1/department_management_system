package com.example.department_management_system.model

import com.example.department_management_system.model.enums.UserRole
import jakarta.persistence.*
import lombok.Data
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.userdetails.UserDetails
import java.util.*


@Entity
data class User(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    val login: String? = null,
    val email: String? = null,
    val password: String? = null,

    @Enumerated(EnumType.STRING)
    val role: UserRole,
    var blocked: Boolean = false

)