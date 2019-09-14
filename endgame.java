package com.photogallery.camil.parcial;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class endgame extends AppCompatActivity {
    public int score;
    public int correctas;
    public int incorrectas;

    public TextView sc,cor,incor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_endgame);
        this.score= getIntent().getIntExtra("puntaje",0);
        this.correctas= getIntent().getIntExtra("correctas",0);

        this.incorrectas= getIntent().getIntExtra("incorrectas",0);

        sc= (TextView) findViewById(R.id.puntajefinal);
        cor= (TextView) findViewById(R.id.correctas);
        incor= (TextView) findViewById(R.id.incorrectas);

        sc.setText("puntajefinal: "+score);
        cor.setText("correctas: "+correctas);
        incor.setText("incorrectas: "+incorrectas);
    }
    public void reset(View view){
        Intent reset = new Intent(this,MainActivity.class);
        startActivity(reset);
    }
}
