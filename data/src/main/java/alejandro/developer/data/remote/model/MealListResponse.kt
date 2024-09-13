package alejandro.developer.data.remote.model

import com.google.gson.annotations.SerializedName

data class MealListResponse(
    @SerializedName("meals") val meals: List<MealResponse>
)
