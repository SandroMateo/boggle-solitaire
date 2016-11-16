package com.example.guest.bogglesolitaire;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class GameActivity extends AppCompatActivity implements View.OnClickListener {
    @Bind(R.id.gameText) TextView mGameText;
    @Bind(R.id.inputText) EditText mInputText;
    @Bind(R.id.addWordButton) Button mAddWordButton;
    @Bind(R.id.finishGameButton) Button mFinishGameButton;
    private String[] mLettersArray;
    private String[] mVowelsArray;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        ButterKnife.bind(this);
        Resources res = getResources();
        mLettersArray = res.getStringArray(R.array.all_letters);
        mVowelsArray = res.getStringArray(R.array.vowels);
        mAddWordButton.setOnClickListener(this);
        mFinishGameButton.setOnClickListener(this);

        String gameLetters = "";
        for(int i = 0; i < 8; i++) {
            int j = (int) Math.floor(Math.random() * 26);
            if(!gameLetters.contains(mLettersArray[j])) {
                gameLetters += mLettersArray[j];
            } else {
                i--;
            }

        }

        mGameText.setText(gameLetters);


    }

    @Override
    public void onClick(View v) {
        if(v == mAddWordButton) {

        } else if(v == mFinishGameButton) {

        }
    }
}
