package com.example.crew.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {CrewEntity.class}, version = 1)
abstract class AppDatabase extends RoomDatabase {
    public abstract UserDao userDao();
}