import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp


// ========== 2. LayoutComponents.kt ==========
@Composable
fun VerticalSpacer(height: Dp = 16.dp) {
    Spacer(modifier = Modifier.height(height))
}

@Composable
fun HorizontalSpacer(width: Dp = 16.dp) {
    Spacer(modifier = Modifier.width(width))
}

@Composable
fun DecorativeDivider(
    modifier: Modifier = Modifier,
    widthPercent: Float = 0.6f,
    thickness: Dp = 1.dp,
    color: Color = Color.Gray.copy(alpha = 0.4f),
    verticalPadding: Dp = 12.dp
) {
    HorizontalDivider(
        modifier = modifier
            .padding(vertical = verticalPadding)
            .fillMaxWidth(widthPercent),
        thickness = thickness,
        color = color
    )
}