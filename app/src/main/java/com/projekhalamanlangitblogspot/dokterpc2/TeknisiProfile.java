package com.projekhalamanlangitblogspot.dokterpc2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class TeknisiProfile extends AppCompatActivity {

    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teknisi_profile);
        textView = (TextView) findViewById(R.id.textViewUserName);

        Intent intent = getIntent();

        String username = intent.getStringExtra(Login.USER_NAME);
        textView.setText("Nama: " + username);

    }


}
