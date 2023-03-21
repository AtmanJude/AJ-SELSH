package com.example.myapplication.workWitchData;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface MemoriesDAO
{
    @Query("SELECT * FROM memories")
    List<Memories> getAll();

    @Query("SELECT * FROM memories WHERE id = :id")
    Memories getById(long id);

    @Insert
    void insert(Memories memories);

    @Update
    void update(Memories memories);

    @Delete
    void delete(Memories memories);
}
