package com.example.dhilt.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(entities = [Person::class] , version = 1)
abstract class PersonDatabase: RoomDatabase(){

    abstract fun personDao() : PersoDao

    companion object {
        private var instance: PersonDatabase? = null

        @Synchronized
        fun getInstance(ctx: Context): PersonDatabase {
            if (instance == null)
                instance = Room.databaseBuilder(
                    ctx, PersonDatabase::class.java,
                    "person-database"
                ).fallbackToDestructiveMigration().build()


            return instance!!

        }
    }

}