package com.example.guest.bogglesolitaire;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

public class ResultsActivity extends AppCompatActivity {
    @Bind(R.id.wordsOutput) TextView mWordsOutput;
    @Bind(R.id.resultsTitle) TextView mResultsTitle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);
        ButterKnife.bind(this);

        Intent intent = getIntent();
        ArrayList mInputArray = intent.getStringArrayListExtra("inputArray");

//        for (Object word: mInputArray) {
//            String stringWord = word.toString();
//            mWordsOutput.append(stringWord);
//        }
        for(int i = 0; i < mInputArray.size(); i++) {
            mWordsOutput.append(i + "." + mInputArray.get(i).toString() + "   ");
        }
    }
}
