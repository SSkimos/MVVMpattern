package com.example.mvvmpattern.utilits

import com.example.mvvmpattern.MainActivity
import com.example.mvvmpattern.database.DatabaseRepository

lateinit var APP_ACTIVITY: MainActivity
lateinit var REPOSITORY: DatabaseRepository
const val TYPE_DATABASE = "type_database"
const val TYPE_ROOM = "type_room"