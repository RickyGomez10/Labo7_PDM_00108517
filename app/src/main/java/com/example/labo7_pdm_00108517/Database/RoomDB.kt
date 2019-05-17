package com.example.labo7_pdm_00108517.Database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [GithubRepo::class], version = 1, exportSchema = false)
abstract class RoomDB : RoomDatabase() {

    abstract fun repoDao(): GithubDAO

    companion object {
        private var INSTANCE: RoomDB? = null

        fun getInstance(context : Context): RoomDB{
            val tempInstance = INSTANCE
            if(tempInstance != null) return tempInstance
            synchronized(this){
                val instance = Room.databaseBuilder(context, RoomDB::class.java, "RepoDB").build()
                INSTANCE = instance
                return instance
            }
        }
    }
}