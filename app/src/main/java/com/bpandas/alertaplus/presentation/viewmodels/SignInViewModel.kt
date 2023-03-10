package com.bpandas.alertaplus.presentation.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.bpandas.alertaplus.data.remote.AlertaPlusAPI

class SignInViewModel(private val api: AlertaPlusAPI): ViewModel() {
    var loading by mutableStateOf(false)
        private set

    var cpf by mutableStateOf("")
        private set

    var password by mutableStateOf("")
        private set

    var passwordVisible by mutableStateOf(false)
        private set

    fun updateLoading(input: Boolean) {
        loading = input
    }

    fun updateCpf(input: String) {
        cpf = input
    }

    fun updatePassword(input: String) {
        password = input
    }

    fun updatePasswordVisible(input: Boolean) {
        passwordVisible = input
    }
}
