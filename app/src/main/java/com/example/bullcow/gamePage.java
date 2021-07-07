package com.example.bullcow;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.NumberPicker;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class gamePage extends AppCompatActivity {



    int n1,n2,n3,n4,n5,i,j,k,l;
    int[] guess = new int[5];
    int[] random = new int[5];
    Random rand= new Random();
    int bull=0,cow=0,clickcount=0;
    ArrayList word=new ArrayList<>();

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_page);
        ListView test=(ListView)findViewById(R.id.testingtext);
        ImageButton bullbutton=(ImageButton)findViewById(R.id.bullbutton);
        TextView rowtext=(TextView)findViewById(R.id.rowid);
        Button refresh=(Button)findViewById(R.id.refresh);
        Button giveup=(Button)findViewById(R.id.giveup);


        NumberPicker num1=(NumberPicker)findViewById(R.id.numbers1);
        num1.setMinValue(0);
        num1.setMaxValue(9);
        num1.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal)
            {
                n1=newVal;

            }
        });
        NumberPicker num2=(NumberPicker)findViewById(R.id.numbers2);
        num2.setMinValue(0);
        num2.setMaxValue(9);
        num2.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal)
            {
                n2=newVal;

            }
        });
        NumberPicker num3=(NumberPicker)findViewById(R.id.numbers3);
        num3.setMinValue(0);
        num3.setMaxValue(9);
        num3.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal)
            {
                n3=newVal;

            }
        });
        NumberPicker num4=(NumberPicker)findViewById(R.id.numbers4);
        num4.setMinValue(0);
        num4.setMaxValue(9);
        num4.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal)
            {
                n4=newVal;

            }
        });
        NumberPicker num5=(NumberPicker)findViewById(R.id.numbers5);
        num5.setMinValue(0);
        num5.setMaxValue(9);
        num5.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal)
            {
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
                clickcount++;
                guess[0]=n1;
                guess[1]=n2;
                guess[2]=n3;
                guess[3]=n4;
                guess[4]=n5;


                for( i=0;i<5;++i)
                {
                    for( j=0;j<5;++j)
                    {
                        if(random[i]==guess[j])
                        {
                            if(random[i]==guess[i])
                            {
                                bull++;
                                break;
                            }
                            else
                                {
                                cow++;
                                break;
                                }
                        }
                    }
                }
                word.add("      Cow "+cow+"                                   Bull "+bull);
                item.notifyDataSetChanged();
                test.setAdapter(item);

                if(bull==5)
                {
                    alertDialog("by "+clickcount+" chances");

                }


            }
        });

      refresh.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              startActivity(getIntent());
          }
      });

       giveup.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
              String str= Arrays.toString(random);
                  alert(str+" is the number");


           }
       });


    }
    private void alertDialog(String message) {
        AlertDialog.Builder dialog=new AlertDialog.Builder(gamePage.this);
        dialog.setMessage(message);
        dialog.setTitle("You Won");
        dialog.setPositiveButton("Refresh",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog,
                                        int which) {
                        startActivity(getIntent());
                    }
                });
        dialog.setCancelable(false);

        AlertDialog alertDialog=dialog.create();
        alertDialog.show();
    }

    private void alert(String message) {
        AlertDialog.Builder dialog=new AlertDialog.Builder(gamePage.this);
        dialog.setMessage(message);
        dialog.setTitle("You Lose");
        dialog.setPositiveButton("Play Again",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog,
                                        int which) {
                        startActivity(getIntent());
                    }
                });
        dialog.setCancelable(false);

        AlertDialog alertDialog=dialog.create();
        alertDialog.show();
    }


}
