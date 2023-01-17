package com.example.finalproject

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class MyDbHelper(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    // Constants for the database version and name
    companion object {
        private const val DATABASE_VERSION = 1
        private const val DATABASE_NAME = "mydatabase.db"
    }

    // Constants for the table and column names
    private val TABLE_NAME = "mytable"
    private val COLUMN_ID = "id"
    private val COLUMN_NAME = "name"
    private val COLUMN_AGE = "age"

    // SQLite create table statement
    private val CREATE_TABLE = "CREATE TABLE $TABLE_NAME ($COLUMN_ID INTEGER PRIMARY KEY AUTOINCREMENT, $COLUMN_NAME TEXT, $COLUMN_AGE INTEGER)"

    // SQLite drop table statement
    private val DROP_TABLE = "DROP TABLE IF EXISTS $TABLE_NAME"

    override fun onCreate(db: SQLiteDatabase) {
        // Execute the SQLite create table statement
        db.execSQL(CREATE_TABLE)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        // Drop the table if it exists and create a new one
        db.execSQL(DROP_TABLE)
        onCreate(db)
    }
}
