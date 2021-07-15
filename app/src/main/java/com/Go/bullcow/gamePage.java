package com.Go.bullcow;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.NumberPicker;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class gamePage extends AppCompatActivity {



    int n1,n2,n3,n4,n5,i,j,k,l,m,n;
    int[] guess = new int[5];
    int[] random = new int[5];
    Random rand= new Random();
    int bull=0,cow=0,clickcount=0;
    Dialog dialog;
    ArrayList word=new ArrayList<>();
    MediaPlayer gameover,won,duplicate,bullbuttons,casualbutton,bgm,tick;


    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);



        setContentView(R.layout.activity_game_page);
        ListView test=(ListView)findViewById(R.id.testingtext);
        TextView rowtext=(TextView)findViewById(R.id.rowid);
        ImageButton bullbutton=(ImageButton)findViewById(R.id.bullbutton);
        Button refresh=(Button)findViewById(R.id.refresh);
        Button giveup=(Button)findViewById(R.id.giveup);
        dialog=new Dialog(gamePage.this);
        gameover=MediaPlayer.create(gamePage.this,R.raw.gameover01);
        won=MediaPlayer.create(gamePage.this,R.raw.won);
        duplicate=MediaPlayer.create(gamePage.this,R.raw.duplicate_new);
        bullbuttons=MediaPlayer.create(gamePage.this,R.raw.bullbuttons);
        casualbutton=MediaPlayer.create(gamePage.this,R.raw.casualbutton);
        bgm=MediaPlayer.create(gamePage.this,R.raw.horizon_mini2);
        tick=MediaPlayer.create(gamePage.this,R.raw.tiksound);

        bgm.setLooping(true);
        bgm.start();

        NumberPicker num1=(NumberPicker)findViewById(R.id.numbers1);
        num1.setMinValue(0);
        num1.setMaxValue(9);
        num1.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal)
            {   tick.start();
                n1=newVal;

            }
        });
        NumberPicker num2=(NumberPicker)findViewById(R.id.numbers2);
        num2.setMinValue(0);
        num2.setMaxValue(9);
        num2.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal)
            {   tick.start();
                n2=newVal;

            }
        });
        NumberPicker num3=(NumberPicker)findViewById(R.id.numbers3);
        num3.setMinValue(0);
        num3.setMaxValue(9);
        num3.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal)
            {   tick.start();
                n3=newVal;

            }
        });
        NumberPicker num4=(NumberPicker)findViewById(R.id.numbers4);
        num4.setMinValue(0);
        num4.setMaxValue(9);
        num4.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal)
            {   tick.start();
                n4=newVal;

            }
        });
        NumberPicker num5=(NumberPicker)findViewById(R.id.numbers5);
        num5.setMinValue(0);
        num5.setMaxValue(9);
        num5.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal)
            {   tick.start();
                n5=newVal;

            }
        });


        for(k=0;k<5;k++)
        {
            random[k]=rand.nextInt(9);
            for( l=k-1;l>-1;l--)
            {
                if(random[k]==random[l])
                {
                    random[k]=rand.nextInt(9);
                    l=k;
                }

            }
        }


        ArrayAdapter item=new ArrayAdapter(this,R.layout.row,word);
        bullbutton.setOnClickListener(new View.OnClickListener(){

            @Override

            public void onClick(View v){

                bull=0;
                cow=0;
              int flag=0;

                guess[0]=n1;
                guess[1]=n2;
                guess[2]=n3;
                guess[3]=n4;
                guess[4]=n5;
                for( m=0;m<4;++m)
                {
                    for( n=m+1;n<5;++n)
                    {
                        if(guess[m]==guess[n])
                        {
                            flag++;
                            break;
                        }

                    }
                }
               if(flag==0)
               {  clickcount++;
                   for (i = 0; i < 5; ++i) {
                       for (j = 0; j < 5; ++j) {
                           if (random[i] == guess[j]) {
                               if (random[i] == guess[i]) {
                                   bull++;
                                   break;
                               } else {
                                   cow++;
                                   break;
                               }
                           }
                       }
                   }

                   word.add("      Bull " + bull + "                                   Cow " + cow);
                   item.notifyDataSetChanged();
                   test.setAdapter(item);

                   if (bull == 5) {
                       alertDialog();
                   }

               }
               else
                   {
                     alert_duplicate();
                   }


            }
        });

      refresh.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              casualbutton.start();
              finish();
              startActivity(getIntent());
          }
      });

       giveup.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
                  casualbutton.start();
                  alert();

           }
       });


    }
    private void alertDialog() {
        bgm.release();
        won.start();
        Animation fade= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fadein);
        dialog.setContentView(R.layout.dialog_win);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        ImageView img=dialog.findViewById(R.id.bullimage);
        TextView downtext=dialog.findViewById(R.id.downtext);
        downtext.setText(clickcount+" chances");
        img.setAnimation(fade);
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bullbuttons.start();
                finish();
                startActivity(getIntent());
                dialog.dismiss();
            }
        });
        dialog.setCancelable(false);
        dialog.create();
        dialog.show();
    }

    private void alert() {
        bgm.release();
        gameover.start();
        Animation fade= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fadein);
        dialog.setContentView(R.layout.dialog_lose);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        ImageView img=dialog.findViewById(R.id.lose_bull);
        TextView downtext=dialog.findViewById(R.id.lose_text);
        downtext.setText(" "+random[0]+"     "+random[1]+"    "+random[2]+"     "+random[3]+"    "+random[4]);
        img.setAnimation(fade);
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bullbuttons.start();
                finish();
                startActivity(getIntent());
                dialog.dismiss();
            }
        });
        dialog.setCancelable(false);
        dialog.create();
        dialog.show();
    }


    private void alert_duplicate() {
        duplicate.start();
        Animation fade= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fadein);
        dialog.setContentView(R.layout.duplication_dialog);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        ImageView img=dialog.findViewById(R.id.duplication_bull);
        img.setAnimation(fade);
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bullbuttons.start();
                dialog.dismiss();
            }
        });
        dialog.setCancelable(false);
        dialog.create();
        dialog.show();
    }

    protected void onPause(){
        super.onPause();
        gameover.release();
        won.release();
        duplicate.release();
        bgm.release();
    }
}
