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

public class CezaPuanliActivity extends AppCompatActivity {

    TextView timeText2;
    TextView scoreText2;
    int score2 = 0;
    int degisken = 0;
    ImageView imageView101;
    ImageView imageView102;
    ImageView imageView103;
    ImageView imageView104;
    ImageView imageView105;
    ImageView imageView106;
    ImageView imageView107;
    ImageView imageView108;
    ImageView imageView109;
    ImageView imageView110;
    ImageView imageView111;
    ImageView imageView112;
    ImageView[] imageArray2;
    Handler handler2;
    Runnable runnable2;
    MediaPlayer mediaPlayer3;
    Bitmap dogru;
    Bitmap yanlis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ceza_puanli);

        mediaPlayer3 = MediaPlayer.create(CezaPuanliActivity.this, R.raw.cezali);
        mediaPlayer3.start();
        dogru = BitmapFactory.decodeResource(getApplicationContext().getResources(), R.drawable.kemalsunal);
        yanlis = BitmapFactory.decodeResource(getApplicationContext().getResources(), R.drawable.ceza);
        timeText2 = findViewById(R.id.zamanTextView2);
        Typeface boldTypeface = Typeface.defaultFromStyle(Typeface.BOLD);
        timeText2.setTypeface(boldTypeface);
        scoreText2 = findViewById(R.id.skorTextView2);
        scoreText2.setTypeface(boldTypeface);
        imageView101 = findViewById(R.id.imageView101);
        imageView102 = findViewById(R.id.imageView102);
        imageView103 = findViewById(R.id.imageView103);
        imageView104 = findViewById(R.id.imageView104);
        imageView105 = findViewById(R.id.imageView105);
        imageView106 = findViewById(R.id.imageView106);
        imageView107 = findViewById(R.id.imageView107);
        imageView108 = findViewById(R.id.imageView108);
        imageView109 = findViewById(R.id.imageView109);
        imageView110 = findViewById(R.id.imageView110);
        imageView111 = findViewById(R.id.imageView111);
        imageView112 = findViewById(R.id.imageView112);
        imageArray2 = new ImageView[] {imageView101, imageView102, imageView103, imageView104, imageView105, imageView106, imageView107, imageView108, imageView109, imageView110, imageView111, imageView112};

        hideImage();

        new CountDownTimer(120000,1000){

            @Override
            public void onTick(long millisUntilFinished) {
                timeText2.setText("Zaman : " + millisUntilFinished / 1000);
            }
            @Override
            public void onFinish() {
                handler2.removeCallbacks(runnable2);
                for(ImageView image : imageArray2){
                    image.setVisibility(View.INVISIBLE);
                }

                SharedPreferences settings = getSharedPreferences("CEZA", Context.MODE_PRIVATE);
                int highScore = settings.getInt("HIGH_SCORE_CEZA", 0);
                if(score2 > highScore){
                    SharedPreferences.Editor editor = settings.edit();
                    editor.putInt("HIGH_SCORE_CEZA", score2);
                    editor.commit();
                }

                AlertDialog.Builder alert = new AlertDialog.Builder(CezaPuanliActivity.this);
                alert.setTitle("SÜRE BİTTİ");
                alert.setMessage("\nSkorunuz : " + score2 + "\n\nEn Yüksek Skorunuz : " + highScore + "\n\nTekrar oynamak ister misiniz ?");
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
                        Toast.makeText(CezaPuanliActivity.this, "DAHA İYİSİNİ YAPAMAZ MISIN ?", Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(intent);
                    }
                });
                alert.show();
            }
        }.start();
    }

    public void hideImage(){
        handler2 = new Handler();
        runnable2 = new Runnable() {

            @Override
            public void run() {
                for(ImageView image : imageArray2)
                    image.setVisibility(View.INVISIBLE);


                Random random = new Random();
                int i = random.nextInt(12);
                Random random2 = new Random();
                degisken = random2.nextInt(21);

                if(degisken % 3 == 0){
                    imageArray2[i].setImageBitmap(yanlis);
                    imageArray2[i].setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            if(score2 <= 10)
                                score2 = (score2 - 2);
                            else if(score2 > 10 && score2 <= 20)
                                score2 = (score2 - 4);
                            else if(score2 > 20 && score2 <= 30)
                                score2 = (score2 - 6);
                            else if(score2 > 30 && score2 <= 40)
                                score2 = (score2 - 8);
                            else if(score2 > 40 && score2 <= 50)
                                score2 = (score2 - 10);
                            else if(score2 > 50 && score2 <= 60)
                                score2 = (score2 - 12);
                            else if(score2 > 60 && score2 <= 70)
                                score2 = (score2 - 14);
                            else if(score2 > 70 && score2 <= 80)
                                score2 = (score2 - 16);
                            else if(score2 > 80 && score2 <= 90)
                                score2 = (score2 - 18);
                            else if(score2 > 90 && score2 <= 100)
                                score2 = (score2 - 20);
                            else if(score2 > 100 && score2 <= 110)
                                score2 = (score2 - 22);
                            else if(score2 > 110 && score2 <= 120)
                                score2 = (score2 - 24);
                            else if(score2 > 120 && score2 <= 130)
                                score2 = (score2 - 26);
                            else if(score2 > 130 && score2 <= 140)
                                score2 = (score2 - 28);
                            else if(score2 > 140 && score2 <= 150)
                                score2 = (score2 - 30);
                            else if(score2 > 150 && score2 <= 160)
                                score2 = (score2 - 32);
                            else if(score2 > 160 && score2 <= 170)
                                score2 = (score2 - 34);
                            else if(score2 > 170 && score2 <= 180)
                                score2 = (score2 - 36);
                            else if(score2 > 180 && score2 <= 190)
                                score2 = (score2 - 38);
                            else if(score2 > 190 && score2 <= 200)
                                score2 = (score2 - 40);
                            else if(score2 > 200 && score2 <= 210)
                                score2 = (score2 - 42);
                            else if(score2 > 210 && score2 <= 220)
                                score2 = (score2 - 44);

                            scoreText2.setText("Skor : " + score2);
                        }
                    });
                }
                else {
                    imageArray2[i].setImageBitmap(dogru);
                    imageArray2[i].setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            score2++;
                            scoreText2.setText("Skor : " + score2);
                        }
                    });
                }

                imageArray2[i].setVisibility(View.VISIBLE);
                handler2.postDelayed(this, 750);
            }
        };
        handler2.post(runnable2);
    }

    public void onBackPressed(){
        mediaPlayer3.stop();
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);
    }
}
