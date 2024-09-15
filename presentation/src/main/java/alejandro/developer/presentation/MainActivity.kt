package alejandro.developer.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import alejandro.developer.presentation.ui.theme.MealAppTheme
import alejandro.developer.presentation.ui.theme.screen.mainmenu.PruebaViewModel
import android.util.Log
import androidx.activity.result.launch
import androidx.activity.viewModels
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.layout.Box
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.lifecycleScope
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity: ComponentActivity() {
    private val viewModel: PruebaViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        lifecycleScope.launch {
            viewModel.recipes.collect { recipe ->
                if (recipe.isNotEmpty())
                    Log.d("MainActivity", "Salsita: "+recipe[0].recipe)
            }
        }

        /*getMealsByNameUseCase(GetMealsByNameUseCase.Parameters.forGetMealsByNameUseCase("PE"))
            .collect { meals ->
                prueba = meals
                Log.d("test-300", "Meals: $prueba")
            }*/

        enableEdgeToEdge()
        setContent {
            MealAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        actionClick = { Log.i("test-300", viewModel.recipes.value[0].recipe) },
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun Greeting(name: String, actionClick: () -> Unit ,modifier: Modifier = Modifier) {
    Box(Modifier.fillMaxSize().background(Color.Blue).combinedClickable(
        onClick = { actionClick },
        onLongClick = { },
        onDoubleClick = {  }
    )){
        Text(
            text = "Hello $name!",
            color = Color.White,
            modifier = modifier.clickable { actionClick() }
        )
    }
}

/*
@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MealAppTheme {
        Greeting("Android")
    }
}*/
