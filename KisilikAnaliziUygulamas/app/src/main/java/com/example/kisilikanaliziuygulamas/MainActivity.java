package com.example.kisilikanaliziuygulamas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
      //  TextView textHG=(TextView)findViewById(R.id.textHG);
        Button BtnBasla=(Button)findViewById(R.id.BtnBasla);
        Button BtnCikis=(Button)findViewById(R.id.BtnCikis);
        Button BtnKayitlar=(Button)findViewById(R.id.BtnKayitlar);

        BtnBasla.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this,TestActivity.class);
                startActivity(intent);
            }
        });
        BtnCikis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                System.exit(0);
            }
        });
        BtnKayitlar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this,KayitActivity.class);
                startActivity(intent);
            }
        });



    }
}