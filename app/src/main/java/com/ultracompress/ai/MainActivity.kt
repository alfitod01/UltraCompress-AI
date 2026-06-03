package com.ultracompress.ai

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            UltraCompressAIApp()
        }
    }
}

@Composable
fun UltraCompressAIApp() {
    var currentScreen by remember { mutableStateOf("video") }

    Scaffold(
        bottomBar = {
            NavigationBar(containerColor = Color(0xFF1E1E24)) {
                val items = listOf("video" to "Video", "photo" to "Photo AI", "history" to "History", "settings" to "Settings")
                items.forEach { (route, label) ->
                    NavigationBarItem(
                        selected = currentScreen == route,
                        onClick = { currentScreen = route },
                        label = { Text(label, color = if (currentScreen == route) Color(0xFF007AFF) else Color(0xFF8E8E93)) },
                        icon = { },
                        colors = NavigationBarItemDefaults.colors(indicatorColor = Color(0xFF1E1E24))
                    )
                }
            }
        },
        containerColor = Color(0xFF0F0F13)
    ) { innerPadding ->
        Box(modifier = Modifier.padding(innerPadding).fillMaxSize()) {
            when (currentScreen) {
                "video" -> VideoCompressorScreen()
                "photo" -> PhotoUpscalerScreen()
                "history" -> HistoryScreen()
                "settings" -> SettingsScreen()
            }
        }
    }
}

@Composable
fun VideoCompressorScreen() {
    Column(modifier = Modifier.fillMaxSize().padding(16.dp), horizontalAlignment = Alignment.CenterHorizontally) {
        Text("UltraCompress AI", fontSize = 24.sp, fontWeight = FontWeight.Bold, color = Color(0xFF007AFF))
        Spacer(modifier = Modifier.height(30.dp))
        Button(
            onClick = { },
            modifier = Modifier.fillMaxWidth().height(150.dp),
            shape = RoundedCornerShape(12.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF1E1E24))
        ) {
            Text("+ Import Video", color = Color.White, fontSize = 18.sp)
        }
        Spacer(modifier = Modifier.height(20.dp))
        Text("Preset Kualitas (H.264)", color = Color.White, modifier = Modifier.align(Alignment.Start))
        listOf("720p (Auto)", "720p 60fps", "1080p 60fps").forEach { preset ->
            Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
                RadioButton(selected = preset == "720p (Auto)", onClick = { }, colors = RadioButtonDefaults.colors(selectedColor = Color(0xFF007AFF)))
                Text(preset, color = Color.White)
            }
        }
        Spacer(modifier = Modifier.weight(1f))
        Button(
            onClick = { },
            modifier = Modifier.fillMaxWidth().height(50.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF007AFF))
        ) {
            Text("COMPRESS & SAVE", color = Color.Black, fontWeight = FontWeight.Bold)
        }
    }
}

@Composable
fun PhotoUpscalerScreen() {
    Column(modifier = Modifier.fillMaxSize().padding(16.dp), horizontalAlignment = Alignment.CenterHorizontally) {
        Text("Photo AI Upscaler", fontSize = 24.sp, fontWeight = FontWeight.Bold, color = Color.White)
        Spacer(modifier = Modifier.height(30.dp))
        Button(
            onClick = { },
            modifier = Modifier.fillMaxWidth().height(200.dp),
            shape = RoundedCornerShape(12.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF1E1E24))
        ) {
            Text("+ Import Photo", color = Color.White, fontSize = 18.sp)
        }
        Spacer(modifier = Modifier.weight(1f))
        Button(
            onClick = { },
            modifier = Modifier.fillMaxWidth().height(50.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF007AFF))
        ) {
            Text("ENHANCE & SAVE", color = Color.Black, fontWeight = FontWeight.Bold)
        }
    }
}

@Composable
fun HistoryScreen() {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text("Belum ada riwayat kompresi", color = Color(0xFF8E8E93))
    }
}

@Composable
fun SettingsScreen() {
    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Text("Settings", fontSize = 24.sp, fontWeight = FontWeight.Bold, color = Color.White)
        Spacer(modifier = Modifier.height(20.dp))
        Row(modifier = Modifier.fillMaxWidth().padding(vertical = 12.dp), horizontalArrangement = Arrangement.SpaceBetween) {
            Text("Dark Mode (CapCut Theme)", color = Color.White)
            Switch(checked = true, onCheckedChange = {})
        }
    }
}
