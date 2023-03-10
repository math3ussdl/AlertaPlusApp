package com.bpandas.alertaplus.data.remote

import com.bpandas.alertaplus.data.remote.request.SessionRequest
import com.bpandas.alertaplus.data.remote.response.SessionResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface AlertaPlusAPI {

    @POST("/sessions/login")
    fun authenticate(@Body req: SessionRequest) : Call<SessionResponse>

    companion object {
        val BASE_URL = "https://localhost:7088/api/v1"
    }
}
