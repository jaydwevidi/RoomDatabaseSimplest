package com.example.dhilt.db

import androidx.room.*

@Dao
interface PersoDao {
    @Query("SELECT * FROM person" )
    fun getAll() : List<Person>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    //@Insert(onConflict = OnConflictStrategy.IGNORE)
    fun addPeron(person : Person)

    @Delete
    fun deletePerson(perso : Person)
}