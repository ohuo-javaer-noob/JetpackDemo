package com.vincent.jetpackdemo.repository;

import android.content.Context;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.vincent.jetpackdemo.dao.WordDao;
import com.vincent.jetpackdemo.db.WordDB;
import com.vincent.jetpackdemo.entity.EntityWord;

import java.util.List;

public class WordRepository {
    private LiveData<List<EntityWord>> wordLiveList;


    public LiveData<List<EntityWord>> getWordLiveList() {
        return wordLiveList;
    }


    private static WordDao wordDao;

    public WordRepository(Context context) {
        wordDao = WordDB.getWordDB(context.getApplicationContext()).getWordDao();
        wordLiveList = wordDao.getAllWords();
    }

    public void insertWords(EntityWord... words) {
        new InsertAsynchTask().execute(words);
    }

    public void deleteAllWords() {
        new DelelteAsynchTask().execute(new Void[0]);
    }

    private static class InsertAsynchTask extends AsyncTask<EntityWord, Void, Void> {

        @Override
        protected Void doInBackground(EntityWord... words) {
            wordDao.insertWords(words);
            return null;
        }
    }


    private static class DelelteAsynchTask extends AsyncTask<Void, Void, Void> {


        @Override
        protected Void doInBackground(Void... wordDaos) {
            wordDao.deleteAllWords();
            return null;
        }
    }
}
