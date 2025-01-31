package alejandro.developer.presentation.ui.pruebascurso

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
fun MyColumnColours(padding: Modifier) {
    Column(modifier = padding.fillMaxSize()) {
        Box(Modifier.weight(1f).background(Color.Cyan).fillMaxWidth(), contentAlignment = Alignment.Center){
            Text("Ejemplo 1")
        }
        Row(Modifier.weight(1f).fillMaxWidth()) {
            Box(Modifier.weight(1f).background(Color.Red).fillMaxHeight(), contentAlignment = Alignment.Center){
                Text("Ejemplo 2")
            }
            Box(Modifier.weight(1f).background(Color.Green).fillMaxHeight(), contentAlignment = Alignment.Center){
                Text("Ejemplo 3")
            }
        }
        Box(Modifier.weight(1f).background(Color.Magenta).fillMaxWidth(), contentAlignment = Alignment.BottomCenter){
            Text("Ejemplo 4")
        }
    }
}