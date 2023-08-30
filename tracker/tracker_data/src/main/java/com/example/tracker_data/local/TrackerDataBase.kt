package com.example.tracker_data.local

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [TrackedFoodEntity::class],
    version = 1
)
abstract class TrackerDataBase: RoomDatabase() {

    abstract val dao: TrackerDao
}