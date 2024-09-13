package alejandro.developer.presentation.ui.theme.screen.mainmenu

import alejandro.developer.domain.model.MealModel
import alejandro.developer.domain.usecase.GetMealsByNameUseCase
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PruebaViewModel @Inject constructor(
private val getMealsByNameUseCase: GetMealsByNameUseCase
): ViewModel() {


    private val _meals = MutableStateFlow<List<MealModel>>(emptyList())
    val meals: StateFlow<List<MealModel>> = _meals.asStateFlow()

    init {
        viewModelScope.launch {
            getMealsByNameUseCase(GetMealsByNameUseCase.Parameters.forGetMealsByNameUseCase("PE"))
                .collect {
                    _meals.value = it
                }
        }
    }

}