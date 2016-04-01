package com.projekhalamanlangitblogspot.dokterpc2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainDesktop extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_dekstop);
        findViewById(R.id.Dhardwarebtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainDesktop.this, DHardware.class));
            }
        });

        findViewById(R.id.Dsoftwarebtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainDesktop.this, DSoftware.class));
            }
        });

    }

    /**

     /////tombol

     public void sendDhardware(View view)
     {
     Intent intent = new Intent(MainDesktop.this, DHardware.class);
     startActivity(intent);
     finish();
     }
     /////tombol

     /////tombol

     public void sendDsoftware(View view)
     {
     Intent intent = new Intent(MainDesktop.this, DSoftware.class);
     startActivity(intent);
     finish();
     }
     /////tombol

     */
}
