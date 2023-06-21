package com.example.department_management_system.controller

import com.example.department_management_system.exceptions.DepartmentNotFoundException
import com.example.department_management_system.exceptions.UserNotFoundException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class ExceptionHandlerAdvice {
    @ExceptionHandler(UserNotFoundException::class)
    fun handleUserNotFoundException(ex: UserNotFoundException): String {
        return ex.message ?: "User not found"
    }
    @ExceptionHandler(DepartmentNotFoundException::class)
    fun handleDepartmentNotFoundException(ex: DepartmentNotFoundException): String {
        return ex.message ?: "Department not found"
    }
}