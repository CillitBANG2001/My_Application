package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class WinLose extends AppCompatActivity {

    ArrayList<String> Joueur;
    static ArrayList<String> Duel = new ArrayList<>();
    private ArrayList<Integer> Score = new ArrayList<>();
    private ArrayList<Integer> DuelIndex = new ArrayList<>();
    private Button player1;
    private Button player2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.winlose);

        Score = getIntent().getIntegerArrayListExtra("Score"); //Récupération des Scores des joueurs
        Joueur = getIntent().getStringArrayListExtra("Joueurs"); //Récupération de la liste de joueurs saisie dans MainActivity via l'Intent
        DuelIndex = getIntent().getIntegerArrayListExtra("DuelIndex"); //Récupération de l'index des deux joueurs
        Duel = getIntent().getStringArrayListExtra("Duel"); //Récupération des deux joueurs sélectionnés

        player1 = findViewById(R.id.winner1);
        player2 = findViewById(R.id.winner2);

        player1.setText(Duel.get(0));
        player2.setText(Duel.get(1));

        player1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int Score1 = Score.get(DuelIndex.get(0));
                Score.set(DuelIndex.get(0), Score1 + 100);

                Intent PlayIntent = new Intent(WinLose.this, Classement.class);
                PlayIntent.putStringArrayListExtra("Joueurs", Joueur);
                PlayIntent.putStringArrayListExtra("Duel", Duel);
                PlayIntent.putIntegerArrayListExtra("Score",Score);

                startActivity(PlayIntent);

            }
            });

        player2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int Score2 = Score.get(DuelIndex.get(1));
                Score.set(DuelIndex.get(1), Score2 + 100);

                Intent PlayIntent = new Intent(WinLose.this, Classement.class);
                PlayIntent.putStringArrayListExtra("Joueurs", Joueur);
                PlayIntent.putStringArrayListExtra("Duel", Duel);
                PlayIntent.putIntegerArrayListExtra("Score",Score);
                startActivity(PlayIntent);

            }
        });

    }

    }