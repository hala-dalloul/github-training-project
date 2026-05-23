package com.example.todo_list.ui.auth

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

@Composable
fun LoginScreen(
    onLoginSuccess: () -> Unit
) {
    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    val snackbarHostState = remember { SnackbarHostState() }
    val scope = rememberCoroutineScope()

    val burgundy = Color(0xFF800020)
    val beigeLight = Color(0xFFF5F5DC)
    val beigeDark = Color(0xFFE1C699)
    val beigeBackground = Color(0xFFFAFAF5)

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = beigeBackground
    ) {
        Box(modifier = Modifier.fillMaxSize()) {

            Canvas(modifier = Modifier.fillMaxSize()) {
                drawCircle(
                    color = burgundy.copy(alpha = 0.15f),
                    radius = 250.dp.toPx(),
                    center = Offset(x = size.width * 0.9f, y = size.height * 0.1f)
                )

                drawCircle(
                    color = beigeDark.copy(alpha = 0.4f),
                    radius = 180.dp.toPx(),
                    center = Offset(x = size.width * 0.05f, y = size.height * 0.4f)
                )

                drawCircle(
                    color = burgundy.copy(alpha = 0.12f),
                    radius = 150.dp.toPx(),
                    center = Offset(x = size.width * 0.1f, y = size.height * 0.85f)
                )

                drawCircle(
                    color = beigeLight.copy(alpha = 0.6f),
                    radius = 100.dp.toPx(),
                    center = Offset(x = size.width * 0.85f, y = size.height * 0.75f)
                )
            }

            Scaffold(
                containerColor = Color.Transparent,
                snackbarHost = { SnackbarHost(hostState = snackbarHostState) }
            ) { paddingValues ->
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(paddingValues)
                        .padding(horizontal = 24.dp),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    Text(
                        text = "Login",
                        style = MaterialTheme.typography.headlineMedium,
                        color = burgundy
                    )

                    Spacer(modifier = Modifier.height(32.dp))

                    OutlinedTextField(
                        value = username,
                        onValueChange = { username = it },
                        modifier = Modifier.fillMaxWidth(),
                        label = { Text(text = "Username") },
                        singleLine = true
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    OutlinedTextField(
                        value = password,
                        onValueChange = { password = it },
                        modifier = Modifier.fillMaxWidth(),
                        label = { Text(text = "Password") },
                        singleLine = true,
                        visualTransformation = PasswordVisualTransformation()
                    )

                    Spacer(modifier = Modifier.height(24.dp))

                    Button(
                        onClick = {
                            if (username == "admin" && password == "admin") {
                                onLoginSuccess()
                            } else {
                                scope.launch {
                                    snackbarHostState.showSnackbar("Invalid username or password")
                                }
                            }
                        },
                        modifier = Modifier.fillMaxWidth(),
                        colors = ButtonDefaults.buttonColors(containerColor = burgundy)
                    ) {
                        Text(text = "Login")
                    }

                    Spacer(modifier = Modifier.height(8.dp))

                    TextButton(
                        onClick = {  }
                    ) {
                        Text(
                            text = "Forgot Password?",
                            color = burgundy.copy(alpha = 0.8f)
                        )
                    }
                }
            }
        }
    }
}