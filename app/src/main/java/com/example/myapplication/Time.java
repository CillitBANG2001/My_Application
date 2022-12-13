package com.example.myapplication;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.TextView;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Random;


public class Time extends AppCompatActivity {

    ArrayList<String> Joueur;
    static ArrayList<String> Duel = new ArrayList<>();
    TextView Question;
    private static final long START_TIME_IN_MS = 60000;
    private TextView TextTimer1;
    private TextView TextTimer2;
    private Button start1;
    private Button start2;
    private CountDownTimer Timer1;
    private CountDownTimer Timer2;
    private boolean TimerRunning1;
    private boolean TimerRunning2;
    private long TimeLeft1 = START_TIME_IN_MS;
    private long TimeLeft2 = START_TIME_IN_MS;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.timer);

        TextView player1 = (TextView) findViewById(R.id.player1);
        TextView player2 = (TextView) findViewById(R.id.player2);
        Question = (TextView) findViewById(R.id.question);
        TextTimer1 = findViewById(R.id.timer_1);
        TextTimer2 = findViewById(R.id.timer_2);

        start1 = findViewById(R.id.start1);
        start2 = findViewById(R.id.start2);


        Joueur = getIntent().getStringArrayListExtra("Joueurs"); //Récupération de la liste de joueurs saisie dans MainActivity via l'Intent

        Duel = getIntent().getStringArrayListExtra("Duel"); //Récupération des deux joueurs sélectionnés
        Question.setText(getRandomQuestion());
        player1.setText(Duel.get(0));  //Affichage des duellistes dans le layout
        player2.setText(Duel.get(1));


        start1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(TimerRunning1) {
                    pauseTimer1();
                }else{
                    startTimer1();
                }

            }
        });

        start2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(TimerRunning2) {
                    pauseTimer2();
                }else{
                    startTimer2();
                }

            }
        });



    }


        public String getRandomQuestion() { //Fonction rextournant une question au hasard


            String[] myResArray = getResources().getStringArray(R.array.questions);


            Random random1 = new Random(); //Initalisation du randomizer
            int index1 = random1.nextInt(myResArray.length); //Selection d'un index aléatoire du tableau de questions
            String question = myResArray[index1]; //Ajout du nom aléatoirement sélectionner dans la liste de return.

            return question;
        }


        private void startTimer1(){

        Timer1 = new CountDownTimer(TimeLeft1,1000) {
            @Override
            public void onTick(long l) {
                TimeLeft1 = l;
                updateCountDownText(TimeLeft1,TextTimer1);
            }

            @Override
            public void onFinish() {

                TimerRunning1 = false;

            }
        }.start();

        TimerRunning1 = true;
        start1.setText("PAUSE");
        }





    private void startTimer2(){

        Timer2 = new CountDownTimer(TimeLeft2,1000) {
            @Override
            public void onTick(long l) {
                TimeLeft2 = l;
                updateCountDownText(TimeLeft2,TextTimer2);
            }

            @Override
            public void onFinish() {

                TimerRunning2 = false;

            }
        }.start();

        TimerRunning2 = true;
        start2.setText("PAUSE");
    }

    private void pauseTimer1(){

        Timer1.cancel();
        TimerRunning1 = false;
        start1.setText("START");

    }

    private void pauseTimer2(){

        Timer2.cancel();
        TimerRunning2 = false;
        start2.setText("START");

    }


    private void updateCountDownText(long TL, TextView T){

        int minutes = (int) (TL/1000)/60;
        int seconds = (int) (TL/1000) %60;

        String timeLeftFormated = String.format(Locale.getDefault(),"%02d:%02d", minutes,seconds);
        T.setText(timeLeftFormated);

    }





}