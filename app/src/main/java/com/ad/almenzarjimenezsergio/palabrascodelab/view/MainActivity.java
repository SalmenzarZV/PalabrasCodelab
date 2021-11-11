package com.ad.almenzarjimenezsergio.palabrascodelab.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;


import com.ad.almenzarjimenezsergio.palabrascodelab.R;
import com.ad.almenzarjimenezsergio.palabrascodelab.model.data.Word;
import com.ad.almenzarjimenezsergio.palabrascodelab.view.recycler.WordAdapter;
import com.ad.almenzarjimenezsergio.palabrascodelab.viewmodel.WordViewModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = "jamaica";
    public static final int NEW_WORD_ACTIVITY_REQUEST_CODE = 1;
    private WordViewModel mWordViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialize();
    }

    private void initialize() {
        Log.v(TAG, "initialize");
        mWordViewModel = new ViewModelProvider(this).get(WordViewModel.class);
        WordAdapter wordAdapter = new WordAdapter(null);
        mWordViewModel.getAllWords().observe(this, words -> {
            wordAdapter.update(words);
        });

        RecyclerView recyclerView = findViewById(R.id.recyclerView);

        recyclerView.setAdapter(wordAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener( view -> {
            Intent intent = new Intent(MainActivity.this, NewWordActivity.class);
            startActivityForResult(intent, NEW_WORD_ACTIVITY_REQUEST_CODE);
        });
        //mWordViewModel.littleInsert(); HACER LUEGO PARA INSERTAR LAS PALABRAS
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == NEW_WORD_ACTIVITY_REQUEST_CODE && resultCode == RESULT_OK) {
            Word word = new Word(data.getStringExtra("word"));
            mWordViewModel.insert(word);
        } else {
            Toast.makeText(
                    getApplicationContext(),
                    R.string.empty_not_saved,
                    Toast.LENGTH_LONG).show();
        }
    }



}