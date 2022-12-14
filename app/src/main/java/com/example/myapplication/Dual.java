package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Button;
import android.widget.AdapterView;
import java.util.ArrayList;
import java.util.Random;
import java.util.Timer;
import android.widget.TextView;
import android.view.View.OnClickListener;
import android.media.MediaPlayer;


public class Dual extends AppCompatActivity {

    static ArrayList<String> Joueurs = new ArrayList<>();
    static ArrayList<String> Duel = new ArrayList<>();
    static ArrayList<Integer> DuelIndex =  new ArrayList<>();
    static ArrayList<Integer> Score = new ArrayList<>();
    ImageButton btnStart;
    TextView player1;
    TextView player2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dual);

        player1 = (TextView)findViewById(R.id.player1);
        player2 = (TextView)findViewById(R.id.player2);
        btnStart = (ImageButton) findViewById(R.id.vs);
        Joueurs = getIntent().getStringArrayListExtra("Joueurs"); //Récupération de la liste de joueurs saisie dans MainActivity via l'Intent
        Score = getIntent().getIntegerArrayListExtra("Score"); //Récupération des scores
        DuelIndex.add(1);
        DuelIndex.add(1);
        Duel = get2Random(Joueurs); //Récupération des deux combattants au moyen de la fonction get2Random;
        String p1 = Duel.get(0);
        String p2 = Duel.get(1);
        player1.setText(p1);  //Affichage des duellistes dans le layout
        player2.setText(p2);



       btnStart.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent PlayIntent = new Intent(Dual.this, Time.class);
                PlayIntent.putStringArrayListExtra("Joueurs",Joueurs);
                PlayIntent.putStringArrayListExtra("Duel",Duel);
                PlayIntent.putIntegerArrayListExtra("DuelIndex",DuelIndex);
                PlayIntent.putIntegerArrayListExtra("Score",Score);
                Duel = new ArrayList<String>();
                startActivity(PlayIntent);

            }

        });


    }

    public static ArrayList<String> get2Random(ArrayList<String> Array){ //Fonction permettant de tirer 2 joueurs au sort parmis la liste de joueurs.


        Random random1 = new Random(); //Initalisation du randomizer pour le joueur 1
        int index1 = random1.nextInt(Array.size()); //Selection d'un index aléatoire du tableau de Noms
        DuelIndex.set(0,index1);
        Duel.add(Array.get(index1)); //Ajout du nom aléatoirement sélectionner dans la liste de return.
        //Array.remove(Array.get(index1)); //Délétion du joueur sélectionner pour eviter qu'il ne s'affronte lui même

        //Même marche à suivre pour le joueur 2

        Random random2 = new Random();
        int index2 = random2.nextInt(Array.size());
        DuelIndex.set(1,index2);
        Duel.add(Array.get(index2));


        return Duel;
    }


}