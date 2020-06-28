package com.example.payo

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [UserDetail::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
}