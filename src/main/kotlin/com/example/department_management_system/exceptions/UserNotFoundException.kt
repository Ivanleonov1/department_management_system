package com.example.department_management_system.exceptions

class UserNotFoundException(id: Long): RuntimeException("User with id: $id not found") {
}