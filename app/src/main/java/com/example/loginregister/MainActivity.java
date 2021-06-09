package com.example.loginregister;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button click;
    Button click2;
    public static TextView data;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        click = (Button) findViewById(R.id.buttonAPI1);
        click2 = (Button) findViewById(R.id.buttonAPI2);
        data = (TextView) findViewById(R.id.dataAPI1);


        click2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                dataAPI2 process = new dataAPI2();
                process.execute();
            }
        });

        click.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dataAPI1 process = new dataAPI1();
                process.execute();
            }
        } );
    }
}