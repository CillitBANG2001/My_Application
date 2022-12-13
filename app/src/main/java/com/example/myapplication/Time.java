package com.example.myapplication;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Random;


public class Time extends AppCompatActivity {

    ArrayList<String> Joueur;
    static ArrayList<String> Duel = new ArrayList<>();
    TextView Question;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.timer);

        TextView player1 = (TextView)findViewById(R.id.player1);
        TextView player2 = (TextView)findViewById(R.id.player2);
        Question = (TextView) findViewById(R.id.question);

        Joueur = getIntent().getStringArrayListExtra("Joueurs"); //Récupération de la liste de joueurs saisie dans MainActivity via l'Intent

        Duel = getIntent().getStringArrayListExtra("Duel"); //Récupération des deux joueurs sélectionnés
        Question.setText(getRandomQuestion());
        player1.setText(Duel.get(0));  //Affichage des duellistes dans le layout
        player2.setText(Duel.get(1));
    }


    public String getRandomQuestion(){ //Fonction retournant une question au hasard


        String[] myResArray = getResources().getStringArray(R.array.questions);


        Random random1 = new Random(); //Initalisation du randomizer
        int index1 = random1.nextInt(myResArray.length); //Selection d'un index aléatoire du tableau de questions
        String question = myResArray[index1]; //Ajout du nom aléatoirement sélectionner dans la liste de return.

        return question;
    }


}

