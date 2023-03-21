package com.example.myapplication.workWitchData;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity (tableName = "memories")
public class Memories {
    @PrimaryKey(autoGenerate = true)
    private int id;
    @ColumnInfo
    private String date;
    private int hasPassed;


    public Memories(String date, int hasPassed) {
        this.date = date;
        this.hasPassed = hasPassed;
    }

    public Memories(int id, String date, int hasPassed) {
        this.id = id;
        this.date = date;
        this.hasPassed = hasPassed;
    }

    public int getId() {
        return id;
    }

    public String getDate() {
        return date;
    }

    public int getHasPassed() {
        return hasPassed;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setHasPassed(int hasPassed) {
        this.hasPassed = hasPassed;
    }
}
