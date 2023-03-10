package com.bpandas.alertaplus.presentation.activities

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material3.*
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.bpandas.alertaplus.presentation.activities.ui.theme.AlertaTheme
import com.bpandas.alertaplus.presentation.viewmodels.SignInViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class SignInActivity : ComponentActivity() {

    @Inject lateinit var signInViewModel: SignInViewModel

    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AlertaTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Column(
                        Modifier.background(
                            brush = Brush.linearGradient(
                                colors = listOf(
                                    MaterialTheme.colorScheme.primary,
                                    MaterialTheme.colorScheme.tertiary
                                )
                            )
                        ),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        Column(
                            Modifier
                                .background(color = MaterialTheme.colorScheme.background)
                                .width(340.dp)
                                .height(420.dp)
                                .padding(20.dp),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Text(text = "Entrar", style = MaterialTheme.typography.titleLarge)

                            Spacer(modifier = Modifier.height(26.dp))

                            OutlinedTextField(
                                value = signInViewModel.cpf,
                                onValueChange = { input ->
                                    signInViewModel.updateCpf(input)
                                },
                                leadingIcon = {
                                    Icon(
                                        imageVector = Icons.Outlined.Person,
                                        contentDescription = "person"
                                    )
                                },
                                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                                label = { Text("CPF") },
                                placeholder = { Text("Informe um CPF válido") }
                            )

                            OutlinedTextField(
                                value = signInViewModel.password,
                                onValueChange = { input ->
                                    signInViewModel.updatePassword(input)
                                },
                                visualTransformation =
                                    if (signInViewModel.passwordVisible) VisualTransformation.None
                                    else PasswordVisualTransformation(),
                                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                                label = { Text("Senha") },
                                placeholder = { Text("Senha cadastrada") },
                                leadingIcon = {
                                    Icon(
                                        imageVector = Icons.Outlined.Lock,
                                        contentDescription = "person"
                                    )
                                },
                                trailingIcon = {
                                    val image = if (signInViewModel.passwordVisible)
                                        Icons.Filled.Visibility
                                    else Icons.Filled.VisibilityOff

                                    // Please provide localized description for accessibility services
                                    val description =
                                        if (signInViewModel.passwordVisible) "Hide password"
                                        else "Show password"

                                    IconButton(onClick = {
                                        signInViewModel
                                            .updatePasswordVisible(!signInViewModel.passwordVisible)
                                    }) {
                                        Icon(imageVector = image, description)
                                    }
                                }
                            )

                            Button(
                                onClick = { /*TODO*/ },
                                modifier = Modifier.width(280.dp),
                                shape = RectangleShape,
                            ) {
                                Text("Entrar")
                            }

                            Spacer(modifier = Modifier.height(26.dp))

                            Text("Você não possui uma conta?")
                            TextButton(onClick = { /*TODO*/ }) {
                                Text("Cadastre-se")
                            }
                        }
                    }
                }
            }
        }
    }
}
