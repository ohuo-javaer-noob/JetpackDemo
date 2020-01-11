package com.vincent.jetpackdemo.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Entity;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.vincent.jetpackdemo.entity.EntityWord;

import java.util.List;

/**
 * ====================================================================<br>
 * <p>@description: todo:说明</p>
 * <p>@time:  2020-01-11 10:26</p>
 * <p>@author: Vin Aran</p>
 * ====================================================================<br>
 */
@Dao
public interface WordDao {
    @Insert
    void insertWords(EntityWord... words);

    @Update
    void updateWords(EntityWord... words);

    @Delete
    void deleteWords(EntityWord... words);

    @Query("delete from word")
    void deleteAllWords();

    @Query("select * from word order by id desc")
    LiveData<List<EntityWord>> getAllWords();
}
