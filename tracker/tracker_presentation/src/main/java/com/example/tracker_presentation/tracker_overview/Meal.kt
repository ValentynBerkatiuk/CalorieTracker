package com.example.tracker_presentation.tracker_overview

import androidx.annotation.DrawableRes
import com.example.calorietracker.R
import com.example.core.util.UIText
import com.example.tracker_domain.model.MealType

data class Meal (
    val name: UIText,
    @DrawableRes val drawableRes: Int,
    val mealType: MealType,
    val carbs: Int = 0,
    val fats: Int = 0,
    val proteins: Int = 0,
    val calories: Int = 0,
    val isExpanded: Boolean = false
)

val defaultMeals = listOf(
    Meal(
        name = UIText.StringResource(R.string.breakfast),
        drawableRes = R.drawable.ic_breakfast,
        mealType = MealType.Breakfast
    ),
    Meal(
        name = UIText.StringResource(R.string.lunch),
        drawableRes = R.drawable.ic_lunch,
        mealType = MealType.Lunch
    ),
    Meal(
        name = UIText.StringResource(R.string.dinner),
        drawableRes = R.drawable.ic_dinner,
        mealType = MealType.Dinner
    ),
    Meal(
        name = UIText.StringResource(R.string.snacks),
        drawableRes = R.drawable.ic_snack,
        mealType = MealType.Snack
    )
)