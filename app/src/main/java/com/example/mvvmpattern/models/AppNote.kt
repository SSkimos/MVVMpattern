package com.example.mvvmpattern.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "note_tables")
data class AppNote(
        //data-классы - специальные классы в kotlin,
        //которые позволяют работать с объектами как с данными
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    @ColumnInfo val name: String = "",
    @ColumnInfo val text: String = ""
)