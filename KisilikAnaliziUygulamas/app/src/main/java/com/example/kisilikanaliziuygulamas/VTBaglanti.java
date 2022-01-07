package com.example.kisilikanaliziuygulamas;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class VTBaglanti extends SQLiteOpenHelper {
    private static final String VT1="uyeler1";
    public VTBaglanti(@Nullable Context context) {
        super(context, VT1, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE uye(id INTEGER primary key AUTOINCREMENT, uyeAd TEXT, uyeYas TEXT, uyeKisilik TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS uye");
    }
}

