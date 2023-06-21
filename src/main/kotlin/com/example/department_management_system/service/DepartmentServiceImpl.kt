package com.example.department_management_system.service

import com.example.department_management_system.model.Department
import com.example.department_management_system.repository.DepartmentRepository
import org.springframework.stereotype.Service

@Service
class DepartmentServiceImpl(private val departmentRepository: DepartmentRepository): DepartmentService {
    override fun createDepartment(department: Department): Department {
        return departmentRepository.save(department)
    }

    override fun updateDepartment(id: Long, updateDepartment: Department): Department {
        val department = departmentRepository.findById(id).orElseThrow() {DepartmentNotFoundException(id)}
        department.apply {
            name = updateDepartment.name
            cod = updateDepartment.cod
            headOfDepartment = updateDepartment.headOfDepartment
        }
        return departmentRepository.save(department)
    }

    override fun getAllDepartments(): List<Department> {
       return departmentRepository.findAll()
    }
}