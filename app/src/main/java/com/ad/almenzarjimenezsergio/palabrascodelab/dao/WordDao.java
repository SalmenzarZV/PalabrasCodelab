package com.ad.almenzarjimenezsergio.palabrascodelab.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.ad.almenzarjimenezsergio.palabrascodelab.model.data.Word;

import java.util.List;

/**
 * DAO - data access object
 *
 * esta interfaz proporciona un objeto mediante el cual voy a poder acceder a la DB
 */
@Dao
public interface WordDao {// -> implementar ROOM

    // allowing the insert of the same word multiple times by passing a
    // conflict resolution strategy
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(Word word);//hebra

    @Query("DELETE FROM word_table")
    void deleteAll();//hebra

    @Query("SELECT * FROM word_table ORDER BY word ASC")
    List<Word> getAlphabetizedWordsOld();//hebra

    @Query("SELECT * FROM word_table ORDER BY word ASC")
    LiveData<List<Word>> getAlphabetizedWords();//hebra principal
}
