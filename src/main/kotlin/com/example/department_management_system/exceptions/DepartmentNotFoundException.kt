package com.example.department_management_system.exceptions

class DepartmentNotFoundException(id: Long): RuntimeException("Department with id: $id not found") {
}