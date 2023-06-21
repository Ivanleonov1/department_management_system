package com.example.department_management_system.service

import com.example.department_management_system.model.User
import com.example.department_management_system.repository.UserRepository
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service

@Service
class UserServiceImpl(private val userRepository: UserRepository): UserService {
    override fun createUser(user: User): User? {
        return userRepository.save(user)
    }

    override fun blockUser(id: Long?): User? {
        val user = userRepository.findById(id).orElseThrow {UserNotFoundException(id)}
        user.blocked = true
        return userRepository.save(user)
    }

    override fun unblockUser(id: Long): User? {
        val user = userRepository.findById(id).orElseThrow() {UserNotFoundException(id)}
    }

    override fun updateUser(id: Long, updateUser: User): Boolean {
        val user = userRepository.findByBlockedIsFalse().orElseThrow {UserNotFoundException(id)}
        user.apply {
            login = updateUser.login
            email = updateUser.email
            role = updateUser.role
        }
    }

    override fun getAllUsers(): List<User> {
        return userRepository.findByBlockedIsFalse()
    }

    override fun findByLogin(login: String?): User? {
        return userRepository.findByLogin(login)?: throw UsernameNotFoundException("User with login: $login not found")
    }

    override fun loadUserByUsername(username: String?): UserDetails {
        return loadUserByUsername(username)
    }


}