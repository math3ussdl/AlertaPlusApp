package com.bpandas.alertaplus.domain.models

import java.util.Date
import java.util.UUID

data class User(
    val id: UUID,
    val name: String,
    val cpf: String,
    val email: String,
    val phone: String,
    val createdAt: Date,
    val updatedAt: Date
)
