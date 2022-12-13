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


public class Dual extends AppCompatActivity {

    static ArrayList<String> Joueur = new ArrayList<>();
    static ArrayList<String> Duel = new ArrayList<>();
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

        Joueur = getIntent().getStringArrayListExtra("Joueurs"); //Récupération de la liste de joueurs saisie dans MainActivity via l'Intent
        Duel = get2Random(Joueur); //Récupération des deux combattants au moyen de la fonction get2Random;
        String p1 = Duel.get(0);
        String p2 = Duel.get(1);
        player1.setText(p1);  //Affichage des duellistes dans le layout
        player2.setText(p2);

       btnStart.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent PlayIntent = new Intent(Dual.this, Time.class);
                PlayIntent.putStringArrayListExtra("Joueurs",Joueur);
                PlayIntent.putStringArrayListExtra("Duel",Duel);
                startActivity(PlayIntent);

            }

        });


    }

    public static ArrayList<String> get2Random(ArrayList<String> Array){ //Fonction permettant de tirer 2 joueurs au sort parmis la liste de joueurs.


        Random random1 = new Random(); //Initalisation du randomizer pour le joueur 1
        int index1 = random1.nextInt(Array.size()); //Selection d'un index aléatoire du tableau de Noms
        Duel.add(Array.get(index1)); //Ajout du nom aléatoirement sélectionner dans la liste de return.
        Array.remove(Array.get(index1)); //Délétion du joueur sélectionner pour eviter qu'il ne s'affronte lui même

        //Même marche à suivre pour le joueur 2

        Random random2 = new Random();
        int index2 = random2.nextInt(Array.size());
        Duel.add(Array.get(index2));


        return Duel;
    }


}