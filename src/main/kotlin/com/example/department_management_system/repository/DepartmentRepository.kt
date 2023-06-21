package com.example.department_management_system.repository

import com.example.department_management_system.model.Department
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface DepartmentRepository : JpaRepository<Department, Long>{
}