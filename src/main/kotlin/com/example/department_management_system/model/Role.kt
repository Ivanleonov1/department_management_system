package com.example.department_management_system.model

import jakarta.persistence.*
import lombok.Data
import org.springframework.security.core.GrantedAuthority
import java.util.*

@Entity
@Table(name = "roles")
class Role : GrantedAuthority {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private val id: Long? = null

    @Column
    private var authority: String? = null

    constructor() {}
    constructor(authority: String?) {
        this.authority = authority
    }

    override fun equals(o: Any?): Boolean {
        if (this === o) return true
        if (o == null || javaClass != o.javaClass) return false
        val role = o as Role
        return id == role.id
    }

    override fun hashCode(): Int {
        return Objects.hash(id)
    }

    override fun getAuthority(): String {
        return authority.orEmpty()
    }
}