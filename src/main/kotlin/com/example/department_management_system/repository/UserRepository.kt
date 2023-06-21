package com.example.department_management_system.repository

import com.example.department_management_system.model.User
import org.springframework.data.jpa.repository.EntityGraph
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository : JpaRepository<User, Long?> {
    @EntityGraph(attributePaths = ["roles"])
    fun findByLogin(login: String?): User?
    fun findByBlockedIsFalse(): List<User>
}