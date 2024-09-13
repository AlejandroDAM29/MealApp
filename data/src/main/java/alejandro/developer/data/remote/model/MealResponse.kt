package alejandro.developer.data.remote.model

import alejandro.developer.domain.model.MealModel
import com.google.gson.annotations.SerializedName

data class MealResponse(
    @SerializedName("idMeal") val idMeal: String,
    @SerializedName("strMeal") val meal: String,
    @SerializedName("strDrinkAlternate") val drinkAlternate: String?,
    @SerializedName("strCategory") val category: String,
    @SerializedName("strArea") val area: String,
    @SerializedName("strInstructions") val instructions: String,
    @SerializedName("strMealThumb") val mealThumb: String?,
    @SerializedName("strTags") val tags: String?,
    @SerializedName("strYoutube") val youtubeVideo: String?,
    @SerializedName("strIngredient1") val ingredient1: String,
    @SerializedName("strIngredient2") val ingredient2: String?,
    @SerializedName("strIngredient3") val ingredient3: String?,
    @SerializedName("strIngredient4") val ingredient4: String?,
    @SerializedName("strIngredient5") val ingredient5: String?,
    @SerializedName("strIngredient6") val ingredient6: String?,
    @SerializedName("strIngredient7") val ingredient7: String?,
    @SerializedName("strIngredient8") val ingredient8: String?,
    @SerializedName("strIngredient9") val ingredient9: String?,
    @SerializedName("strIngredient10") val ingredient10: String?,
    @SerializedName("strIngredient11") val ingredient11: String?,
    @SerializedName("strIngredient12") val ingredient12: String?,
    @SerializedName("strIngredient13") val ingredient13: String?,
    @SerializedName("strIngredient14") val ingredient14: String?,
    @SerializedName("strIngredient15") val ingredient15: String?,
    @SerializedName("strIngredient16") val ingredient16: String?,
    @SerializedName("strIngredient17") val ingredient17: String?,
    @SerializedName("strIngredient18") val ingredient18: String?,
    @SerializedName("strIngredient19") val ingredient19: String?,
    @SerializedName("strIngredient20") val ingredient20: String?,
    @SerializedName("strMeasure1") val measure1: String?,
    @SerializedName("strMeasure2") val measure2: String?,
    @SerializedName("strMeasure3") val measure3: String?,
    @SerializedName("strMeasure4") val measure4: String?,
    @SerializedName("strMeasure5") val measure5: String?,
    @SerializedName("strMeasure6") val measure6: String?,
    @SerializedName("strMeasure7") val measure7: String?,
    @SerializedName("strMeasure8") val measure8: String?,
    @SerializedName("strMeasure9") val measure9: String?,
    @SerializedName("strMeasure10") val measure10: String?,
    @SerializedName("strMeasure11") val measure11: String?,
    @SerializedName("strMeasure12") val measure12: String?,
    @SerializedName("strMeasure13") val measure13: String?,
    @SerializedName("strMeasure14") val measure14: String?,
    @SerializedName("strMeasure15") val measure15: String?,
    @SerializedName("strMeasure16") val measure16: String?,
    @SerializedName("strMeasure17") val measure17: String?,
    @SerializedName("strMeasure18") val measure18: String?,
    @SerializedName("strMeasure19") val measure19: String?,
    @SerializedName("strMeasure20") val measure20: String?,
    @SerializedName("strSource") val source: String?,
    @SerializedName("strImageSource") val imageSource: String?,
    @SerializedName("strCreativeCommonsConfirmed") val creativeCommonsConfirmed: String?,
    @SerializedName("dateModified") val dateModified: String?
) {
    fun toMealModel(): MealModel = MealModel(
        idMeal,
        meal,
        drinkAlternate,
        category,
        area,
        instructions,
        mealThumb,
        tags,
        youtubeVideo,
        ingredient1,
        ingredient2,
        ingredient3,
        ingredient4,
        ingredient5,
        ingredient6,
        ingredient7,
        ingredient8,
        ingredient9,
        ingredient10,
        ingredient11,
        ingredient12,
        ingredient13,
        ingredient14,
        ingredient15,
        ingredient16,
        ingredient17,
        ingredient18,
        ingredient19,
        ingredient20,
        measure1,
        measure2,
        measure3,
        measure4,
        measure5,
        measure6,
        measure7,
        measure8,
        measure9,
        measure10,
        measure11,
        measure12,
        measure13,
        measure14,
        measure15,
        measure16,
        measure17,
        measure18,
        measure19,
        measure20,
        source,
        imageSource,
        creativeCommonsConfirmed,
        dateModified
    )

    companion object {

        fun fromMealModel(mealModel: MealModel) =
            MealResponse(
                mealModel.idMeal,
                mealModel.strMeal,
                mealModel.strDrinkAlternate,
                mealModel.category,
                mealModel.area,
                mealModel.instructions,
                mealModel.mealThumb,
                mealModel.tags,
                mealModel.youtube,
                mealModel.ingredient1,
                mealModel.ingredient2,
                mealModel.ingredient3,
                mealModel.ingredient4,
                mealModel.ingredient5,
                mealModel.ingredient6,
                mealModel.ingredient7,
                mealModel.ingredient8,
                mealModel.ingredient9,
                mealModel.ingredient10,
                mealModel.ingredient11,
                mealModel.ingredient12,
                mealModel.ingredient13,
                mealModel.ingredient14,
                mealModel.ingredient15,
                mealModel.ingredient16,
                mealModel.ingredient17,
                mealModel.ingredient18,
                mealModel.ingredient19,
                mealModel.ingredient20,
                mealModel.measure1,
                mealModel.measure2,
                mealModel.measure3,
                mealModel.measure4,
                mealModel.measure5,
                mealModel.measure6,
                mealModel.measure7,
                mealModel.measure8,
                mealModel.measure9,
                mealModel.measure10,
                mealModel.measure11,
                mealModel.measure12,
                mealModel.measure13,
                mealModel.measure14,
                mealModel.measure15,
                mealModel.measure16,
                mealModel.measure17,
                mealModel.measure18,
                mealModel.measure19,
                mealModel.measure20,
                mealModel.source,
                mealModel.imageSource,
                mealModel.creativeCommonsConfirmed,
                mealModel.dateModified
            )
    }
}

