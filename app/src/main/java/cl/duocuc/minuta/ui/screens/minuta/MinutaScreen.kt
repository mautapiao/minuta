package cl.duocuc.minuta.ui.screens.minuta

import DecorativeDivider
import HeaderTitleText
import SubtitleText
import VerticalSpacer
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import cl.duocuc.minuta.R
import cl.duocuc.minuta.data.local.recetasSemana

@Composable
fun MinutaScreen(
    onRecetaClick: (String) -> Unit,
    onLogout: () -> Unit
) {

    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        // Imagen de fondo
        Image(
            painter = painterResource(id = R.drawable.frutas_verduras), // coloca tu imagen aquí
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop, // ajusta la escala al contenedor
            alpha = 0.3f
        )
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp),
            verticalArrangement = Arrangement.SpaceBetween, // distribuye arriba y abajo
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            // Espacio vertical, separador
            VerticalSpacer(height = 32.dp)

            // Título Componente ui components
            HeaderTitleText(texto = "Tu Minuta Semanal", emoji = "🍴")

            // Subtítulo
            SubtitleText("Planifica tus comidas de la semana con recetas fáciles y saludables")

            // Divisor decorativo
            DecorativeDivider()

            // Grilla con recetas (ocupa espacio disponible arriba)
            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                modifier = Modifier.weight(1f)
            ) {
                items(recetasSemana) { receta ->
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable { onRecetaClick(receta.dia) }
                            .padding(horizontal = 8.dp, vertical = 8.dp),
                        shape = RoundedCornerShape(12.dp),
                        elevation = CardDefaults.cardElevation(defaultElevation = 6.dp)
                    ) {
                        Column(modifier = Modifier.padding(16.dp)) {
                            Text(
                                text = receta.dia,
                                style = MaterialTheme.typography.titleMedium.copy(
                                    fontWeight = FontWeight.Bold,
                                    color = Color(0xFF7C4DFF)
                                )
                            )
                            Text(receta.nombre, style = MaterialTheme.typography.bodyLarge)
                        }
                    }
                }
            }

            // Botón fijo abajo para cierre sesión
            Button(
                onClick = { onLogout() },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Cerrar sesión")
            }
        }
    }
}

// ----- Preview -----
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewMinutaScreen() {
    MaterialTheme {
        MinutaScreen(
            onRecetaClick = {},
            onLogout = {}
        )
    }
}