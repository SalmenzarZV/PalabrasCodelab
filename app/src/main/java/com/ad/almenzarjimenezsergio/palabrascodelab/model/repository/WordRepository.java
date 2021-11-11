package com.ad.almenzarjimenezsergio.palabrascodelab.model.repository;

import android.app.Application;
import android.content.Context;

import androidx.lifecycle.LiveData;

import com.ad.almenzarjimenezsergio.palabrascodelab.dao.WordDao;
import com.ad.almenzarjimenezsergio.palabrascodelab.model.data.Word;
import com.ad.almenzarjimenezsergio.palabrascodelab.model.database.WordRoomDatabase;

import java.util.List;

public class WordRepository {

    private WordDao mWordDao;
    private LiveData<List<Word>> mAllWords;

    // Note that in order to unit test the WordRepository, you have to remove the Application
    // dependency. This adds complexity and much more code, and this sample is not about testing.
    // See the BasicSample in the android-architecture-components repository at
    // https://github.com/googlesamples

    public WordRepository(Context context){
        /*
        WordRoomDatabase db = WordRoomDatabase.getDatabase(context.getApplicationContext());
        mWordDao = db.wordDao();
        mAllWords = mWordDao.getAlphabetizedWords();
         */
        this((Application) context.getApplicationContext());
    }
    //SE PUEDE TANTO CON EL CONTEXTO COMO CON LA APLICACION
    public WordRepository(Application application) {
        WordRoomDatabase db = WordRoomDatabase.getDatabase(application);
        mWordDao = db.wordDao();
        mAllWords = mWordDao.getAlphabetizedWords();
    }

    public void cleanTable(){
        WordRoomDatabase.databaseWriteExecutor.execute(() -> {
            mWordDao.deleteAll();
        });
    }

    // Room executes all queries on a separate thread.
    // Observed LiveData will notify the observer when the data has changed.
    public LiveData<List<Word>> getAllWords() {
        return mAllWords;
    }

    // You must call this on a non-UI thread or your app will throw an exception. Room ensures
    // that you're not doing any long running operations on the main thread, blocking the UI.
    public void insert(Word word) {
        WordRoomDatabase.databaseWriteExecutor.execute(() -> {
            try{
                Thread.sleep(2300 + (int)(Math.random() * 3000));
            }catch (InterruptedException ie){

            }
            mWordDao.insert(word);
        });
        /*
        Thread thread = new Thread() {
            @Override
            public void run(){
                try{
                    Thread.sleep(2300 + (int)(Math.random() * 3000));
                }catch (InterruptedException ie){

                }
                mWordDao.insert(word);
            }
        };
        thread.start();
         */
    }

    public void littleInsert(){
            Word word = new Word("Hello");
            insert(word);
            word = new Word("World");
            insert(word);
    }


}


