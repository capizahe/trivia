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
import android.widget.Toast;

import org.json.*;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    public EditText et;
    public String json;
    public Button btn_play;
    public ArrayList<Pregunta> lista_preguntas;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lista_preguntas = new ArrayList<>();
        this.et = (EditText) findViewById(R.id.text);
    }
    public void onPlay(View view ){
        this.json = this.et.getText().toString();
        Toast.makeText(getApplicationContext(),"Conseguido", Toast.LENGTH_LONG).show();
        if(this.json != null) {
            Intent jugar = new Intent(MainActivity.this, PlayActivity.class);
            jugar.putExtra("json_object", et.getText().toString());
            startActivity(jugar);

        }
        else{
            Toast.makeText(getApplicationContext(),"no hay texto", Toast.LENGTH_LONG).show();
        }
    }
}
