package com.vincent.jetpackdemo.db;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Insert;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.vincent.jetpackdemo.dao.WordDao;
import com.vincent.jetpackdemo.entity.EntityWord;


@Database(entities = {EntityWord.class}, version = 1, exportSchema = false)
public abstract class WordDB extends RoomDatabase {

    private static volatile WordDB INSTANCE;

    public static WordDB getWordDB(Context context) {
        //减少锁定的次数
        if (INSTANCE == null) {
            synchronized (WordDB.class) {
                //预防线程先后初始化多次
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(), WordDB.class, "word_db").build();
                }
            }
        }
        return INSTANCE;
    }


    public abstract WordDao getWordDao();
}
