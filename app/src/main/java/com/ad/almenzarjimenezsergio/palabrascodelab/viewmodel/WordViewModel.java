package com.ad.almenzarjimenezsergio.palabrascodelab.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.ad.almenzarjimenezsergio.palabrascodelab.model.data.Word;
import com.ad.almenzarjimenezsergio.palabrascodelab.model.repository.WordRepository;

import java.util.List;

public class WordViewModel extends AndroidViewModel {

    private final WordRepository mRepository;

    private final LiveData<List<Word>> mAllWords;

    public WordViewModel(@NonNull Application application) {
        super(application);
        mRepository = new WordRepository(application);
        mAllWords = mRepository.getAllWords();
    }

     public LiveData<List<Word>> getAllWords() {
        return mAllWords;
    }

    public void insert(Word word) {
        mRepository.insert(word);
    }

    public  void littleInsert(){
        mRepository.littleInsert();
    }

    public void cleanTable() {
        mRepository.cleanTable();
    }
}
