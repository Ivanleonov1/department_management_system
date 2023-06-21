package com.example.department_management_system.service

import com.example.department_management_system.model.Department
import com.example.department_management_system.model.Employee

interface EmployeeService {
    fun getListOfDepartments(): List<Employee>
    fun getListOfEmployee(): List<Employee>
}