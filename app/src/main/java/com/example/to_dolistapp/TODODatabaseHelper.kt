package com.example.to_dolistapp

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class TODODatabaseHelper(context: Context) : SQLiteOpenHelper(context,DATABASE_NAME,null,
    DATABASE_VERSION){

    companion object{
        private const val DATABASE_NAME = "todoapp.dp"
        private const val DATABASE_VERSION = "1"
        private const val TABLE_NAME = "alltodo"
        private const val COLUMN_ID = "id"
        private const val COLUMN_TITLE = "title"
        private const val COLUMN_CONTENT= "content"


    }

    override fun onCreate(db: SQLiteDatabase?) {
       val createTableQuery = "CREATE TABLE $TABLE_NAME ($COLUMN_ID INTEGER PRIMARY KEY, $COLUMN_TITLE TEXT, $COLUMN_CONTENT TEXT)"
        db?.execSQL(createTableQuery)

    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
       val dropTableQuery = " DROP TABLE IF EXISTS $TABLE_NAME"
        db?.execSQL(dropTableQuery)
        onCreate(db)

    }
}