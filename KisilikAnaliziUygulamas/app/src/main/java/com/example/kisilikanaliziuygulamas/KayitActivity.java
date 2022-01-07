package com.example.kisilikanaliziuygulamas;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class KayitActivity extends AppCompatActivity {

    EditText uyeAd, uyeYas, uyeKisilik;
    Button BtnMenu;
    TextView bilgiler;
    private VTBaglanti db;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kayit);
        db=new VTBaglanti(this);
        bilgiler=(TextView) findViewById(R.id.bilgiler);
        BtnMenu =(Button) findViewById(R.id.BtnMenu);


        BtnMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                Intent intent = new Intent(KayitActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
        Listele();
    }


    private void Listele(){
        String [] sutunlar={"uyeAd","uyeYas","uyeKisilik"};
        SQLiteDatabase sldb = db.getReadableDatabase();
        Cursor uyeler1= sldb.query("uye",sutunlar,null,null,null,null,null);
        String tumbilgi="";
        while (uyeler1.moveToNext()){
            @SuppressLint("Range") String adbilgisi=uyeler1.getString(uyeler1.getColumnIndex("uyeAd"));
            @SuppressLint("Range") String yasbilgisi=uyeler1.getString(uyeler1.getColumnIndex("uyeYas"));
            @SuppressLint("Range") String kisilikbilgisi=uyeler1.getString(uyeler1.getColumnIndex("uyeKisilik"));

            tumbilgi += adbilgisi+" "+yasbilgisi+" "+kisilikbilgisi+"\n";
        }
        bilgiler.setText(tumbilgi);
    }

}