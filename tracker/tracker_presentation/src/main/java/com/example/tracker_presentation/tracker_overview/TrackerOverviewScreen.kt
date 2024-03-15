package com.example.tracker_presentation.tracker_overview

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.calorietracker.R
import com.example.core_ui.LocalSpacing
import com.example.tracker_presentation.tracker_overview.components.AddButton
import com.example.tracker_presentation.tracker_overview.components.DaySelector
import com.example.tracker_presentation.tracker_overview.components.ExpandableMeal
import com.example.tracker_presentation.tracker_overview.components.NutrientsHeader
import com.example.tracker_presentation.tracker_overview.components.ThemeSwitcher
import com.example.tracker_presentation.tracker_overview.components.TrackedFoodItem

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TrackerOverviewScreen(
    darkTheme: Boolean,
    onThemeUpdated: () -> Unit,
    onNavigateToSearch: (String, Int, Int, Int) -> Unit,
    onCreateNewReceipt: () -> Unit,
    viewModel: TrackerOverviewViewModel = hiltViewModel(),
) {
    val spacing = LocalSpacing.current
    val state = viewModel.state
    val context = LocalContext.current
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()

    Scaffold(
        topBar = {
            TopAppBar(
                title = { },
                actions = {
                    ThemeSwitcher(
                        darkTheme = darkTheme,
                        size = 26.dp,
                        padding = 2.dp,
                        onClick = onThemeUpdated
                    )
                    Spacer(modifier = Modifier.width(16.dp))
                },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    titleContentColor = MaterialTheme.colorScheme.primary,
                    scrolledContainerColor = MaterialTheme.colorScheme.primary
                ),
                scrollBehavior = scrollBehavior
            )
        },
        bottomBar = {
                Row(
                    horizontalArrangement = Arrangement.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color.Transparent)
                ) {
                    AddButton(
                        text = "add receipt",
                        onClick = {
                            onCreateNewReceipt()
                        },
                        modifier = Modifier
                            .height(60.dp)
                            .width(180.dp)
                    )
                }
        },
        modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection)
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            item {
                NutrientsHeader(state)
                Spacer(modifier = Modifier.height(spacing.spaceSmall))
                DaySelector(
                    date = state.date,
                    onPreviousDayClick = {
                        viewModel.onEvent(TrackerOverviewEvent.OnPreviousDayClick)
                    },
                    onNextDayClick = {
                        viewModel.onEvent(TrackerOverviewEvent.OnNextDayClick)
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = spacing.spaceSmall)
                )
                Spacer(modifier = Modifier.height(spacing.spaceMedium))
            }
            items(state.meals) { meal ->
                ExpandableMeal(
                    meal = meal,
                    onToggleClick = {
                        viewModel.onEvent(TrackerOverviewEvent.OnToggleMealClick(meal))
                    },
                    content = {
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = spacing.spaceExtraSmall)
                        ) {
                            val foods = state.trackedFoods.filter {
                                it.mealType == meal.mealType
                            }
                            foods.forEach { food ->
                                TrackedFoodItem(
                                    trackedFood = food,
                                    onDeleteClick = {
                                        viewModel.onEvent(
                                            TrackerOverviewEvent
                                                .OnDeleteFoodClick(food)
                                        )
                                    }
                                )
                                Spacer(modifier = Modifier.height(spacing.spaceSmall))
                            }
                            AddButton(
                                text = stringResource(
                                    id = R.string.add_meal,
                                    meal.name.asString(context)
                                ),
                                onClick = {
                                    onNavigateToSearch(
                                        meal.name.asString(context),
                                        state.date.dayOfMonth,
                                        state.date.monthValue,
                                        state.date.year
                                    )
                                },
                                modifier = Modifier.fillMaxWidth()
                            )
                        }
                    },
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }
    }

}