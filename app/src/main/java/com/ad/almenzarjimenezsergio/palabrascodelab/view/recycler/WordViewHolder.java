package com.ad.almenzarjimenezsergio.palabrascodelab.view.recycler;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ad.almenzarjimenezsergio.palabrascodelab.R;

public class WordViewHolder extends RecyclerView.ViewHolder {

    private TextView wordItemView;

    public WordViewHolder(@NonNull View itemView) {
        super(itemView);
        wordItemView = itemView.findViewById(R.id.textView);
    }

    public TextView getWordItemView() {
        return wordItemView;
    }

}
