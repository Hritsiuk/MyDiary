package com.example.mydiary;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    final static Diary diary=Diary.createObject();


    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView textView =(TextView) findViewById(R.id.textView);
        Button button=(Button) findViewById(R.id.button);
        button.setTooltipText("Car");
        textView.setText(button.getTooltipText());
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public void Click(View view) {
        TextView textView =(TextView) findViewById(R.id.textView);
        Button button=(Button) findViewById(R.id.button);
        if(view.getId()==findViewById(R.id.Car).getId())
        {
            view.setTooltipText("Car");

        }
        if(view.getId()==findViewById(R.id.Clothes).getId())
        {
            view.setTooltipText("Clothes");
        }
        if(view.getId()==findViewById(R.id.Ent).getId())
        {
            view.setTooltipText("Ent");
        }
        if(view.getId()==findViewById(R.id.Food).getId())
        {
            view.setTooltipText("Food");
        }
        if(view.getId()==findViewById(R.id.Health).getId())
        {
            view.setTooltipText("Health");
        }

        button.setTooltipText(view.getTooltipText());
        textView.setText(view.getTooltipText());
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public void ClickAdd(View view) {
        setTheme(R.style.Theme_AppCompat);
        EditText money=(EditText) findViewById(R.id.editTextTextPersonName3);
        EditText name=(EditText) findViewById(R.id.editTextTextPersonName4);
        if(!money.getText().toString().equals("") && !name.getText().toString().equals("") ) {
            Button button = (Button) findViewById(R.id.button);
            diary.add(new ModelO(Double.parseDouble(money.getText().toString()), name.getText().toString(), button.getTooltipText().toString()));
            Toast toast = Toast.makeText(this, "Object added", Toast.LENGTH_LONG);
            toast.setGravity(Gravity.TOP, 0, 160);
            toast.show();
        }
        else
        {
            Toast toast = Toast.makeText(this, "One of the fields is empty", Toast.LENGTH_LONG);
            toast.setGravity(Gravity.TOP, 0, 160);
            toast.show();

        }
    }

    public void ClickDayNote(View view) {
        Intent intent=new Intent(this ,MainActivity2.class);
        intent.putExtra("message", "1");
        startActivity(intent);


    }

    public void ClickMonthNote(View view) {

        Intent intent=new Intent(this ,MainActivity2.class);
        intent.putExtra("message", "2");
        startActivity(intent);
    }
}