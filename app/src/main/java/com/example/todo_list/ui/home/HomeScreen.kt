package com.example.todo_list.ui.home

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.todo_list.data.model.Task

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    tasks: List<Task>,
    onAddTaskClick: () -> Unit,
    onProfileClick: () -> Unit
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

            // الخلفية (فقاعات)
            Canvas(modifier = Modifier.fillMaxSize()) {
                drawCircle(
                    color = burgundy.copy(alpha = 0.15f),
                    radius = 250.dp.toPx(),
                    center = Offset(size.width * 0.9f, size.height * 0.1f)
                )

                drawCircle(
                    color = beigeDark.copy(alpha = 0.4f),
                    radius = 180.dp.toPx(),
                    center = Offset(size.width * 0.05f, size.height * 0.4f)
                )

                drawCircle(
                    color = burgundy.copy(alpha = 0.12f),
                    radius = 150.dp.toPx(),
                    center = Offset(size.width * 0.1f, size.height * 0.85f)
                )

                drawCircle(
                    color = beigeLight.copy(alpha = 0.6f),
                    radius = 120.dp.toPx(),
                    center = Offset(size.width * 0.85f, size.height * 0.75f)
                )
            }

            Scaffold(
                containerColor = Color.Transparent,
                topBar = {
                    TopAppBar(
                        title = { Text("Home", color = burgundy) },
                        actions = {
                            IconButton(onClick = onProfileClick) {
                                Icon(
                                    imageVector = Icons.Default.Person,
                                    contentDescription = "Profile",
                                    tint = burgundy
                                )
                            }
                        }
                    )
                },
                floatingActionButton = {
                    FloatingActionButton(
                        onClick = onAddTaskClick,
                        containerColor = burgundy,
                        contentColor = Color.White
                    ) {
                        Icon(Icons.Default.Add, contentDescription = "Add Task")
                    }
                }
            ) { padding ->

                LazyColumn(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(padding)
                        .padding(horizontal = 16.dp),
                    verticalArrangement = Arrangement.spacedBy(12.dp)
                ) {

                    item { Spacer(modifier = Modifier.height(8.dp)) }

                    items(tasks) { task ->
                        Card(
                            modifier = Modifier.fillMaxWidth(),
                            colors = CardDefaults.cardColors(
                                containerColor = Color.White.copy(alpha = 0.9f)
                            ),
                            elevation = CardDefaults.cardElevation(4.dp)
                        ) {
                            Column(
                                modifier = Modifier.padding(16.dp)
                            ) {
                                Text(
                                    text = task.title,
                                    style = MaterialTheme.typography.titleMedium,
                                    color = burgundy
                                )

                                Spacer(modifier = Modifier.height(6.dp))

                                Text(
                                    text = task.description,
                                    style = MaterialTheme.typography.bodyMedium,
                                    color = Color.Gray
                                )
                            }
                        }
                    }

                    item { Spacer(modifier = Modifier.height(80.dp)) }
                }
            }
        }
    }
}