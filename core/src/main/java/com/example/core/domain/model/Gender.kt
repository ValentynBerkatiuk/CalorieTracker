package com.example.core.domain.model

sealed class Gender(val gender: String) {
    object Male: Gender("Male")
    object Female: Gender("Female")

    companion object {

        fun fromString(name: String): Gender {
            return when(name) {
                "male" -> Male
                "female" -> Female
                else -> Female
            }
        }
    }
}
