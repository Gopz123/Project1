package com.example.bullcow;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Animation topAnim,botAnim;
        Button howplay=(Button)findViewById(R.id.howplay);
        Button play=(Button)findViewById(R.id.play);
        play.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                new Handler().post(new Runnable() {
                    @Override
                    public void run() {
                        Intent intent=new Intent(MainActivity.this,gamePage.class);
                        startActivity(intent);
                        //finish();
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
}
