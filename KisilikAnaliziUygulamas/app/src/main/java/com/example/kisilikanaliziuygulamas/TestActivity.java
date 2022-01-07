package com.example.kisilikanaliziuygulamas;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.util.ArrayList;

public class TestActivity extends AppCompatActivity {
    TextView text1, text2;
    Button BtnSecenek1, BtnSecenek2, BtnSecenek3, BtnSecenek4;
    ArrayList<SoruActivity> soruList;
    String analizsonuc, cevap1,cevap2,cevap3,cevap4;
    public VTBaglanti db;
    int analizpuan=0, soru=0, sayac=1;
    int konsul, girisimci, arabulucu, maceraci, savunucu, tartismaci, onder, kampanyaci;
    int[] kisilikpuan ={konsul, girisimci, arabulucu, maceraci, savunucu, tartismaci, onder, kampanyaci};
    String[] kisilikad ={"Konsül","Girişimci","Arabulucu","Maceracı","Savunucu","Tartışmacı","Önder","Kampanyacı"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        db=new VTBaglanti(this);

        text1=findViewById(R.id.text1);
        text2=findViewById(R.id.text2);
        BtnSecenek1=findViewById(R.id.BtnSecenek1);
        BtnSecenek2=findViewById(R.id.BtnSecenek2);
        BtnSecenek3=findViewById(R.id.BtnSecenek3);
        BtnSecenek4=findViewById(R.id.BtnSecenek4);

        soruList=new ArrayList<>();
        soruSayfa(soruList);
        soruGetir(soru);

        BtnSecenek1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for(int i =0; i<kisilikad.length; i++) {
                    if (cevap1.equals(kisilikad[i])) {
                        kisilikpuan[i]++;
                    }
                }
                soru++;
                sayac++;
                soruGetir(soru);
            }
        });

        BtnSecenek2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for(int i =0; i<kisilikad.length; i++) {
                    if (cevap2.equals(kisilikad[i])) {
                        kisilikpuan[i]++;
                    }
                }
                soru++;
                sayac++;
                soruGetir(soru);
            }
        });


        BtnSecenek3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for(int i =0; i<kisilikad.length; i++) {
                    if (cevap3.equals(kisilikad[i])) {
                        kisilikpuan[i]++;
                    }
                }
                soru++;
                sayac++;
                soruGetir(soru);
            }
        });


        BtnSecenek4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for(int i =0; i<kisilikad.length; i++) {
                    if (cevap4.equals(kisilikad[i])) {
                        kisilikpuan[i]++;
                    }
                }
                soru++;
                sayac++;
                soruGetir(soru);
            }
        });
    }


    @SuppressLint("SetTextI18n")
    private void    sonucGoster(){
        BottomSheetDialog bottomSheetDialog=new BottomSheetDialog(TestActivity.this);
        View bottomSheetView = LayoutInflater.from(getApplicationContext()).inflate(R.layout.activity_sonuc,(LinearLayout)findViewById(R.id.LLSonuc));
        TextView sonuc = bottomSheetView.findViewById(R.id.sonuc);
        Button BtnYeniAnaliz = bottomSheetView.findViewById(R.id.BtnYeniAnaliz);
        Button BtnMenu = bottomSheetView.findViewById(R.id.BtnMenu);
        Button BtnKayit = bottomSheetView.findViewById(R.id.BtnKayit);


        analizpuan=kisilikpuan[0];
        for(int i=0; i< kisilikpuan.length; i++){
            if(kisilikpuan[i]>analizpuan){
                analizpuan=kisilikpuan[i];
            }
        }
        for(int k=0; k<kisilikad.length; k++){
            if(analizpuan==kisilikpuan[k]){
                analizsonuc = kisilikad[k];
            }
        }

        text1.setVisibility(View.INVISIBLE);
        text2.setVisibility(View.INVISIBLE);
        BtnSecenek1.setVisibility(View.INVISIBLE);
        BtnSecenek2.setVisibility(View.INVISIBLE);
        BtnSecenek3.setVisibility(View.INVISIBLE);
        BtnSecenek4.setVisibility(View.INVISIBLE);



        sonuc.setText("Kişiliğiniz: \n"+analizsonuc);
        bottomSheetDialog.setCancelable(false);
        bottomSheetDialog.setContentView(bottomSheetView);
        bottomSheetDialog.show();


        BtnYeniAnaliz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                for(int i=0; i<kisilikpuan.length; i++){
                    kisilikpuan[i]=0;
                }
                finish();
                Intent intent = new Intent(TestActivity.this, TestActivity.class);
                startActivity(intent);
                bottomSheetDialog.dismiss();
            }
        });
        BtnMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                Intent intent = new Intent(TestActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });

        BtnKayit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CharSequence uyeKisilik=analizsonuc;
                finish();
                Intent intent1 = new Intent(TestActivity.this,YeniKayitActivity.class);
                intent1.putExtra("anahtar",uyeKisilik);
                startActivity(intent1);
            }
        });
    }

    private  void soruGetir(int soru){
        text2.setText(sayac+". Soru");
        if(sayac==11){
            sonucGoster();
        }else{
            text1.setText(soruList.get(soru).getSoru());
            BtnSecenek1.setText(soruList.get(soru).getSecenek1());
            BtnSecenek2.setText(soruList.get(soru).getSecenek2());
            BtnSecenek3.setText(soruList.get(soru).getSecenek3());
            BtnSecenek4.setText(soruList.get(soru).getSecenek4());
            cevap1 = soruList.get(soru).getCevap1();
            cevap2 = soruList.get(soru).getCevap2();
            cevap3 = soruList.get(soru).getCevap3();
            cevap4 = soruList.get(soru).getCevap4();
        }
    }

    private void soruSayfa(ArrayList<SoruActivity> soruList) {
        soruList.add(new SoruActivity("Kendinizi başka kişilere tanıtmayı zor buluyorsunuz.","Çok doğru.","Kısmen doğru.","Kısmen yanlış.","Çok yanlış.","Tartışmacı","Kampanyacı","Önder","Konsül"));
        soruList.add(new SoruActivity("Çoğunlukla düşüncelerinizde öyle kayboluyorsunuz ki, etrafınızdakileri görmezden geliyor veya unutuyorsunuz.","Çok doğru.","Kısmen doğru.","Kısmen yanlış.","Çok yanlış.","Tartışmacı","Savunucu","Arabulucu","Konsül"));
        soruList.add(new SoruActivity("E-postalarınıza mümkün olduğu kadar çabuk yanıt vermeye çalışıyor ve dağınık bir gelen kutusuna tahammül edemiyorsunuz.","Çok doğru.","Kısmen doğru.","Kısmen yanlış.","Çok yanlış.","Girişimci","Önder","Savunucu","Maceracı"));
        soruList.add(new SoruActivity("Biraz baskı olan durumlarda bile, kolay şekilde rahat ve odaklı kalabiliyorsunuz.","Çok doğru.","Kısmen doğru.","Kısmen yanlış.","Çok yanlış.","Önder","Arabulucu","Kampanyacı","Tartışmacı"));
        soruList.add(new SoruActivity("Genellikle konuşmaları başlatan taraf siz değilsiniz.","Çok doğru.","Kısmen doğru.","Kısmen yanlış.","Çok yanlış.","Savunucu","Arabulucu","Önder","Girişimci"));
        soruList.add(new SoruActivity("Nadiren sırf meraktan bir şey yapıyorsunuz.","Çok doğru.","Kısmen doğru.","Kısmen yanlış.","Çok yanlış.","Maceracı","Kampanyacı","Arabulucu","Savunucu"));
        soruList.add(new SoruActivity("Kendinizi diğer insanlardan üstün hissediyorsunuz.","Çok doğru.","Kısmen doğru.","Kısmen yanlış.","Çok yanlış.","Önder","Tartışmacı","Kampanyacı","Konsül"));
        soruList.add(new SoruActivity("Sizin için düzenli olmak uyum sağlamaktan daha önemli.","Çok doğru.","Kısmen doğru.","Kısmen yanlış.","Çok yanlış.","Girişimci","Önder","Arabulucu","Maceracı"));
        soruList.add(new SoruActivity("Genellikle yüksek motivasyona sahip ve enerjiksiniz.","Çok doğru.","Kısmen doğru.","Kısmen yanlış.","Çok yanlış.","Konsül","Girişimci","Tartışmacı","Savunucu"));
        soruList.add(new SoruActivity("Bir tartışmayı kazanmak, kimsenin üzülmemesini sağlamaktan daha önemsiz.","Çok doğru.","Kısmen doğru.","Kısmen yanlış.","Çok yanlış.","Arabulucu","Savunucu","Kampanyacı","Tartışmacı"));
    }
}
