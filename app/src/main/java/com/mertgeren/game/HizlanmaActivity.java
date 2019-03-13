package com.mertgeren.game;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.os.CountDownTimer;
import android.os.Handler;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class HizlanmaActivity extends AppCompatActivity {

    TextView timeText;
    TextView scoreText;
    int score = 0;
    ImageView imageView1;
    ImageView imageView2;
    ImageView imageView3;
    ImageView imageView4;
    ImageView imageView5;
    ImageView imageView6;
    ImageView imageView7;
    ImageView imageView8;
    ImageView imageView9;
    ImageView imageView10;
    ImageView imageView11;
    ImageView imageView12;
    ImageView[] imageArray;
    Handler handler;
    Runnable runnable;
    MediaPlayer mediaPlayer2;
    Bitmap bitmap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hizlanma);

        mediaPlayer2 = MediaPlayer.create(HizlanmaActivity.this, R.raw.hizlanma);
        mediaPlayer2.start();
        bitmap = BitmapFactory.decodeResource(getApplicationContext().getResources(), R.drawable.tosun);
        timeText = findViewById(R.id.zamanTextView);
        Typeface boldTypeface = Typeface.defaultFromStyle(Typeface.BOLD);
        timeText.setTypeface(boldTypeface);
        scoreText = findViewById(R.id.skorTextView);
        scoreText.setTypeface(boldTypeface);
        imageView1 = findViewById(R.id.imageView1);
        imageView2 = findViewById(R.id.imageView2);
        imageView3 = findViewById(R.id.imageView3);
        imageView4 = findViewById(R.id.imageView4);
        imageView5 = findViewById(R.id.imageView5);
        imageView6 = findViewById(R.id.imageView6);
        imageView7 = findViewById(R.id.imageView7);
        imageView8 = findViewById(R.id.imageView8);
        imageView9 = findViewById(R.id.imageView9);
        imageView10 = findViewById(R.id.imageView10);
        imageView11 = findViewById(R.id.imageView11);
        imageView12 = findViewById(R.id.imageView12);
        imageArray = new ImageView[] {imageView1, imageView2, imageView3, imageView4, imageView5, imageView6, imageView7, imageView8, imageView9 ,imageView10, imageView11, imageView12};

        hideImage();

        new CountDownTimer(120000,1000){

            @Override
            public void onTick(long millisUntilFinished) {
                timeText.setText("Zaman : " + millisUntilFinished / 1000);
            }
            @Override
            public void onFinish() {
                handler.removeCallbacks(runnable);
                for(ImageView image : imageArray){
                    image.setVisibility(View.INVISIBLE);
                }

                SharedPreferences settings = getSharedPreferences("HIZ", Context.MODE_PRIVATE);
                int highScore = settings.getInt("HIGH_SCORE_HIZ", 0);
                if(score > highScore){
                    SharedPreferences.Editor editor = settings.edit();
                    editor.putInt("HIGH_SCORE_HIZ", score);
                    editor.commit();
                }

                AlertDialog.Builder alert = new AlertDialog.Builder(HizlanmaActivity.this);
                alert.setTitle("SÜRE BİTTİ");
                alert.setMessage("\nSkorunuz : " + score + "\n\nEn Yüksek Skorunuz : " + highScore + "\n\nTekrar oynamak ister misiniz ?");
                alert.setPositiveButton("EVET", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = getIntent();
                        finish();
                        startActivity(intent);
                    }
                });
                alert.setNegativeButton("HAYIR", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(HizlanmaActivity.this, "DAHA İYİSİNİ YAPAMAZ MISIN ?", Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(intent);
                    }
                });
                alert.show();
            }
        }.start();
    }

    public void scorePlus(View view){
        score++;
        scoreText.setText("Skor : " + score);
    }

    public void hideImage(){
        handler = new Handler();
        runnable = new Runnable() {

            @Override
            public void run() {
                for(ImageView image : imageArray)
                    image.setVisibility(View.INVISIBLE);

                Random random = new Random();
                int i = random.nextInt(12);
                imageArray[i].setImageBitmap(bitmap);

                if(score <=10){
                    imageArray[i].setVisibility(View.VISIBLE);
                    handler.postDelayed(this, 1100);
                }else if(score > 10 && score <= 20){
                    imageArray[i].setVisibility(View.VISIBLE);
                    handler.postDelayed(this, 1000);
                }else if(score > 20 && score <= 30){
                    imageArray[i].setVisibility(View.VISIBLE);
                    handler.postDelayed(this, 900);
                }else if(score > 30 && score <= 40){
                    imageArray[i].setVisibility(View.VISIBLE);
                    handler.postDelayed(this, 800);
                }else if(score > 40 && score <= 50){
                    imageArray[i].setVisibility(View.VISIBLE);
                    handler.postDelayed(this, 700);
                }else if(score > 50 && score <= 60){
                    imageArray[i].setVisibility(View.VISIBLE);
                    handler.postDelayed(this, 600);
                }else if(score > 60 && score <= 70){
                    imageArray[i].setVisibility(View.VISIBLE);
                    handler.postDelayed(this, 500);
                }else if(score > 70 && score <= 80){
                    imageArray[i].setVisibility(View.VISIBLE);
                    handler.postDelayed(this, 400);
                }else if(score > 80 && score <= 90){
                    imageArray[i].setVisibility(View.VISIBLE);
                    handler.postDelayed(this, 300);
                }else if(score > 90 && score <= 100){
                    imageArray[i].setVisibility(View.VISIBLE);
                    handler.postDelayed(this, 200);
                }else if(score > 100 && score <= 110){
                    imageArray[i].setVisibility(View.VISIBLE);
                    handler.postDelayed(this, 100);
                }else if(score > 110 && score <= 120){
                    imageArray[i].setVisibility(View.VISIBLE);
                    handler.postDelayed(this, 50);
                }
            }
        };
        handler.post(runnable);
    }

    public void onBackPressed(){
        mediaPlayer2.stop();
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);
    }
}
