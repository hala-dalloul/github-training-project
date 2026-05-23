package com.example.todo_list.ui.profile

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileScreen(
    userName: String = "User Name",
    email: String = "user@email.com",
    onBackClick: () -> Unit
) {
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
                    radius = 260.dp.toPx(),
                    center = Offset(size.width * 0.85f, size.height * 0.15f)
                )

                drawCircle(
                    color = beigeDark.copy(alpha = 0.4f),
                    radius = 200.dp.toPx(),
                    center = Offset(size.width * 0.1f, size.height * 0.35f)
                )

                drawCircle(
                    color = burgundy.copy(alpha = 0.1f),
                    radius = 160.dp.toPx(),
                    center = Offset(size.width * 0.2f, size.height * 0.8f)
                )
            }

            Scaffold(
                containerColor = Color.Transparent,
                topBar = {
                    TopAppBar(
                        title = { Text("Profile", color = burgundy) },
                        navigationIcon = {
                            IconButton(onClick = onBackClick) {
                                Icon(
                                    imageVector = Icons.Default.ArrowBack,
                                    contentDescription = "Back",
                                    tint = burgundy
                                )
                            }
                        }
                    )
                }
            ) { padding ->

                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(padding)
                        .padding(24.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {

                    Icon(
                        imageVector = Icons.Default.Person,
                        contentDescription = null,
                        tint = burgundy,
                        modifier = Modifier.size(90.dp)
                    )

                    Spacer(modifier = Modifier.height(20.dp))

                    Text(
                        text = userName,
                        style = MaterialTheme.typography.headlineSmall,
                        color = burgundy
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    Text(
                        text = email,
                        style = MaterialTheme.typography.bodyMedium,
                        color = Color.Gray
                    )
                }
            }
        }
    }
}