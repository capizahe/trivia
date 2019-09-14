package com.photogallery.camil.parcial;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.JsonReader;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.json.*;

import java.util.ArrayList;
import java.util.Random;

public class PlayActivity extends AppCompatActivity {

    public ArrayList<Pregunta> lista_preguntas;
    public String json_text;

    public Button p1,p2,p3,p4;
    public TextView puntaje,pregunta;
    public int score=0;
    public int index= 0;
    public int correctas=0;
    public int incorrectas=0;
    public Pregunta preguntaactual;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);
        this.json_text = getIntent().getStringExtra("json_object");
        this.lista_preguntas = new ArrayList<>();
        convert();
        p1 = (Button) findViewById(R.id.p1);
        p2 = (Button) findViewById(R.id.p2);
        p3 = (Button) findViewById(R.id.p3);
        p4 = (Button) findViewById(R.id.p4);
        puntaje = (TextView) findViewById(R.id.puntaje);
        pregunta = (TextView) findViewById(R.id.pregunta);
        showQuestion();
    }

    void showQuestion(){
        Pregunta pregunta = lista_preguntas.get(index);
        this.pregunta.setText(pregunta.quiestion);
        this.preguntaactual = pregunta;
        Random r = new Random();
        switch(r.nextInt(4)) {
            case 0:
            this.p1.setText(pregunta.b);
            this.p2.setText(pregunta.a);
            this.p3.setText(pregunta.correct);
            this.p4.setText(pregunta.c);
            break;
            case 1:
                this.p1.setText(pregunta.a);
                this.p2.setText(pregunta.b);
                this.p3.setText(pregunta.c);
                this.p4.setText(pregunta.correct);
                break;
            case 2:
                this.p1.setText(pregunta.c);
                this.p2.setText(pregunta.correct);
                this.p3.setText(pregunta.a);
                this.p4.setText(pregunta.b);
                break;
            case 3:
                this.p1.setText(pregunta.correct);
                this.p2.setText(pregunta.a);
                this.p3.setText(pregunta.c);
                this.p4.setText(pregunta.b);
                break;
        }

    }

    public void convert() {
try {
    JSONObject jsonObject = new JSONObject(this.json_text);
    JSONArray jsonArray = jsonObject.getJSONArray("results");
    //JSONObject question = jsonObject.getJSONObject("question");   por si las flies
    for (int i = 0; i < jsonArray.length(); i++) {
        JSONObject pregunta = jsonArray.getJSONObject(i);
        JSONArray incorrectas = pregunta.getJSONArray("incorrect_answers");
        this.lista_preguntas.add
                (new Pregunta(pregunta.get("question").toString(), pregunta.getString("correct_answer"), incorrectas.get(0).toString(), incorrectas.get(1).toString(), incorrectas.get(2).toString()));
    }
}catch (JSONException e){
    e.printStackTrace();
}
    }

 public void verificar(View view) {
    Button b1 = (Button) view;
    if(b1.getText().equals(preguntaactual.correct)){
        score+=10;
        index = (index+1)%this.lista_preguntas.size();
        showQuestion();
        correctas++;
        this.puntaje.setText(score+"");
        if(score==50){
            Intent end = new Intent(PlayActivity.this, endgame.class);
            end.putExtra("puntaje",score);
            end.putExtra("correctas",correctas);
            end.putExtra("incorrectas",incorrectas);
            startActivity(end);

        }
    }else{
        score-=10;
        index = (index+1)%this.lista_preguntas.size();
        showQuestion();
        incorrectas++;
        this.puntaje.setText(score+"");

    }

 }

 }