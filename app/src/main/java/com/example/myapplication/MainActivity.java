package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Button;
import android.widget.AdapterView;
import java.util.ArrayList;


public class MainActivity extends AppCompatActivity{


    ListView lv;
    ArrayList<String> Noms;
    ArrayAdapter<String> adapter;
    EditText edittext;
    Button btnAdd;
    Button btnPlay;
    ArrayList<Integer> Score = new ArrayList<>();
    int NbJ;


    @Override
   protected void onCreate(Bundle savedInstanceState) {
       super.onCreate(savedInstanceState);
       setContentView(R.layout.accueil);

       lv = (ListView) findViewById(R.id.names);
       btnAdd = (Button) findViewById(R.id.bouton);
       edittext = (EditText) findViewById(R.id.namespace);
       btnPlay = (Button) findViewById(R.id.consigne);


       Noms = new ArrayList<String>();
       adapter = new ArrayAdapter<String>(this,
               android.R.layout.simple_list_item_1,  /* android standard layout for a single entry from list: just some text and just a horizontal separator */
               Noms /* the List<T> contents */);



       btnAdd.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {

               String names = edittext.getText().toString();
               Noms.add(names);
               NbJ+=1;
               lv.setAdapter(adapter);
               adapter.notifyDataSetChanged();
               edittext.setText("");
           }
       });

       btnPlay.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {


               for(int i=0; i<NbJ;i++){
                   Score.add(1);
               }

               Intent PlayIntent = new Intent(MainActivity.this, Dual.class);
               PlayIntent.putStringArrayListExtra("Joueurs",Noms);
               PlayIntent.putIntegerArrayListExtra("Score",Score);


               Noms = new ArrayList<String>();
               startActivity(PlayIntent);


           }

       });


   }

}