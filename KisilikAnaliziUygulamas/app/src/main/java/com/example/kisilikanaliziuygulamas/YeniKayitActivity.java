package com.example.kisilikanaliziuygulamas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class YeniKayitActivity extends AppCompatActivity {
    EditText uyeAd, uyeYas;
    TextView uyeKisilik;
    String uyeIcon;
    Button BtnKaydet;
    ImageView image;
    private VTBaglanti db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yeni_kayit);
        db=new VTBaglanti(this);

        uyeAd=(EditText) findViewById(R.id.uyeAd);
        uyeYas=(EditText) findViewById(R.id.uyeYas);
        uyeKisilik=(TextView) findViewById(R.id.uyeKisilik);
        BtnKaydet=(Button) findViewById(R.id.BtnKaydet);
        Bundle gelenveri=getIntent().getExtras();
        uyeKisilik.setText(gelenveri.getCharSequence("anahtar").toString());
        uyeIcon=gelenveri.getCharSequence("anahtar").toString();
        image = findViewById(R.id.imageView);
        switch (uyeIcon) {
            case "Konsül":
                image.setImageResource(R.drawable.konsul);
                break;
            case "Girişimci":
                image.setImageResource(R.drawable.girisimci);
                break;
            case "Arabulucu":
                image.setImageResource(R.drawable.arabulucu);
                break;
            case "Maceracı":
                image.setImageResource(R.drawable.maceraci);
                break;
            case "Savunucu":
                image.setImageResource(R.drawable.savunucu);
                break;
            case "Tartışmacı":
                image.setImageResource(R.drawable.tartismaci);
                break;
            case "Önder":
                image.setImageResource(R.drawable.onder);
                break;
            case "Kampanyacı":
                image.setImageResource(R.drawable.kampanyaci);
                break;
        }
            BtnKaydet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                YeniKayit(uyeAd.getText().toString(),uyeYas.getText().toString(),uyeKisilik.getText().toString());
                Toast.makeText(getApplicationContext(),"Sonuç Kaydedildi.",Toast.LENGTH_LONG).show();
                Intent intent = new Intent(YeniKayitActivity.this, KayitActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    private void YeniKayit(String uyeAd, String uyeYas, String uyeKisilik){
        SQLiteDatabase sldb = db.getReadableDatabase();
        ContentValues uye=new ContentValues();
        uye.put("uyeAd", uyeAd);
        uye.put("uyeYas", uyeYas);
        uye.put("uyeKisilik", uyeKisilik);
        sldb.insert("uye",null,uye);
    }
}