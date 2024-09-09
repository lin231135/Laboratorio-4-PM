package com.example.laboratorio_4_pm

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.laboratorio_4_pm.ui.theme.Laboratorio4PMTheme

class User : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Laboratorio4PMTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    topBar = {
                        TopAppBar(
                            title = {
                                Text(
                                    text = "My Profile",
                                    textAlign = TextAlign.Center,
                                    modifier = Modifier.fillMaxWidth() // Centra el texto
                                )
                            },
                            actions = {
                                IconButton(onClick = { /* Acción de configuración */ }) {
                                    Icon(
                                        painter = painterResource(id = R.drawable.settings),
                                        contentDescription = "Settings",
                                        tint = Color(0xFF32733C)
                                    )
                                }
                            }
                        )
                    }
                ) { innerPadding ->
                    ProfileScreen(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun ProfileScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        ProfileHeader()
        Spacer(modifier = Modifier.height(16.dp))
        ProfileOptions()
    }
}

@Composable
fun ProfileHeader() {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxWidth()
            .height(150.dp)
    ) {
        // Imagen de fondo detrás del ícono de perfil
        Image(
            painter = painterResource(R.drawable.background2), // Imagen de fondo
            contentDescription = "Background Image",
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            // Imagen circular del usuario
            Image(
                painter = painterResource(R.drawable.user),
                contentDescription = "Profile Image",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(100.dp)
                    .clip(CircleShape)
            )
            Spacer(modifier = Modifier.height(8.dp))

            // Nombre de usuario
            Text(
                text = "NOMBRE DE USUARIO",
                fontSize = 18.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}

@Composable
fun ProfileOptions() {
    // Lista de opciones con su título, subtítulo, ícono y color hexadecimal correspondiente
    val options = listOf(
        Quadruple("My Campus", "Campus Central", R.drawable.mycampus, Color(0xFF32733C)), // Azul
        Quadruple("My Friends", "", R.drawable.myfriends, Color(0xFF505AE6)), // Verde
        Quadruple("My Calendar", "", R.drawable.mycalendar, Color(0xFF5FC887)), // Rojo
        Quadruple("My Courses", "", R.drawable.mycourses, Color(0xFFE97132)), // Morado
        Quadruple("My Grades", "", R.drawable.mygrades, Color(0xFF505AE6)), // Amarillo
        Quadruple("My Groups", "", R.drawable.mygroups, Color(0xFF505AE6)), // Cyan
        Quadruple("My Upcoming Events", "", R.drawable.myupcoming, Color(0xFF5AB9C8)) // Gris
    )

    Column {
        options.forEach { option ->
            OptionItem(
                title = option.first,
                subtitle = option.second,
                iconResId = option.third,
                iconColor = option.fourth
            )
            Divider()
        }
    }
}

@Composable
fun OptionItem(title: String, subtitle: String, iconResId: Int, iconColor: Color) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            painter = painterResource(id = iconResId),
            contentDescription = "Option Icon",
            modifier = Modifier.size(24.dp),
            tint = iconColor
        )
        Spacer(modifier = Modifier.width(16.dp))
        Column {
            Text(text = title)
            if (subtitle.isNotEmpty()) {
                Text(text = subtitle, fontSize = 12.sp)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ProfileScreenPreview() {
    Laboratorio4PMTheme {
        ProfileScreen()
    }
}

data class Quadruple<A, B, C, D>(
    val first: A,
    val second: B,
    val third: C,
    val fourth: D
)