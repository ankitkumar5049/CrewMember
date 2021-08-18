package com.example.crew.database;

import androidx.room.ColumnInfo;
import androidx.room.PrimaryKey;

@androidx.room.Entity(tableName = "crew")
public class CrewEntity {
    @ColumnInfo(name = "name")
    public String name;

    @ColumnInfo(name = "agency")
    public String agency;

    @ColumnInfo(name = "image")
    public String image;

    @ColumnInfo(name = "wikipedia")
    public String wikipedia;

    @ColumnInfo(name = "launches")
    public String launches;

    @ColumnInfo(name = "status")
    public String status;

    @PrimaryKey
    public int id;
}
