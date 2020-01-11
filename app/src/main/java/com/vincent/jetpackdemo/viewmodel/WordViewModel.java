package com.vincent.jetpackdemo.viewmodel;

import android.app.Application;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.vincent.jetpackdemo.dao.WordDao;
import com.vincent.jetpackdemo.db.WordDB;
import com.vincent.jetpackdemo.entity.EntityWord;
import com.vincent.jetpackdemo.repository.WordRepository;

import java.util.List;

public class WordViewModel extends AndroidViewModel {

    private LiveData<List<EntityWord>> listLiveData = new MutableLiveData<>();

    private WordRepository wordRepository;

    public WordViewModel(@NonNull Application application) {
        super(application);
        wordRepository = new WordRepository(application);
    }

    public LiveData<List<EntityWord>> getListLiveData() {
        return listLiveData = wordRepository.getWordLiveList();
    }

    public void setListLiveData(LiveData<List<EntityWord>> listLiveData) {
        this.listLiveData = listLiveData;
    }


    public void deleteAllWords() {
        wordRepository.deleteAllWords();
    }

    public void insertWords(EntityWord... words) {
        wordRepository.insertWords(words);
    }
}
