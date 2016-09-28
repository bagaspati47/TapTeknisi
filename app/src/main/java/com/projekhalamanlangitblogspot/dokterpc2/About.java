package com.projekhalamanlangitblogspot.dokterpc2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.view.View.OnClickListener;

public class About extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tentang);

        //////////////////////////////
        Button btn = (Button) findViewById(R.id.feedback);
        btn.setOnClickListener(new OnClickListener(){

            ////////////// compose email by button sourcecode: https://www.youtube.com/watch?v=O0wrbfKuDEA/////
            @Override
            public void onClick(View v){
                Intent emailIntent = new Intent(Intent.ACTION_SEND);
                emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[]{"gagakitem47@gmail.com"});
                emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Feedback");
                emailIntent.putExtra(Intent.EXTRA_TEXT, "Hi, TapTeknisi: ");
                emailIntent.setType("message/rfc822");
                startActivity(Intent.createChooser(emailIntent, "Pilih aplikasi untuk mengirim feedback.."));

            }

        });

                //////////////////////////
    }
}
