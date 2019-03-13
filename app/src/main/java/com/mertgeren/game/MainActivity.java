package com.mertgeren.game;

import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.song);
        mediaPlayer.start();
    }

    public void onBackPressed(){
        mediaPlayer.pause();
        AlertDialog.Builder alert = new AlertDialog.Builder(MainActivity.this);
        alert.setTitle("KEMAL SUNAL İÇİN KALMALISIN");
        alert.setMessage("\nUygulamayı kapatmak istediğinizden emin misiniz?");
        alert.setPositiveButton("EVET", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                mediaPlayer.stop();
                System.exit(0);
            }
        });
        alert.setNegativeButton("HAYIR", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
                mediaPlayer.start();
            }
        });
        alert.show();
    }

    public void cezaPuanli (View view) {
        mediaPlayer.stop();
        Intent intent2 = new Intent(getApplicationContext(), CezaPuanliActivity.class);
        startActivity(intent2);
    }

    public void hizlanma (View view) {
        mediaPlayer.stop();
        Intent intent = new Intent(getApplicationContext(), HizlanmaActivity.class);
        startActivity(intent);
    }

    public void hakkinda (View view) {
        mediaPlayer.pause();
        AlertDialog.Builder alert = new AlertDialog.Builder(MainActivity.this);
        alert.setTitle("OYUN HAKKINDA BİLGİLENDİRME");
        alert.setMessage("\nOyunumuzda 2 mod bulunmaktadır. Her ikisinde de 120 saniye zamanımız bulunmaktadır.\n\n1. Mod => Ceza Puanlı Mod\nBu bölümde iki farklı resim karşımıza çıkacaktır. Eğer silahlı " +
                "olana tıklarsanız 2 ceza puanı alırsınız ve bu ceza puanı her 10 skor kazandığınızda iki katına çıkacaktır ama gülümseyen Kemal Sunal'ın " +
                "bulunduğu resime tıklarsanız +1 skor kazanacaksınız.\n\n2. Mod => Hızlanma Modu\nBu bölümde ise tek bir resim bulunmaktadır ve bu resim " +
                "1.1 saniye süre ile ekranın farklı yerlerinde ortaya çıkıp kaybolacaktır. Her 10 skor kazandığınızda ise resimin ekranda yer değiştirmesi " +
                "0.1 saniye hızlanacaktır.");
        alert.setNegativeButton("TAMAM", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
                mediaPlayer.start();
            }
        });
        alert.show();
    }
}
