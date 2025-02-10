package alejandro.developer.presentation.ui.pruebascurso

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument

@Composable
fun Screen1(navHostController: NavHostController) {
    Box(Modifier.fillMaxSize().background(Color.Cyan).clickable { navHostController.navigate("Pantalla2") }){
        Text("Pantalla 1", modifier = Modifier.align(Alignment.Center))
    }
}

@Composable
fun Screen2(navHostController: NavHostController) {
    Box(Modifier.fillMaxSize().background(Color.Red).clickable { navHostController.navigate("Pantalla3") }){
        Text("Pantalla 2", modifier = Modifier.align(Alignment.Center))
    }
}

@Composable
fun Screen3(navHostController: NavHostController) {
    Box(Modifier.fillMaxSize().background(Color.Green).clickable { navHostController.navigate("Pantalla4/80") }){
        Text("Pantalla 3", modifier = Modifier.align(Alignment.Center))
    }
}

@Composable
fun Screen4(numberScreen: Int, name: String) {
    Box(Modifier.fillMaxSize().background(Color.Green)){
        Text("Pantalla número $numberScreen con nombre: $name" , modifier = Modifier.align(Alignment.Center))
    }
}

@Composable
fun MiNavegacion(navigationController: NavHostController) {
    NavHost(navController = navigationController, startDestination = "pantalla1") {
        composable("pantalla1") { Screen1(navigationController) }
        composable("pantalla2") { Screen2(navigationController) }
        composable("pantalla3") { Screen3(navigationController) }
        composable(route = "pantalla4/{numberScreen}?name={name}",
            arguments = listOf(
                navArgument("numberScreen"){ type = NavType.IntType },
                navArgument("name"){
                    type = NavType.StringType
                    defaultValue = "Laika"
                    nullable = false
                }
            )
        ){ backStackEntry ->
            Screen4(backStackEntry.arguments?.getInt("numberScreen") ?: 0,
                backStackEntry.arguments?.getString("name").orEmpty()
            )}
        /*{ backStackEntry ->
            Screen4(backStackEntry.arguments?.getInt("numberScreen") ?: 0
            )}*/
    }
}