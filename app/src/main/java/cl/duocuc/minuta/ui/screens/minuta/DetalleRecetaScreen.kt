package cl.duocuc.minuta.ui.screens.minuta

import DecorativeDivider
import HeaderTitleText
import SubtitleText
import VerticalSpacer
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import cl.duocuc.minuta.R
import cl.duocuc.minuta.data.local.recetasSemana

/**
 * DetalleRecetaScreen
 * @composable: Anotación indica que esta función crea UI
 * dia: String: Parámetro que recibe el día seleccionado ("Lunes", "Martes", etc)
 * onBack: ()-> Unit: Lambda sin parámetros para manejar el botón "volver"
 *         () Unit significa "funcion que no recibe nada y no devuelve nada"
 *         en realidad si hace algo: Dame cualquier función que no necesite
 *                                   parámetros y no devuelva nada
 *         ej: paso para volver atrás :onBack = { navController.popBackStack() }
 */

@Composable
fun DetalleRecetaScreen(dia: String, onBack: () -> Unit) {

    /**
     * recetasSemana.find{ ... } : busca en la lista de recetas
     * it.dia == dia: Encuentra la receta cuyo día coincia con el parámetro
     * resultado: si encuentra -> receta contiene el onjeto Receta
     *            si No encuentra -> receta es null
     */
    val receta = recetasSemana.find { it.dia == dia }

    /**
     * Layout principal
     * Column: Organiza elementos verticalmente (uno debajo del otro)
     * fillMaxSize(): Ocupa todo el espacio disponible de la pantalla
     * padding 16 dp: Añade margen  interno de 16 densuty pixels
     *
     * Titulo de la receta
     *
     * receta?.nombre: Acceso seguro al nombre, puede ser null
     * ?: "Receta": Si nombre es null, usa "Receta"
     * headlineMedium; Estilo de texto grande para titulos
     * Spacer: Crea espacio vacío de 8pd de altura
     * titleMedium: Estilo para subtitulos secciones
     *
     * Lista de ingredientes:
     *
     * receta?.ingedientes?.: doble acceso seguro, recera puede ser null e ingredientes también
     * "• $ing": añande viñeta (•) a cada ingrediente
     *
     * Sección recomedaciones:
     *
     * .orEmpty(): Si recomendaciones es null, devuelve cadena vacía ""
     * onClick = onBack: Ejecuta la lambda que se pasó como parámetro
     */
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
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {


            // Espacio vertical, separador
            VerticalSpacer(height = 32.dp)

            // Título Componente ui components
            HeaderTitleText(texto = "Tu Minuta Semanal", emoji = "🍴")

            // Subtítulo
            SubtitleText("Detalle de recetas seleccionada")

            // Divisor decorativo
            DecorativeDivider()

            Card(
                modifier = Modifier.fillMaxWidth(),
                elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.surface
                )
            ) {
                Column(
                    modifier = Modifier.padding(16.dp) // Agrega este padding
                ) {
                    Text(
                        text = receta?.nombre ?: "Receta",
                        style = MaterialTheme.typography.headlineMedium
                    )
                    Spacer(Modifier.height(8.dp))
                    Text("Ingredientes:", style = MaterialTheme.typography.titleMedium)
                    receta?.ingredientes?.forEach { ing ->
                        Text("• $ing")
                    }
                    Spacer(Modifier.height(8.dp))
                    Text("Recomendaciones:", style = MaterialTheme.typography.titleMedium)
                    Text(receta?.recomendaciones.orEmpty())
                    Spacer(Modifier.height(16.dp))
                }
                // Botón fijo abajo para cierre sesión
            }

            // Divisor decorativo
            Spacer(modifier = Modifier.height(16.dp))


            Button(
                onClick = onBack,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Volver")
            }
        }
    }
}
// ---- Preview
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewMinutaDetalleScreen() {
    MaterialTheme {
        DetalleRecetaScreen(
            dia = "Lunes",
            onBack = {}
        )
    }
}

