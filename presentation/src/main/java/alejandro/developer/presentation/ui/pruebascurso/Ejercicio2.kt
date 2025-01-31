package alejandro.developer.presentation.ui.pruebascurso

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout

@Composable
fun MySuperConstraintLayout(){
    ConstraintLayout(Modifier.fillMaxSize()) {
        val (boxRed, boxGray) = createRefs()
        Box(Modifier.size(150.dp).constrainAs(boxRed){})
        Box(Modifier.size(150.dp).constrainAs(boxGray){
            top.linkTo(boxRed.bottom)
        })

    }
}