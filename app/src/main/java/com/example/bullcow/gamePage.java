package com.example.bullcow;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.NumberPicker;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

public class gamePage extends AppCompatActivity {


    int s=0,n1,n2,n3,n4,n5;
    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_page);
        TextView test=(TextView)findViewById(R.id.testingtext);
        ImageButton bullbutton=(ImageButton)findViewById(R.id.bullbutton);
        ScrollView scrlv=(ScrollView)findViewById(R.id.scrlv);

        NumberPicker num1=(NumberPicker)findViewById(R.id.numbers1);
        num1.setMinValue(0);
        num1.setMaxValue(9);
        num1.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
             n1=newVal;
            }
        });
        NumberPicker num2=(NumberPicker)findViewById(R.id.numbers2);
        num2.setMinValue(0);
        num2.setMaxValue(9);
        num2.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
             n2=newVal;
            }
        });
        NumberPicker num3=(NumberPicker)findViewById(R.id.numbers3);
        num3.setMinValue(0);
        num3.setMaxValue(9);
        num3.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
            n3=newVal;
            }
        });
        NumberPicker num4=(NumberPicker)findViewById(R.id.numbers4);
        num4.setMinValue(0);
        num4.setMaxValue(9);
        num4.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
            n4=newVal;
            }
        });
        NumberPicker num5=(NumberPicker)findViewById(R.id.numbers5);
        num5.setMinValue(0);
        num5.setMaxValue(9);
        num5.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
            n5=newVal;
            }
        });

        bullbutton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                test.setText(n1+" "+n2+" "+n3+" "+n4+" "+n5);
            }
        });




    }
}