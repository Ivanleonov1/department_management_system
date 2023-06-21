package com.example.department_management_system.service

import com.example.department_management_system.model.Employee
import com.example.department_management_system.repository.EmployeeRepository
import org.springframework.stereotype.Service

@Service
class EmployeeServiceImpl(private val employeeRepository: EmployeeRepository): EmployeeService {
    override fun getListOfDepartments(): List<Employee> {
        return employeeRepository.findAll()
    }

    override fun getListOfEmployee(): List<Employee> {
        return employeeRepository.findAll()
    }
}