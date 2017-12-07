package com.lafleur.alexandre.lab0;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MyOtherActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_other);
        String jelai;
        Bundle extras = getIntent().getExtras();
        if (extras!= null){
            jelai = extras.getString("texte1Joueur");
        }else{
            Toast.makeText(this,"fuck off t as rien",Toast.LENGTH_SHORT);
        }
    }
}
