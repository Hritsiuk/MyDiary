package com.example.mydiary;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Calendar;

public class MainActivity4 extends AppCompatActivity {
    public Diary diary=Diary.createObject();
    @RequiresApi(api = Build.VERSION_CODES.O)
    @SuppressLint({"UseCompatLoadingForDrawables", "SetTextI18n"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        Intent intent = getIntent();
        String words= intent.getStringExtra("categories");

        LinearLayout layout=(LinearLayout) findViewById(R.id.linear);


        if(!diary.getListCategories(words).isEmpty())
        for (ModelO abc:(ArrayList<ModelO>)diary.getListCategories(words)
             ) {
            LinearLayout linearLayout=new LinearLayout(this);
            LinearLayout.LayoutParams params3=new LinearLayout.LayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,350));
            linearLayout.setBackground(this.getResources().getDrawable(R.drawable.border));
            linearLayout.setLayoutParams(params3);
            linearLayout.setOrientation(LinearLayout.HORIZONTAL);

            LinearLayout child1=new LinearLayout(this);
            LinearLayout.LayoutParams params4=new LinearLayout.LayoutParams(new ViewGroup.LayoutParams(300,350));

            child1.setLayoutParams(params4);

            ImageButton button=new ImageButton(this);
            button.setBackground(this.getResources().getDrawable(getdrawablebytype(abc)));

            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(200, 200);
            params.setMargins(50,50,50,50);
            button.setLayoutParams(params);

            child1.addView(button);





            LinearLayout child2=new LinearLayout(this);


            LinearLayout.LayoutParams params5=new LinearLayout.LayoutParams(new ViewGroup.LayoutParams(1400,350));
            child2.setLayoutParams(params5);
            child2.setOrientation(LinearLayout.VERTICAL);


            LinearLayout childc3=new LinearLayout(this);

            LinearLayout.LayoutParams params6=new LinearLayout.LayoutParams(new ViewGroup.LayoutParams(1400,175));
            childc3.setLayoutParams(params6);


            TextView textView3=new TextView(this);
            textView3.setTextColor(Color.BLACK);
            textView3.setText(abc.getName());
            textView3.setTextSize(25);
            textView3.setPadding(50,20,20,20);


            TextView textView2=new TextView(this);
            textView2.setText("- "+abc.getMoney()+"");
            textView2.setTextSize(25);
            textView2.setPadding(50,20,20,20);
            textView2.setTextColor(Color.RED);

            LinearLayout layoutname=new LinearLayout(this);
            LinearLayout.LayoutParams params1=new LinearLayout.LayoutParams(new ViewGroup.LayoutParams(650,165));
            layoutname.setLayoutParams(params1);
            layoutname.addView(textView3);




            childc3.addView(layoutname);
            childc3.addView(textView2);





            child2.addView(childc3);

            LinearLayout childc4=new LinearLayout(this);

            childc3.setLayoutParams(params6);
            child2.addView(childc4);






            TextView textView=new TextView(this);
            textView.setTextColor(Color.BLACK);
            textView.setText(abc.getDate()+" "+abc.getTime().getHour()+":"+abc.getTime().getMinute());
            textView.setPadding(700,70,20,20);
            childc4.addView(textView);
            linearLayout.addView(child1);
            linearLayout.addView(child2);
            layout.addView(linearLayout);
        }
        else {
            TextView textView = new TextView(this);

            textView.setTextSize(30);
            textView.setGravity(Gravity.CENTER_HORIZONTAL);
            textView.setText("no notes");
            layout.addView(textView);
        }
    }
public int getdrawablebytype(ModelO model)
{

    if(model.getType().equals("Car"))
    {
        return  R.drawable.car2;

    }
    else if(model.getType().equals("Clothes"))
    {
        return  R.drawable.clothes2;

    }
    else if(model.getType().equals("Ent"))
    {
        return  R.drawable.ent4;
    }
    else if(model.getType().equals("Food"))
    {
        return  R.drawable.food3;
    }
    else if(model.getType().equals("Health"))
    {
        return  R.drawable.health2;
    }
    else
        return 0;
}
    public void ClickBack(View view) {
        Intent intent=new Intent(this ,MainActivity.class);
        startActivity(intent);
    }
}