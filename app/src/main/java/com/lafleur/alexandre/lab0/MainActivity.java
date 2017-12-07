package com.lafleur.alexandre.lab0;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements RecyclerViewAdapter.ItemClickListener {

    private TextView mGreetingText;
    private EditText mNameInput;
    private Button mPlayButton;
    private Button mToastButton;
    private android.support.v7.widget.Toolbar monToolBar;
    final static private int[] leTexte1 = {R.string.menu1, R.string.menu2};
    final static private int[] leTexte2 = {R.string.menu1, R.string.menu2};
    private ArrayList<Joueur>listeJoueurs;

    RecyclerViewAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mGreetingText = (TextView) findViewById(R.id.monTextView);
        mNameInput = (EditText) findViewById(R.id.activity_main_name_input);
        mPlayButton = (Button) findViewById(R.id.monButtonActivity);
        monToolBar = (android.support.v7.widget.Toolbar) findViewById(R.id.customToolBar);
        setSupportActionBar(monToolBar);

        listeJoueurs = new ArrayList<>();
        for (int i=0 ; i < 2 ; i++){
            listeJoueurs.add(new Joueur(getResources().getString(leTexte1[i]),getResources().getString(leTexte2[i])));
        }

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycleur);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new RecyclerViewAdapter(this, listeJoueurs);
        //adapter.setClickListener(this);
        recyclerView.setAdapter(adapter);

        mPlayButton.setEnabled(false);

        mNameInput.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence s, int i, int i1, int i2) {
                mPlayButton.setEnabled(s.toString().length() != 0);

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        mPlayButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                   startActivity(new Intent(MainActivity.this, MyOtherActivity.class));




            }
        });

        mToastButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


            }
        });



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.item1:
                Toast.makeText(MainActivity.this, "c'est le 1!", Toast.LENGTH_SHORT).show();
                break;

            case R.id.item2:
                Toast.makeText(MainActivity.this, "c'est le 2!", Toast.LENGTH_SHORT).show();

                break;

        }

        return super.onOptionsItemSelected(item);
    }

    public void customToast(View view) {
        Context context = getApplicationContext();
        LayoutInflater inflater = getLayoutInflater();
        View customToastRoot = inflater.inflate(R.layout.toast_layout, null);
        Toast customToast = new Toast(context);

        customToast.setView(customToastRoot);
        customToast.setDuration(Toast.LENGTH_LONG);
        customToast.show();
    }

    @Override
    public void onItemClick(View view, int position) {
String wouhou = listeJoueurs.get(position).getTexte1();
Intent intent = new Intent(MainActivity.this, MyOtherActivity.class);
intent.putExtra("texte1Joueur",wouhou);
startActivity(intent);
    }
}
