package alejandro.developer.presentation.ui.pruebascurso

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier


data class RadioButtonComposeModel(
    val name: String,
    val onRadioButtonClick: (String) -> Unit
)


@Composable
fun RadioButtonComposeModel(nameList: List<String>, selectedValue: String, modifier: Modifier, onClickRadioSelected: (String) -> Unit){
    Column(modifier = modifier) {
        nameList.forEach{ name ->
            RadioButtonComposeModel(
                name = name,
                onRadioButtonClick = onClickRadioSelected
            ).let { model ->
                Row(verticalAlignment = Alignment.CenterVertically){
                    RadioButton(
                        selected = model.name == selectedValue,
                        onClick = { model.onRadioButtonClick(model.name) }
                    )
                    Text(text = model.name)
                }
            }
        }
    }
}

@Composable
fun MyRadioButtonListParameter(modifier: Modifier){
    var myState by rememberSaveable { mutableStateOf("") }
    RadioButtonComposeModel(
        nameList = listOf("Alejandro", "Mireia", "Laika", "Marta", "Laura"),
        selectedValue = myState,
        modifier = modifier,
        onClickRadioSelected = { myState = it })
}