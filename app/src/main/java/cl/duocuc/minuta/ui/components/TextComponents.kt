import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview

/**
 * Componente reutilizable para encabezados principales
 * @param text Texto a mostrar
 * @param modifier Modificadores opcionales
 * @param style Estilo del texto
 * @param color Color del texto
 */
@Composable
fun HeaderTitleText(
    texto: String,
    emoji: String = "🍴",
    modifier: Modifier = Modifier
) {
    Text(
        text = "$emoji $texto",
        modifier = modifier,
        style = MaterialTheme.typography.headlineSmall.copy(
            fontWeight = FontWeight.Bold,
            color = Color(0xFF333333)
        ),
        textAlign = TextAlign.Center
    )
}

/**
 * Componente para subtítulos
 */
@Composable
fun SubtitleText(
    text: String,
    modifier: Modifier = Modifier
) {
    Text(
        text = text,
        modifier = modifier,
        style = MaterialTheme.typography.bodyMedium,
        color = Color(0xFF555555),
        textAlign = TextAlign.Center,

    )
}




/**
 * Componente para texto de cuerpo con estilo consistente
 */
@Composable
fun BodyText(
    text: String,
    modifier: Modifier = Modifier,
    textAlign: TextAlign = TextAlign.Start
) {
    Text(
        text = text,
        modifier = modifier,
        style = MaterialTheme.typography.bodyMedium,
        color = MaterialTheme.colorScheme.onSurface,
        textAlign = textAlign
    )
}

// Previews para visualizar los componentes
@Preview(showBackground = true)
@Composable
private fun HeaderTextPreview() {
    MaterialTheme {
        HeaderTitleText(texto = "Tu Minuta Semanal")

      //  TituloMinuta(texto = "Recetas Favoritas", emoji = "⭐")
    }
}

@Preview(showBackground = true)
@Composable
private fun SubtitleTextPreview() {
    MaterialTheme {
        SubtitleText("Subtítulo de ejemplo")
    }
}

@Preview(showBackground = true)
@Composable
private fun BodyTextPreview() {
    MaterialTheme {
        BodyText("Este es un texto de cuerpo de ejemplo que muestra cómo se ve el componente.")
    }
}