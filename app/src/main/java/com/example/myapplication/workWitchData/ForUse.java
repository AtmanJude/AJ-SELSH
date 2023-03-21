package com.example.myapplication.workWitchData;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = Memories.class, version = 1)
public abstract class ForUse extends RoomDatabase {
    public abstract MemoriesDAO memoriesDAO();
}
