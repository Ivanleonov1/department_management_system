package com.example.department_management_system.controller

import com.example.department_management_system.model.User
import com.example.department_management_system.service.UserService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.servlet.ModelAndView

@RestController
@RequestMapping("api/admin")
class AdminRestController(private val userService: UserService) {
   @PostMapping
   fun createUser(@RequestBody user: User): User? {
       return userService.createUser(user)
   }
    @PutMapping("/id")
    fun updateUser(@PathVariable id: Long, @RequestBody updateUser: User): User? {
        return userService.updateUser(id, updateUser)
    }
    @PutMapping("/{id}/block")
    fun blockUser(@PathVariable id: Long): User? {
        userService.blockUser(id)
    }
    @PutMapping("/{id}unblock")
    fun unblockUser(@PathVariable id: Long): User? {
        return userService.unblockUser(id)
    }
    @GetMapping
    fun getAllUsers(): List<User> {
        return userService.getAllUsers()
    }

}