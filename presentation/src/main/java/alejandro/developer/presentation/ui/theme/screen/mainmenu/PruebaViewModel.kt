package alejandro.developer.presentation.ui.theme.screen.mainmenu

import alejandro.developer.domain.model.RecipeModel
import alejandro.developer.domain.usecase.GetAllRecipes
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PruebaViewModel @Inject constructor(
private val getAllRecipes: GetAllRecipes
): ViewModel() {

    private val _recipes = MutableStateFlow<List<RecipeModel>>(emptyList())
    val recipes: StateFlow<List<RecipeModel>> = _recipes.asStateFlow()

    init {
        viewModelScope.launch {
            getAllRecipes()
                .collect {
                    _recipes.value = it
                }
        }
    }

}