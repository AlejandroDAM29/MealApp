package alejandro.developer.data.remote.model

import alejandro.developer.domain.model.RecipeModel
import com.google.gson.annotations.SerializedName

data class RecipeResponse(
    @SerializedName("id") val id: String,
    @SerializedName("name")val name: String,
    @SerializedName("calories")val calories: String,
    @SerializedName("moment")val moment: String,
    @SerializedName("image")val image: String,
    @SerializedName("ingredients")val ingredients: String,
    @SerializedName("recipe")val recipe: String
){

    fun toRecipeModel(): RecipeModel = RecipeModel(
        id,
        name,
        calories,
        moment,
        image,
        ingredients,
        recipe
    )

    companion object {
        fun fromRecipeModel(recipeModel: RecipeModel) = RecipeResponse(
            recipeModel.id,
            recipeModel.name,
            recipeModel.calories,
            recipeModel.moment,
            recipeModel.image,
            recipeModel.ingredients,
            recipeModel.recipe
        )
    }
}
