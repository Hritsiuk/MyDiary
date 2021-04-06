package com.example.mydiary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
public String categories;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        categories="";
    }

    public void ClickBack(View view) {
        Intent intent=new Intent(this ,MainActivity.class);
        startActivity(intent);
    }

    public void ClickChoose(View view) {
        Intent intent2=getIntent();
        String message = intent2.getStringExtra("message");

        Intent intent=new Intent();
        if(message.equals("1"))
             intent=new Intent(this ,MainActivity3.class);
        else if(message.equals("2"))
            intent=new Intent(this ,MainActivity4.class);

        intent.putExtra("categories", categories);
        startActivity(intent);

    }

    public void ClickCheck(View view) {
        TextView  textView=(TextView) findViewById(R.id.textView6);
        CheckBox checkBox=(CheckBox) view;
        if(!categories.contains(checkBox.getText()))
        categories+=checkBox.getText()+",";


    }
}