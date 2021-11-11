package com.ad.almenzarjimenezsergio.palabrascodelab.model.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.ad.almenzarjimenezsergio.palabrascodelab.model.data.Word;
import com.ad.almenzarjimenezsergio.palabrascodelab.dao.WordDao;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {Word.class}, version = 1, exportSchema = false)
public abstract class WordRoomDatabase extends RoomDatabase{
    public abstract WordDao wordDao();//metodo abstracto que hay que implementar

    private static volatile WordRoomDatabase INSTANCE;  //volatile -> hilo, hebra || asegura que al estar varias hebras asignandole un valor, coja el ultimo valor asignado
    //Aunque no sea una final quieren que sea una constante pero no le ponen final porque no hay manera
    //de asignarle un valor a posteriori y tiene que ser asi


    private static final int NUMBER_OF_THREADS = Runtime.getRuntime().availableProcessors();//NUMERO DE CORES DEL DISPOSITIVO
    public static final ExecutorService databaseWriteExecutor =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);
    Thread databaseWriteThread;

    /**
     *
     * @param context
     * @return
     */
    public static WordRoomDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (WordRoomDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            WordRoomDatabase.class, "word_database")
                            .build();
                }
            }
        }
        return INSTANCE;
    }

    //OTRA MANERA MAS SENCILLA DEL DE ARRIBA
    static WordRoomDatabase getWordDatabase(Context context){
        if(INSTANCE == null){
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                    WordRoomDatabase.class, "word_database")
                    .build();
        }

        return INSTANCE;
    }
}
