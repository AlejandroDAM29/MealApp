package alejandro.developer.presentation.ui.pruebascurso


import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier

@Composable
fun PruebaHosting(modifier: Modifier = Modifier) {
    var myNumber by rememberSaveable { mutableIntStateOf(0) }
    Column(modifier) {
        StateText1(myNumber) { myNumber += 1 }
        StateText2(myNumber) { myNumber += 1 }
    }
}

@Composable
fun StateText1(number: Int, myClick: () -> Unit) {
    Text(text = "El numero es $number", modifier = Modifier.clickable(onClick = myClick))
}

@Composable
fun StateText2(number: Int, myClick: () -> Unit) {
    Text(text = "El numero es $number", modifier = Modifier.clickable(onClick = myClick))
}

