package com.example.department_management_system.model

import jakarta.persistence.CascadeType
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.JoinTable
import jakarta.persistence.ManyToMany
import jakarta.persistence.OneToMany

@Entity
data class Employee(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val fullName: String,
    @ManyToMany
    @JoinTable(name = "employee_department",
    joinColumns = [JoinColumn(name = "employee_id")],
    inverseJoinColumns = [JoinColumn(name = "department_id")]
    )
    val departments: Set<Department>,
    val salary: Int,
    @OneToMany(mappedBy = "employee", cascade = [CascadeType.ALL], orphanRemoval = true)
    val paymentMethods: Set<PaymentMethod>
)
