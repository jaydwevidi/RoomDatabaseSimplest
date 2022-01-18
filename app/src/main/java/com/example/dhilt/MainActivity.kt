package com.example.dhilt

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.lifecycleScope
import androidx.room.Room
import com.example.dhilt.db.Person
import com.example.dhilt.db.PersonDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val TAG = "OnCreate : "
        val db = PersonDatabase.getInstance(applicationContext)

        lifecycleScope.launch(Dispatchers.IO){
            val dao = db.personDao()
            dao.addPeron(Person(1 , "Jim Gordon"))
            dao.addPeron(Person(2 , "Talia Al Ghul"))
            dao.addPeron(Person(3 , "Barbra Gordon"))
            val personList  = dao.getAll()
            Log.e(TAG, "\n$personList")
        }

    }
}