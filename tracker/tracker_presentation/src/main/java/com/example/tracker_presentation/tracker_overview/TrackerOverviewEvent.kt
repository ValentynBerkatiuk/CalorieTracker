package com.example.tracker_presentation.tracker_overview

import com.example.tracker_domain.model.TrackedFood

sealed class TrackerOverviewEvent {
    object onPreviousDayClick: TrackerOverviewEvent()
    object onNextDayClick: TrackerOverviewEvent()
    data class onToggleMealClick(val meal: Meal): TrackerOverviewEvent()
    data class onAddFoodClick(val meal: Meal): TrackerOverviewEvent()
    data class onDeleteFoodClick(val trackedFood: TrackedFood): TrackerOverviewEvent()
}
