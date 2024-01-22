package com.example.tracker_presentation.tracker_overview.components

import androidx.compose.animation.core.animateIntAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.DropdownMenu
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.calorietracker.R
import com.example.core_ui.CarbColor
import com.example.core_ui.FatColor
import com.example.core_ui.LocalSpacing
import com.example.core_ui.ProteinColor
import com.example.tracker_presentation.components.UnitDisplay
import com.example.tracker_presentation.tracker_overview.TrackerOverviewEvent
import com.example.tracker_presentation.tracker_overview.TrackerOverviewState
import com.example.tracker_presentation.tracker_overview.TrackerOverviewViewModel

@Composable
fun NutrientsHeader(
    viewModel: TrackerOverviewViewModel,
    modifier:Modifier = Modifier
) {
    val state = viewModel.state
    val spacing = LocalSpacing.current
    val animatedCalorieCount = animateIntAsState(targetValue = state.totalCalories)
    Column(
        modifier = modifier
            .fillMaxWidth()
            .clip(
                RoundedCornerShape(
                    bottomEnd = 60.dp,
                    bottomStart = 60.dp
                )
            )
            .background(MaterialTheme.colors.primary)
            .padding(horizontal = spacing.spaceMoreMedium)
    ) {
        IconButton(
            onClick = {
                viewModel.onEvent(TrackerOverviewEvent.onMenuExposed)
            },
            modifier = Modifier.padding(top = 14.dp)
        ) {
            Icon(
                Icons.Filled.Menu,
                contentDescription = "Settings",
                tint = Color.White
            )
        }
        DropdownMenu(
            expanded = state.isMenuExposed,
            onDismissRequest = {
                viewModel.onEvent(TrackerOverviewEvent.onMenuExposed)
            }) {
            DropdownMenuItem(
                onClick = { /* Handle settings! */
                }) {
                Text("Settings")
            }
        }
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            UnitDisplay(
                amount = animatedCalorieCount.value,
                unit = stringResource(id = R.string.kcal),
                amountTextColor = MaterialTheme.colors.onPrimary,
                amountTextSize = 36.sp,
                unitColor = MaterialTheme.colors.onPrimary,
                modifier = Modifier.align(Alignment.Bottom)
            )
            Column {
                Text(
                    text = stringResource(id = R.string.your_goal),
                    style = MaterialTheme.typography.body2,
                    color = MaterialTheme.colors.onPrimary
                )
                UnitDisplay(
                    amount = viewModel.state.caloriesGoal,
                    unit = stringResource(id = R.string.kcal),
                    amountTextColor = MaterialTheme.colors.onPrimary,
                    amountTextSize = 36.sp,
                    unitColor = MaterialTheme.colors.onPrimary,
                )
            }
        }
        Spacer(modifier = Modifier.height(spacing.spaceSmall))
        TrackerBar(
            carbs = state.totalCarbs,
            protein = state.totalProtein,
            fat = state.totalFat,
            calories = state.totalCalories,
            calorieGoal = state.caloriesGoal,
            modifier
                .fillMaxWidth()
                .height(30.dp)
        )
        Spacer(modifier = Modifier.height(spacing.spaceLarge))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            TrackerBarInfo(
                value = state.totalCarbs,
                goal = state.carbsGoal,
                name = stringResource(id = R.string.carbs),
                color = CarbColor,
                modifier = Modifier.size(90.dp)
            )
            TrackerBarInfo(
                value = state.totalProtein,
                goal = state.proteinGoal,
                name = stringResource(id = R.string.protein),
                color = ProteinColor,
                modifier = Modifier.size(90.dp)
            )
            TrackerBarInfo(
                value = state.totalFat,
                goal = state.fatGoal,
                name = stringResource(id = R.string.fat),
                color = FatColor,
                modifier = Modifier.size(90.dp)
            )
        }
        Spacer(modifier = modifier.height(spacing.spaceLarge))
    }
}