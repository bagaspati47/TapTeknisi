package com.projekhalamanlangitblogspot.dokterpc2;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TabHost;

public class Tabs extends TabActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tabs);

        TabHost tabHost = getTabHost();

        TabHost.TabSpec formDekstop = tabHost.newTabSpec("Desktop");
        formDekstop.setIndicator("Desktop");
        Intent formDekstopIntent = new Intent(this, MainDesktop.class);
        formDekstop.setContent(formDekstopIntent);


        TabHost.TabSpec formLaptop = tabHost.newTabSpec("Laptop");
        formLaptop.setIndicator("Laptop");
        Intent formLaptopIntent = new Intent(this, MainLaptop.class);
        formLaptop.setContent(formLaptopIntent);


        tabHost.addTab(formDekstop);
        tabHost.addTab(formLaptop);

    }
}