package alejandro.developer.presentation

import alejandro.developer.domain.model.RecipeModel
import alejandro.developer.presentation.ui.component.ElevatedMenuButton
import alejandro.developer.presentation.ui.pruebascurso.AdvanceSlider
import alejandro.developer.presentation.ui.pruebascurso.MiNavegacion
import alejandro.developer.presentation.ui.pruebascurso.MyColumnColours
import alejandro.developer.presentation.ui.pruebascurso.MyRadioButtonListParameter
import alejandro.developer.presentation.ui.pruebascurso.MyRangeSlider
import alejandro.developer.presentation.ui.pruebascurso.MySuperConstraintLayout
import alejandro.developer.presentation.ui.pruebascurso.PruebaHosting
import alejandro.developer.presentation.ui.theme.MealAppTheme
import alejandro.developer.presentation.ui.screen.mainmenu.PruebaViewModel
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.lifecycle.lifecycleScope
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

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

        enableEdgeToEdge()
        setContent {
            //Controler para ejercicio
            val navigationController = rememberNavController()
            MealAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    /*MyFoodList(
                        viewModel = viewModel,
                        modifier = Modifier.padding(innerPadding)
                    )*/
                    MiNavegacion(navigationController)
                }
            }
        }
    }
}



//PARA MI APLICACION

@Composable
fun MyFoodList(viewModel: PruebaViewModel, modifier: Modifier = Modifier) {
    val recipes by viewModel.recipes.collectAsState()

    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .padding(16.dp)
    ) {
        items(recipes) { recipe ->
            RecipeItem(recipe = recipe)
        }
    }
}

@Composable
fun RecipeItem(recipe: RecipeModel) {
    var isSelected by remember { mutableStateOf(false) }
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(8.dp)
    ) {
        Column {
            // Imagen con esquinas redondeadas
            AsyncImage(
                model = recipe.image,
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
                    .clip(RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp))
            )

            // Fondo degradado para el contenido textual
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(
                        Brush.verticalGradient(
                            colors = listOf(
                                MaterialTheme.colorScheme.primary.copy(alpha = 0.1f),
                                MaterialTheme.colorScheme.primary.copy(alpha = 0.2f),
                                MaterialTheme.colorScheme.primary.copy(alpha = 0.3f)
                            )
                        )
                    )
                    .padding(16.dp)
            ) {
                Column {
                    Text(
                        text = recipe.name,
                        style = MaterialTheme.typography.headlineMedium,
                        color = MaterialTheme.colorScheme.onBackground
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = recipe.recipe,
                        fontFamily = FontFamily(Font(R.font.playpensans_variablefont_wght)),
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.onBackground,
                    )
                    var selectedIndex by remember { mutableIntStateOf(0) }
                    ElevatedMenuButton("Menu",
                        { selectedIndex = 0 },
                        isButtonSelected = selectedIndex == 0)
                    ElevatedMenuButton("Menu",
                        { selectedIndex = 1 },
                        isButtonSelected = selectedIndex == 1)
                    ElevatedMenuButton("Menu",
                        { selectedIndex = 2 },
                        isButtonSelected = selectedIndex == 2)
                }
            }
        }
    }
}