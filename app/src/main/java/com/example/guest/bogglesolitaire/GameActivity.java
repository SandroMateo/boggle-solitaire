package com.example.guest.bogglesolitaire;

import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class GameActivity extends AppCompatActivity implements View.OnClickListener {
    @Bind(R.id.gameText) TextView mGameText;
    @Bind(R.id.inputText) EditText mInputText;
    @Bind(R.id.addWordButton) Button mAddWordButton;
    @Bind(R.id.finishGameButton) Button mFinishGameButton;
    private String gameLetters;
    private String[] mLettersArray;
    private String[] mVowelsArray;
    private ArrayList mInputArray;

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
        mInputArray = new ArrayList();

        gameLetters = generateGame();
        mGameText.setText(gameLetters);


    }

    @Override
    public void onClick(View v) {
        if(v == mAddWordButton) {
            String inputWord = mInputText.getText().toString().toUpperCase();
            if(checkWord(inputWord, gameLetters)) {
                mInputArray.add(inputWord);
                Toast.makeText(GameActivity.this, "Nice Word!", Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(GameActivity.this, "Invalid Word!", Toast.LENGTH_LONG).show();
            }
            mInputText.setText("");
        } else if(v == mFinishGameButton) {
            Intent intent = new Intent(GameActivity.this, ResultsActivity.class);
            intent.putStringArrayListExtra("inputArray", mInputArray);
            startActivity(intent);
        }
    }

    public boolean checkWord(String word, String letters) {
        int letterCount = 0;
        String[] charLetters = letters.split("");
        for(int i = 0; i < charLetters.length; i++) {
            if(word.contains(charLetters[i])) {
                letterCount++;
            }
        }
        if(letterCount > 2) {
            if(checkVowels(word) > 0) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public String generateGame() {
        String possibleLetters = generateGameLetters();
        while(checkVowels(possibleLetters) < 2) {
            possibleLetters = generateGameLetters();
        }
        return possibleLetters;
    }

    public String generateGameLetters() {
        String gameLetters = "";
        for(int i = 0; i < 8; i++) {
            int j = (int) Math.floor(Math.random() * 26);
            if(!gameLetters.contains(mLettersArray[j])) {
                gameLetters += mLettersArray[j];
            } else {
                i--;
            }
        }
        return gameLetters;
    }

    public int checkVowels(String letters) {
        int vowelCount = 0;
        for(int i = 0; i < mVowelsArray.length; i++) {
            if(letters.contains(mVowelsArray[i])) {
                vowelCount++;
            }
        }
        return vowelCount;
    }
}
