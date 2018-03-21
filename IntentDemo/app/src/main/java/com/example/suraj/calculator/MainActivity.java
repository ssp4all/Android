package com.example.suraj.calculator;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{
    Button Dial,Google,calc;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText name = (EditText)findViewById(R.id.name);
        Dial=(Button)findViewById(R.id.dial);
        Google=(Button)findViewById(R.id.google);
        calc = (Button)findViewById(R.id.calculator);

        //open dial
        Dial.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View view)
            {
                Intent i = new Intent(android.content.Intent.ACTION_DIAL,
                        Uri.parse("tel:"+name.getText()));
                startActivity(i);
            }
        });

        //open google
        Google.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view)
            {
                Intent i = new Intent(android.content.Intent.ACTION_VIEW,
                        Uri.parse("http://www.google.com/"+name.getText()));
                startActivity(i);
            }
        });

        //Open Calculator
        calc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0)
            {
                Toast.makeText( getApplicationContext(),name.getText(), Toast.LENGTH_LONG).show();
                Intent i = new Intent(MainActivity.this,Main2Activity.class);
                i.putExtra("message","Welcome "+name.getText().toString()) ;
                startActivity(i);
            }
        });

    }
}