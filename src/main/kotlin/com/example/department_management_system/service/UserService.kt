package com.example.department_management_system.service

import com.example.department_management_system.model.User
import org.springframework.security.core.userdetails.UserDetailsService

interface UserService : UserDetailsService {
    fun createUser(user: User): User?
    fun blockUser(id: Long?): User?
    fun unblockUser(id: Long): User?
    fun updateUser(id: Long, updateUser: User): Boolean
    fun getAllUsers(): List<User>
    fun findByLogin(login: String?): User?
}