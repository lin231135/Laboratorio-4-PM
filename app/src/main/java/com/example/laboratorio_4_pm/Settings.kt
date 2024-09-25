package com.example.laboratorio_4_pm

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.laboratorio_4_pm.ui.theme.Laboratorio4PMTheme

class Settings : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Laboratorio4PMTheme {
                SettingsScreen(navController = rememberNavController())
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SettingsScreen(navController: NavController) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Settings",
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth()
                    )
                },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(
                            painter = painterResource(id = R.drawable.cerrar),
                            contentDescription = "Cerrar",
                            modifier = Modifier.size(24.dp)
                        )
                    }
                }
            )
        },
        content = { innerPadding ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
                    .padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                HorizontalDivider()
                Column(
                    verticalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    SettingsItem("Edit Profile", R.drawable.profile)
                    SettingsItem("Email Addresses", R.drawable.email)
                    SettingsItem("Notifications", R.drawable.notifications)
                    SettingsItem("Privacy", R.drawable.privacy)
                    HorizontalDivider()
                    SettingsItemWithSubtitle(
                        "Help & Feedback",
                        "Troubleshooting tips and guides",
                        R.drawable.about
                    )
                    SettingsItemWithSubtitle(
                        "About",
                        "App information and documents",
                        R.drawable.info
                    )
                    HorizontalDivider()
                    Spacer(modifier = Modifier.height(16.dp))
                    Text(
                        text = "Logout",
                        fontSize = 18.sp,
                        color = Color.Red,
                        modifier = Modifier.fillMaxWidth(),
                        textAlign = TextAlign.Center
                    )
                }
            }
        }
    )
}

@Composable
fun SettingsItem(title: String, iconRes: Int) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            painter = painterResource(id = iconRes),
            contentDescription = title,
            modifier = Modifier.size(24.dp)
        )
        Spacer(modifier = Modifier.width(16.dp))
        Text(text = title, fontSize = 18.sp)
    }
}

@Composable
fun SettingsItemWithSubtitle(title: String, subtitle: String, iconRes: Int) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            painter = painterResource(id = iconRes),
            contentDescription = title,
            modifier = Modifier.size(24.dp)
        )
        Spacer(modifier = Modifier.width(16.dp))
        Column {
            Text(text = title, fontSize = 18.sp)
            Text(text = subtitle, fontSize = 14.sp, color = Color.Gray)
        }
    }
}