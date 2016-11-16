package com.example.guest.bogglesolitaire;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

import butterknife.Bind;

public class ResultsActivity extends AppCompatActivity {
    @Bind(R.id.wordsOutput) TextView mWordsOutput;
    @Bind(R.id.resultsTitle) TextView mResultsTitle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        Intent intent = getIntent();
        ArrayList mInputWords = intent.getStringArrayListExtra("inputArray");

        for (Object word: mInputWords) {
            String stringWord = word.toString();
            mWordsOutput.append(stringWord);
        }
    }
}
