package alejandro.developer.presentation.ui.component

import alejandro.developer.presentation.ui.theme.GreaseUnselected
import alejandro.developer.presentation.ui.theme.GreenSelected
import alejandro.developer.presentation.ui.theme.Typographies
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp

@Composable
fun ElevatedMenuButton(
    textButton: String,
    onClick: () -> Unit,
    isButtonSelected: Boolean,
    modifier: Modifier = Modifier,
    overrideTextAlign: TextAlign? = null
    ) {

    val containerColor = if (isButtonSelected) GreenSelected else GreaseUnselected
    val contentButtonColor = if (isButtonSelected) Color.White else Color.Black

    Button(
        onClick = {
            onClick()
        },
        shape = RoundedCornerShape(12.dp),
        colors = ButtonColors(
            containerColor = containerColor,
            contentColor = contentButtonColor,
            disabledContainerColor = containerColor,
            disabledContentColor = contentButtonColor
        ),
        contentPadding = PaddingValues(horizontal = 24.dp),
        elevation = ButtonDefaults.buttonElevation(
            defaultElevation = 16.dp,
            pressedElevation = 4.dp,
            hoveredElevation = 6.dp,
            focusedElevation = 6.dp
        ),
        modifier = modifier.sizeIn(maxHeight = 30.dp)
    ) {
        Text(
            style = Typographies.headlineMedium,
            text = textButton,
            textAlign = overrideTextAlign,
            overflow = TextOverflow.Clip,
            softWrap = true,
            maxLines = Int.MAX_VALUE
        )
    }
}