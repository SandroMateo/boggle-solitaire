package com.example.guest.bogglesolitaire;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    @Bind(R.id.mainTitle) TextView mMainTitle;
    @Bind(R.id.newGame) Button mNewGameButton;
    @Bind(R.id.instructions) TextView mInstructions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        Typeface pacificoFont = Typeface.createFromAsset(getAssets(), "fonts/Pacifico.ttf");
        mMainTitle.setTypeface(pacificoFont);

        mNewGameButton.setOnClickListener(this);

        mInstructions.setText(getString(R.string.instructions));
    }

    @Override
    public void onClick(View v) {
        if(v == mNewGameButton) {
            Intent intent = new Intent(MainActivity.this, GameActivity.class);
            startActivity(intent);
        }
    }
}
