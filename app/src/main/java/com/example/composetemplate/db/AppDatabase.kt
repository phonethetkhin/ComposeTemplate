package com.example.composetemplate.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.composetemplate.db.daos.UserDao
import com.example.composetemplate.db.entities.UserEntity

@Database(entities = [UserEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
}
