package com.phuscduowng.lev3;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.phuscduowng.lev3.listener.DictionaryAdapterListener;
import com.squareup.picasso.Picasso;

import java.util.List;

public class FlashcardsAdapter extends PagerAdapter {

    private List<Flashcards> flashcards;
    private LayoutInflater layoutInflater;
    private Context context;

    public FlashcardsAdapter(List<Flashcards> flashcards, Context context) {
        this.flashcards = flashcards;
        this.context = context;
    }

    @Override
    public int getCount() {
        return flashcards.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return view.equals(o);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.flashcards_item, container, false);

        ImageView img;
        TextView word, pronun, mean;

        img = view.findViewById(R.id.imgFlashcards);
        word = view.findViewById(R.id.txtFlashcardsWord);
        pronun = view.findViewById(R.id.txtFlashcardsPronun);
        mean = view.findViewById(R.id.txtFlashcardsMean);

        Picasso.get().load("https://firebasestorage.googleapis.com/v0/b/lev3-usuow.appspot.com/o/flashcards%2F" + flashcards.get(position).getWord() +".jpg?alt=media").into(img);
//        Picasso.get().load("https://firebasestorage.googleapis.com/v0/b/lev3-usuow.appspot.com/o/flashcards%2Fphoto_flashcards.jpg?alt=media").into(img);

        word.setText(flashcards.get(position).getWord());
        pronun.setText(flashcards.get(position).getPronun());
        mean.setText(flashcards.get(position).getMean());

        container.addView(view, 0);

        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }
}
