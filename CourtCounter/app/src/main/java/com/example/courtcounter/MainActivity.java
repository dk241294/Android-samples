package com.example.courtcounter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    int scoreTeamA=0;
    int scoreTeamB=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        displayForTeamA(0);

    }
    public void threePointToA(View view){
        scoreTeamA +=3;
        displayForTeamA(scoreTeamA);
    }
    public void twoPointToA(View view){
        scoreTeamA +=2;
        displayForTeamA(scoreTeamA);
    }
    public void freePointToA(View view){
        scoreTeamA +=1;
        displayForTeamA(scoreTeamA);
    }
        /**
         * Displays the given score for Team A.
         */
        public void displayForTeamA(int score) {
            TextView scoreView = (TextView) findViewById(R.id.team_a_score);
            scoreView.setText(String.valueOf(score));
        }
    public void threePointToB(View view){
        scoreTeamB +=3;
        displayForTeamB(scoreTeamB);
    }
    public void twoPointToB(View view){
        scoreTeamB +=2;
        displayForTeamB(scoreTeamB);
    }
    public void freePointToB(View view){
        scoreTeamB +=1;
        displayForTeamB(scoreTeamB);
    }
    /**
     * Displays the given score for Team A.
     */
    public void resetScore(View view){
        scoreTeamA=0;
        scoreTeamB=0;
        displayForTeamA(scoreTeamA);
        displayForTeamB(scoreTeamB);
    }
    public void displayForTeamB(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_b_score);
        scoreView.setText(String.valueOf(score));
    }

    }

