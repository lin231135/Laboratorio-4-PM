package com.example.laboratorio_4_pm

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.laboratorio_4_pm.ui.theme.Laboratorio4PMTheme

class Emergency : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Laboratorio4PMTheme {
                EmergencyContactsScreen()
            }
        }
    }
}

@Composable
fun EmergencyContactsScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        EmergencySection(
            title = "Emergencias",
            description = "Si se presenta un incidente o un percance por favor marca el número de emergencia y rápidamente te apoyamos.",
            phoneNumber = "5978-1736",
            iconResId = R.drawable.emergency
        )

        Spacer(modifier = Modifier.height(16.dp))

        ClinicSection(
            title = "Clínica UVG",
            description = """
                La Clínica UVG, presta los siguientes servicios:
                * Atención a Emergencias
                * Atención Primaria a Enfermedades Comunes
                * Plan Educacional sobre Enfermedades
                
                Horario de Atención: 7:00 a.m. a 8:30 p.m.
                Campus Central Edificio F 119-120.
            """.trimIndent(),
            phoneNumber = "2507-1500 ex 21312",
            imageResId = R.drawable.clinic
        )
    }
}

@Composable
fun EmergencySection(title: String, description: String, phoneNumber: String, iconResId: Int) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White)
            .padding(16.dp)
            .background(Color.White, RoundedCornerShape(8.dp))
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Image(
                painter = painterResource(id = iconResId),
                contentDescription = "Emergency Icon",
                modifier = Modifier
                    .size(32.dp)
                    .background(Color.Red, CircleShape)
                    .padding(4.dp),
                contentScale = ContentScale.Fit
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(text = title, fontWeight = FontWeight.Bold, fontSize = 18.sp)
        }

        Spacer(modifier = Modifier.height(8.dp))

        Text(text = description, fontSize = 14.sp)

        Spacer(modifier = Modifier.height(16.dp))

        CallButton(phoneNumber = phoneNumber)
    }
}

@Composable
fun ClinicSection(title: String, description: String, phoneNumber: String, imageResId: Int) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White)
            .padding(16.dp)
            .background(Color.White, RoundedCornerShape(8.dp))
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Image(
                painter = painterResource(id = imageResId),
                contentDescription = "Clinic Image",
                modifier = Modifier.size(50.dp),
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(text = title, fontWeight = FontWeight.Bold, fontSize = 18.sp)
        }

        Spacer(modifier = Modifier.height(8.dp))

        Text(text = description, fontSize = 14.sp)

        Spacer(modifier = Modifier.height(16.dp))

        CallButton(phoneNumber = phoneNumber)
    }
}

@Composable
fun CallButton(phoneNumber: String) {
    Button(
        onClick = { /* Acción para llamar */ },
        modifier = Modifier
            .fillMaxWidth()
            .height(48.dp),
        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF32733C)),
        shape = RoundedCornerShape(8.dp)
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(
                imageVector = Icons.Default.Call,
                contentDescription = "Call Icon",
                modifier = Modifier.size(24.dp),
                tint = Color.White
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(text = "Call $phoneNumber", color = Color.White)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun EmergencyContactsScreenPreview() {
    Laboratorio4PMTheme {
        EmergencyContactsScreen()
    }
}
