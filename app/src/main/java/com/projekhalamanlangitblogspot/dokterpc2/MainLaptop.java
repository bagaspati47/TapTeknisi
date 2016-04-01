package com.projekhalamanlangitblogspot.dokterpc2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainLaptop extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_laptop);
        findViewById(R.id.Lhardwarebtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainLaptop.this, LHardware.class));
            }
        });

        findViewById(R.id.Lsoftwarebtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainLaptop.this, LSoftware.class));
            }
        });
    }

    /**tombol

    public void sendLhardware(View view)
    {
        Intent intent = new Intent(MainLaptop.this, LHardware.class);
        startActivity(intent);
    }
    /////tombol

    /////tombol

    public void sendLsoftware(View view)
    {
        Intent intent = new Intent(MainLaptop.this, LSoftware.class);
        startActivity(intent);
    }
    tombol*/
}
