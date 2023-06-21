package com.example.department_management_system.service

import com.example.department_management_system.model.Department
import org.springframework.stereotype.Service


interface DepartmentService {
    fun createDepartment(department: Department): Department
    fun updateDepartment(id: Long, updateDepartment: Department): Department
    fun getAllDepartments(): List<Department>
}