package com.example.department_management_system.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface PaymentTypeRepository : JpaRepository<PaymentTypeRepository, Long>{
}