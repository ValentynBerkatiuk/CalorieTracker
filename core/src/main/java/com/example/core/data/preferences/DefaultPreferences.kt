package com.example.core.data.preferences

import android.content.SharedPreferences
import com.example.core.domain.model.ActivityLevel
import com.example.core.domain.model.Gender
import com.example.core.domain.model.GoalType
import com.example.core.domain.model.UserInfo
import com.example.core.domain.preferences.Preferences

class DefaultPreferences(
    private val sharedPreferences: SharedPreferences
): Preferences {
    override fun saveGender(gender: Gender) {
        sharedPreferences.edit().putString(Preferences.KEY_GENDER, gender.gender).apply()
    }

    override fun saveAge(age: Int) {
        sharedPreferences.edit().putInt(Preferences.KEY_AGE, age).apply()
    }

    override fun saveHeight(height: Int) {
        sharedPreferences.edit().putInt(Preferences.KEY_HEIGHT, height).apply()
    }

    override fun saveWeight(weight: Float) {
        sharedPreferences.edit().putFloat(Preferences.KEY_WEIGHT, weight).apply()
    }

    override fun saveGoalType(goal: GoalType) {
        sharedPreferences.edit().putString(Preferences.KEY_GOALTYPE, goal.goalType).apply()
    }

    override fun saveActivityLevel(activityLevel: ActivityLevel) {
        sharedPreferences.edit().putString(Preferences.KEY_ACTIVITY_LEVEL, activityLevel.activityLevel).apply()
    }

    override fun saveCarbRatio(ratio: Float) {
        sharedPreferences.edit().putFloat(Preferences.KEY_CARB_RATIO, ratio).apply()
    }

    override fun saveProteinRatio(ratio: Float) {
        sharedPreferences.edit().putFloat(Preferences.KEY_PROTEIN_RATIO, ratio).apply()
    }

    override fun saveFatRatio(ratio: Float) {
        sharedPreferences.edit().putFloat(Preferences.KEY_FAT_RATIO, ratio).apply()
    }

    override fun loadUserInfo(): UserInfo {
        val gender = sharedPreferences.getString(Preferences.KEY_GENDER, "female")
        val age = sharedPreferences.getInt(Preferences.KEY_AGE, -1)
        val height = sharedPreferences.getInt(Preferences.KEY_HEIGHT, -1)
        val weight = sharedPreferences.getFloat(Preferences.KEY_WEIGHT, -1f)
        val goalType = sharedPreferences.getString(Preferences.KEY_GOALTYPE, "")
        val activityLevel = sharedPreferences.getString(Preferences.KEY_ACTIVITY_LEVEL, "")
        val carbRatio = sharedPreferences.getFloat(Preferences.KEY_CARB_RATIO, 0f)
        val proteinRatio = sharedPreferences.getFloat(Preferences.KEY_PROTEIN_RATIO, 0f)
        val fatRatio = sharedPreferences.getFloat(Preferences.KEY_FAT_RATIO, 0f)
        return UserInfo(
            gender = Gender.fromString(gender ?: "female"),
            age = age,
            height = height,
            weight = weight,
            goalType = GoalType.fromString(goalType ?: "keep_weight"),
            activityLevel = ActivityLevel.fromString(activityLevel ?: "medium_activity"),
            carbRatio = carbRatio,
            proteinRatio = proteinRatio,
            fatRatio = fatRatio
        )
    }

    override fun saveShouldShowOnboarding(shouldShow: Boolean) {
        sharedPreferences.edit().putBoolean(Preferences.KEY_SHOULD_SHOW_ONBOARDING, shouldShow).apply()
    }

    override fun loadShouldShowOnboarding(): Boolean {
        return sharedPreferences.getBoolean(Preferences.KEY_SHOULD_SHOW_ONBOARDING, true)
    }
}