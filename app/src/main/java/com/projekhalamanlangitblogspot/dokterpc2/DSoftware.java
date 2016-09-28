package com.projekhalamanlangitblogspot.dokterpc2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class
        DSoftware extends AppCompatActivity {

    private RadioGroup radioGroup;
    private RadioButton bp1, bp2, bp3, bptnpjeda, bpbrx;
    private Button button, button2;
    private TextView textView1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dsoftware);

        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        radioGroup = (RadioGroup) findViewById(R.id.tipsRgroup2);

        bp1 = (RadioButton) findViewById(R.id.rbeep1);
        bp2 = (RadioButton) findViewById(R.id.rbeep2);
        bp3 = (RadioButton) findViewById(R.id.rbeep3);
        bptnpjeda = (RadioButton) findViewById(R.id.rbeepp);
        bpbrx = (RadioButton) findViewById(R.id.rbeepbrx);

        textView1 = (TextView) findViewById(R.id.textView51);
        button2 = (Button) findViewById(R.id.btnpnjl2);
        button = (Button)findViewById(R.id.button41);
        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                int selectedId = radioGroup.getCheckedRadioButtonId();

                // find which radioButton is checked by id
                if (selectedId == bp1.getId()){
                    textView1.setText("ada banyak kemungkinan di sini, antara OS (Operating System) anda yang corrupt, atau RAM anda bermasalah. Silahkan bersihkan RAM anda, jika masih blue coba repair OS anda");
                    button2.setText("CEK PENJUAL RAM");
                    button2.setVisibility(View.VISIBLE);
                } else if (selectedId == bp2.getId()) {
                    textView1.setText("ada 2 kemungkinan, antara OS anda corrupt atau Hardisk anda lemah");
                    button2.setText("CEK PENJUAL HARDISK");
                    button2.setVisibility(View.VISIBLE);
                } else if (selectedId == bp3.getId()) {
                    textView1.setText("File hilang atau terlihat shortcut2 aneh? segera scan dengan antivirus, ingat! jangan FORMAT PEMANEN. Saran kami gunakan Antivirus USB FIX");
                    button2.setText("CEK PENJUAL VGA");
                    button2.setVisibility(View.GONE);
                } else if (selectedId == bptnpjeda.getId()) {
                    textView1.setText("Layar hitam saja tampilannya? dan ada tulisan REPAIR? coba instal ulang OS anda, kalau tetep Layarnya hitam cek HARDISK");
                    button2.setText("CEK PENJUAL HARDISK");
                    button2.setVisibility(View.VISIBLE);
                } else if (selectedId == bpbrx.getId()) {
                    textView1.setText("Tidak bisa install aplikasi? coba klik kanan pada SETUP kemudian RUN ADMINISTRATOR. RUN ADMINISTRATOR adalah mode dimana sang pengguna menjadi Administrator");
                    button2.setText("CEK PENJUAL HARDISK");
                    button2.setVisibility(View.GONE);
                }
            }
        });
    }

    /////tombol

    public void sendPenjual2(View view)
    {
        Intent intent = new Intent(DSoftware.this, ListPenjual.class);
        startActivity(intent);
    }
    /////tombol

    ///toolbar by http://www.viralandroid.com/2015/08/android-material-design-actionbar-appbar 29 Feb 16

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_about) {
            Intent intent = new Intent(DSoftware.this, About.class);
            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);

    }


}