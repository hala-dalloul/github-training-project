package com.example.todo_list.ui.addTask

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddTaskScreen(
    onSaveClick: (String, String) -> Unit,
    onBackClick: () -> Unit
) {
    val burgundy = Color(0xFF800020)
    val beigeLight = Color(0xFFF5F5DC)
    val beigeDark = Color(0xFFE1C699)
    val beigeBackground = Color(0xFFFAFAF5)

    var title by remember { mutableStateOf("") }
    var description by remember { mutableStateOf("") }

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = beigeBackground
    ) {
        Box(modifier = Modifier.fillMaxSize()) {

            // الخلفية (فقاعات)
            Canvas(modifier = Modifier.fillMaxSize()) {
                drawCircle(burgundy.copy(alpha = 0.15f), 240.dp.toPx(),
                    Offset(size.width * 0.8f, size.height * 0.2f))

                drawCircle(beigeDark.copy(alpha = 0.35f), 200.dp.toPx(),
                    Offset(size.width * 0.15f, size.height * 0.5f))

                drawCircle(beigeLight.copy(alpha = 0.5f), 150.dp.toPx(),
                    Offset(size.width * 0.7f, size.height * 0.8f))
            }

            Scaffold(
                containerColor = Color.Transparent,
                topBar = {
                    TopAppBar(
                        title = { Text("Add Task", color = burgundy) },
                        navigationIcon = {
                            IconButton(onClick = onBackClick) {
                                Icon(
                                    imageVector = Icons.Default.Add,
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
                        .padding(20.dp),
                    verticalArrangement = Arrangement.Center
                ) {

                    OutlinedTextField(
                        value = title,
                        onValueChange = { title = it },
                        label = { Text("Task Title") },
                        modifier = Modifier.fillMaxWidth()
                    )

                    Spacer(modifier = Modifier.height(12.dp))

                    OutlinedTextField(
                        value = description,
                        onValueChange = { description = it },
                        label = { Text("Task Description") },
                        modifier = Modifier.fillMaxWidth()
                    )

                    Spacer(modifier = Modifier.height(20.dp))

                    Button(
                        onClick = {
                            if (title.isNotBlank()) {
                                onSaveClick(title, description)
                            }
                        },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = burgundy
                        ),
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Icon(Icons.Default.Add, contentDescription = null)
                        Spacer(modifier = Modifier.width(8.dp))
                        Text("Save Task")
                    }
                }
            }
        }
    }
}