package com.bpandas.alertaplus.data.remote.response

import com.bpandas.alertaplus.domain.models.User

data class SessionResponse(
    val user: User,
    val accessToken: String
)
