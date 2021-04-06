package com.example.mydiary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;

import java.util.ArrayList;
import java.util.List;

public class MainActivity3 extends AppCompatActivity {
    public Diary diary=Diary.createObject();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        Intent intent = getIntent();
        String[] words= intent.getStringExtra("categories").split(",");


        BarChart chart = (BarChart) findViewById(R.id.chart);

        List<BarEntry> entries = new ArrayList<BarEntry>();


        for(int i=0;i<words.length;i++)
        {
            entries.add(new BarEntry(i,(int)diary.getmoneycategories(words[i])));
        }
        BarDataSet[] bar=new BarDataSet[words.length];

        for(int i=0;i<words.length;i++)
        {


            bar[i]=new BarDataSet(entries,words[i]);

        }
        BarData lineData = new BarData(bar);
        chart.setData(lineData);
        chart.invalidate(); // refresh




    }

    public void ClickBack(View view) {
        Intent intent=new Intent(this ,MainActivity.class);
        startActivity(intent);
    }
}