package alejandro.developer.presentation.ui.component

import alejandro.developer.presentation.R
import alejandro.developer.presentation.ui.theme.BlackText
import alejandro.developer.presentation.ui.theme.GreaseUnselected
import alejandro.developer.presentation.ui.theme.GreenSelected
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ElevatedMenuButton(
    textButton: String,
    onClick: () -> Unit,
    isButtonSelected: Boolean,
    modifier: Modifier = Modifier,
    textFontFamily: Font = Font(R.font.playpensans_variablefont_wght),
    textFontSize: Int = 12,
    textColor: Color = BlackText,
    fontWeight: FontWeight? = FontWeight.W900,
    textLetterSpacing: TextUnit = TextUnit.Unspecified,
    overrideTextDecoration: TextDecoration? = null,
    overrideTextAlign: TextAlign? = null,
    textlineHeight: TextUnit = TextUnit.Unspecified,
    textoverflow: TextOverflow = TextOverflow.Clip,
    textsoftWrap: Boolean = true,
    textmaxLines: Int = Int.MAX_VALUE,
    textminLines: Int = 1
    ) {

    val containerColor = if (isButtonSelected) GreenSelected else GreaseUnselected
    val contentButtonColor = if (isButtonSelected) Color.White else Color.Black

    Button(
        onClick = {
            onClick() // Ejecuta la acción adicional
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
            text = textButton,
            fontFamily = FontFamily(textFontFamily),
            fontSize = textFontSize.sp,
            color = textColor,
            fontWeight = fontWeight,
            letterSpacing = textLetterSpacing,
            textDecoration = overrideTextDecoration,
            textAlign = overrideTextAlign,
            lineHeight = textlineHeight,
            overflow = textoverflow,
            softWrap = textsoftWrap,
            maxLines = textmaxLines,
            minLines = textminLines
        )
    }
}