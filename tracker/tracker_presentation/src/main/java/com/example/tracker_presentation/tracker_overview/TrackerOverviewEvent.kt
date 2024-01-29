package com.example.tracker_presentation.tracker_overview

import com.example.tracker_domain.model.TrackedFood

sealed class TrackerOverviewEvent {
    object OnMenuExposed: TrackerOverviewEvent()
    object OnPreviousDayClick: TrackerOverviewEvent()
    object OnNextDayClick: TrackerOverviewEvent()
    data class OnToggleMealClick(val meal: Meal): TrackerOverviewEvent()
    data class OnDeleteFoodClick(val trackedFood: TrackedFood): TrackerOverviewEvent()
}
