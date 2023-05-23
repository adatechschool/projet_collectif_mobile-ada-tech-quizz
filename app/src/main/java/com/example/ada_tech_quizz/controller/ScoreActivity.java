package com.example.ada_tech_quizz.controller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ada_tech_quizz.R;
import com.example.ada_tech_quizz.model.Player;

public class ScoreActivity extends AppCompatActivity {

    private TextView mCongratsTextView, mPlayerScoreTextView;

    private Button mPlayAgainButton;

    private Player mPlayer = new Player();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);

        mCongratsTextView = findViewById(R.id.score_textview_congrats);
        mPlayerScoreTextView = findViewById(R.id.score_textview_playerScore);
        mPlayAgainButton = findViewById(R.id.score_button_playAgain);

        // getting the player's name and score from the previous activity (which launched the intent)
        Intent intent = getIntent();
        mPlayer.setFirstName(intent.getStringExtra("name_key"));
        mPlayer.setScore(intent.getIntExtra("score_key",0));


        //Toast.makeText(this, mPlayer.getFirstName() + mPlayer.getScore(), Toast.LENGTH_LONG).show() ;

        // Displays the player's name and score
        mCongratsTextView.setText("BRAVO " + mPlayer.getFirstName());
        mPlayerScoreTextView.setText(Integer.toString(mPlayer.getScore()) + "/10");


        // On click on "play again": restart the game (from GameActivity.class)
        mPlayAgainButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gameActivityIntent = new Intent(ScoreActivity.this, GameActivity.class);
                gameActivityIntent.putExtra("name_key", mPlayer.getFirstName());
                startActivity(gameActivityIntent);
            }
        });

    }
}