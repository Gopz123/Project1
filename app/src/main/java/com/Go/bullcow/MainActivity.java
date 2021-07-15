package com.Go.bullcow;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    MediaPlayer casualbuttons,intro;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_main);

        Animation topAnim,botAnim;
        Button howplay=(Button)findViewById(R.id.howplay);
        Button play=(Button)findViewById(R.id.play);
        casualbuttons=MediaPlayer.create(MainActivity.this,R.raw.casualbutton);
        intro=MediaPlayer.create(MainActivity.this,R.raw.intro);

        intro.start();


        play.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                casualbuttons.start();
                new Handler().post(new Runnable() {
                    @Override
                    public void run() {
                        Intent intent=new Intent(MainActivity.this,gamePage.class);
                        startActivity(intent);
                    }
                });
            }
        });
        howplay.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                casualbuttons.start();
                new Handler().post(new Runnable() {
                    @Override
                    public void run() {
                        Intent intent=new Intent(MainActivity.this,gamepage_2.class);
                        startActivity(intent);
                    }
                });
            }
        });



    topAnim= AnimationUtils.loadAnimation(this,R.anim.top_anim);
    botAnim= AnimationUtils.loadAnimation(this,R.anim.bottom_anim);
        ImageView bull_logo;
        bull_logo=findViewById(R.id.bull_logo);
        bull_logo.setAnimation(topAnim);
        play.setAnimation(botAnim);
        howplay.setAnimation(botAnim);


    }





    protected void onPause(){
        super.onPause();
        intro.release();

    }



}
