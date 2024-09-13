package alejandro.developer.presentation

import alejandro.developer.domain.model.MealModel
import alejandro.developer.domain.usecase.GetMealsByNameUseCase
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
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
            viewModel.meals.collect { meals ->
                if (meals.isNotEmpty())
                    Log.d("MainActivity", "Salsita: "+meals[0].area)
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
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Box(Modifier.fillMaxSize().background(Color.Blue).clickable { Log.i("test-200", "adios") }){
        Text(
            text = "Hello $name!",
            color = Color.White,
            modifier = modifier
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
