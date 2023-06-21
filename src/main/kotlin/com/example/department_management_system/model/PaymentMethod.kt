package com.example.department_management_system.model

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne

@Entity
data class PaymentMethod(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val details: String,
    @ManyToOne
    @JoinColumn(name = "employee_id")
    val employee: Employee,
    @ManyToOne
    @JoinColumn(name = "payment_type_id")
    val paymentType: PaymentType
)
