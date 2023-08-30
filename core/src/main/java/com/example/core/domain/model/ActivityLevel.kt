package com.example.core.domain.model

sealed class ActivityLevel(val activityLevel: String) {
    object Low: ActivityLevel("low_activity")
    object Medium: ActivityLevel("medium_activity")
    object High: ActivityLevel("high_activity")

    companion object {

        fun fromString(goalType: String): ActivityLevel {
            return when(goalType) {
                "low_activity" -> Low
                "medium_activity" -> Medium
                "high_activity" -> High
                else -> Medium
            }
        }
    }
}

