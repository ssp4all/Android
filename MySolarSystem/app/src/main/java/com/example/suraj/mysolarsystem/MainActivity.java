package com.example.suraj.mysolarsystem;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity
{
    private Spinner planets;
    ImageView imgPlanets;

    // Planets names
    final String[] planetnames = {"Earth", "Mars", "Saturn", "Sun", "Uranus"};
    // Planets image animalIDs
    // Both names and image PlanetIDs are in the same order
    final int[] imgPlanetIDs = {R.drawable.earth, R.drawable.mars, R.drawable.saturn, R.drawable.sun, R.drawable.uranus};

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Find the GUI components.
        this.planets = (Spinner) findViewById(R.id.planets);
        this.imgPlanets = (ImageView) findViewById(R.id.imgPlanets);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item , planetnames );
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        this.planets.setAdapter(adapter);

        // Set the message to default.
        this.planets.setSelection(0);

        // Set item selected listener.
        this.planets.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
            {
                imgPlanets.setImageResource(imgPlanetIDs[position]);
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent)
            {
                // Do nothing
            }
        });
    }
}
