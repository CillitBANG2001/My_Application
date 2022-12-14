package com.example.myapplication;

import static android.R.layout.simple_list_item_1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import android.widget.ListView;
import java.util.ArrayList;

public class Classement extends AppCompatActivity {

    ArrayList<String> Joueur;
    static ArrayList<String> Duel = new ArrayList<>();
    private ArrayList<Integer> Score = new ArrayList<>();
    private ArrayList<Integer> DuelIndex = new ArrayList<>();
    private Button nextdebate;
    private ListView Names;
    private ListView Scores;
    ArrayAdapter<Integer> adapterScore;
    ArrayAdapter<String> adapterName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.classement);

        Score = getIntent().getIntegerArrayListExtra("Score"); //Récupération des Scores des joueurs
        Joueur = getIntent().getStringArrayListExtra("Joueurs"); //Récupération de la liste de joueurs saisie dans MainActivity via l'Intent
        DuelIndex = getIntent().getIntegerArrayListExtra("DuelIndex"); //Récupération de l'index des deux joueurs
        Duel = getIntent().getStringArrayListExtra("Duel"); //Récupération des deux joueurs sélectionnés

        Names = (ListView)findViewById(R.id.names);
        Scores = (ListView)findViewById(R.id.scores);
        nextdebate = (Button)findViewById(R.id.nextdebate);

        adapterName = new ArrayAdapter<String>(this,
                simple_list_item_1,  /* android standard layout for a single entry from list: just some text and just a horizontal separator */
                Joueur /* the List<T> contents */);



        adapterScore = new ArrayAdapter<Integer>(this,
                simple_list_item_1,  /* android standard layout for a single entry from list: just some text and just a horizontal separator */
                Score /* the List<T> contents */);


        Names.setAdapter(adapterName);
        Scores.setAdapter(adapterScore);


        nextdebate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent PlayIntent = new Intent(Classement.this, Dual.class);
                PlayIntent.putStringArrayListExtra("Joueurs", Joueur);
                PlayIntent.putIntegerArrayListExtra("Score",Score);
                startActivity(PlayIntent);

            }
        });


    }
}
