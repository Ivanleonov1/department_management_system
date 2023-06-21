package com.example.department_management_system.controller

import com.example.department_management_system.model.Department
import com.example.department_management_system.service.DepartmentService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/department")
class DepartmentController (private val departmentService: DepartmentService){
    @PostMapping
    fun createDepartment(@RequestBody department: Department): Department {
        return departmentService.createDepartment(department)
    }
    @PutMapping("/id")
    fun updateDepartment(@PathVariable id: Long, @RequestBody updateDepartment: Department): Department {
        return departmentService.updateDepartment(id, updateDepartment)
    }
    @GetMapping
    fun getAllDepartment(): List<Department> {
        return departmentService.getAllDepartments()
    }
}