package com.example.suraj.calculator;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        // Get the Intent that started this activity and extract the string
        Intent intent = getIntent();
        String message = intent.getStringExtra("message");

        // Capture the layout's TextView and set the string as its text
        TextView textView = (TextView)findViewById(R.id.output);
        textView.setText(message);

    }

    public void onButtonClick(View v)
    {
        EditText firNum = (EditText)findViewById(R.id.num1);
        EditText secNum = (EditText)findViewById(R.id.num2);
        TextView tv = (TextView)findViewById(R.id.ans);

        double n1 = Double.parseDouble(firNum.getText().toString());
        double n2 = Double.parseDouble(secNum.getText().toString());

        double add = n1 + n2;
        tv.setText(Double.toString(add));
        Toast.makeText(Main2Activity.this,"Answer :" + Double.toString(add), Toast.LENGTH_SHORT).show();

    }
}
