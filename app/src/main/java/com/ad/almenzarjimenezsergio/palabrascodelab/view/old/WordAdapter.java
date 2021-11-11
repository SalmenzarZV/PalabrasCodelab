package com.ad.almenzarjimenezsergio.palabrascodelab.view.old;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ad.almenzarjimenezsergio.palabrascodelab.R;

//public class WordListAdapter extends ListAdapter<Word, WordViewHolder> {
public class WordAdapter extends RecyclerView.Adapter<WordAdapter.ViewHolder> {
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView wordItemView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            wordItemView = itemView.findViewById(R.id.textView);
        }

        public TextView getWordItemView() {
            return wordItemView;
        }
    }
}
