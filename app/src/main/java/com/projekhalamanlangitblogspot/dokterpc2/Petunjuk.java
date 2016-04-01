package com.projekhalamanlangitblogspot.dokterpc2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class Petunjuk extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_petunjuk);
        findViewById(R.id.button4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Petunjuk.this, Tabs.class));
            }
        });
    }

    /**tombol

    public void sendTabs(View view)
    {
        Intent intent = new Intent(Petunjuk.this, Tabs.class);
        startActivity(intent);
    }
    tombol*/
}
