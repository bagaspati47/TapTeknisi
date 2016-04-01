package com.projekhalamanlangitblogspot.dokterpc2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import android.widget.Toolbar;

public class Utama extends AppCompatActivity {

    Animation animFadein;
    TextView txtutm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_utama);

        txtutm = (TextView) findViewById(R.id.txtutm);

        findViewById(R.id.btncekteknisi).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Utama.this, ListTeknisi.class));
            }
        });
        findViewById(R.id.txtDaftarTeknisi).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Utama.this, RegisterActivity.class));
            }
        });
        findViewById(R.id.btnutama).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Utama.this, Petunjuk.class));
            }
        });

        // load the animation by Ravi Tamada http://www.androidhive.info/2013/06/android-working-with-xml-animations/#fade_in
        // @ 1 April 2016
        animFadein = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.fade_in);

        txtutm.startAnimation(animFadein);
    }

///sembunyikan actionBar by stackoverflow.com 26 Feb 16
    @Override
    public void setActionBar(Toolbar toolbar) {
        super.setActionBar(toolbar);
        getActionBar().hide();
    }


    /////tombol

    /**public void sendGuide(View view)
    {
        Intent intent = new Intent(Utama.this, Petunjuk.class);
        startActivity(intent);
    }
    /////tombol

    /////tombol

    /**public void sendRegTek(View view)
    {
        Intent intent = new Intent(Utama.this, RegisterActivity.class);
        startActivity(intent);
    }
    /////tombol

    public void sendCekTeknisi(View view)
    {
        Intent intent = new Intent(Utama.this, ListTeknisi.class);
        startActivity(intent);
    }
    tombol

     */
}
