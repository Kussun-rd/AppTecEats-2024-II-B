package com.diaz.rodrigo.teceatapp

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.diaz.rodrigo.teceatapp.ui.theme.TecEatAppTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TecEatAppTheme {
                // Llamamos a la pantalla de bienvenida y pasamos la función de navegación
                WelcomeScreen(
                    onRegisterClick = {
                        val intent = Intent(this, RegisterActivity::class.java)
                        startActivity(intent)
                    }
                )
            }
        }
    }
}



@Composable
fun WelcomeScreen(onRegisterClick: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        // Imagen del campus en la parte superior
        Image(
            painter = painterResource(id = R.drawable.fondo_tecsup), // Imagen del campus
            contentDescription = "Campus Tecsup",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
                .height(250.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Texto "Bienvenido a"
        Text(
            text = "Bienvenido a",
            fontSize = 24.sp,
            color = Color(0xFF00A6E8), // Color azul
            fontWeight = FontWeight.Bold
        )

        // Logo Tec Eat
        Image(
            painter = painterResource(id = R.drawable.logo_teceat), // Imagen de Tec Eat
            contentDescription = "Logo Tec Eat",
            modifier = Modifier
                .width(180.dp)
                .height(60.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Texto descriptivo
        Text(
            text = "Inicia sesión en Tec Eat y disfruta de todas nuestras funcionalidades.",
            fontSize = 14.sp,
            color = Color(0xFF00A6E8),
            modifier = Modifier.padding(horizontal = 16.dp)
        )

        Spacer(modifier = Modifier.height(24.dp))

        // Aquí se coloca el botón con el logo de Google
        Button(
            onClick = { /* Acción para iniciar sesión */ },
            modifier = Modifier
                .width(250.dp)
                .height(50.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                // Asegúrate de que el archivo google_logo.png esté en la carpeta drawable
                Image(
                    painter = painterResource(id = R.drawable.google_logo), // Imagen del logo de Google
                    contentDescription = "Google Logo",
                    modifier = Modifier.size(24.dp)  // Ajusta el tamaño de la imagen
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(text = "Iniciar Sesión")
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Texto clickeable para registrarse
        Text(
            text = "¿Eres dueño de un restaurante?",
            fontSize = 14.sp,
            color = Color.Black
        )

        ClickableText(
            text = AnnotatedString("Regístrate aquí"),
            onClick = { onRegisterClick() },  // Ejecuta la función de navegación al hacer clic
            style = androidx.compose.ui.text.TextStyle(
                fontSize = 16.sp,
                color = Color(0xFF00A6E8)
            )
        )
    }
}


@Preview(showBackground = true)
@Composable
fun WelcomeScreenPreview() {
    TecEatAppTheme {
        WelcomeScreen(onRegisterClick = {})
    }
}



