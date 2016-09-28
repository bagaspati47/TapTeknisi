package com.projekhalamanlangitblogspot.dokterpc2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;


public class DHardware extends AppCompatActivity {

    private RadioGroup radioGroup;
    private RadioButton bp1, bp2, bp3, bptnpjeda, bpbrx;
    private Button button, button2;
    private TextView textView;
    private ImageView imgV1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dhardware);


        radioGroup = (RadioGroup) findViewById(R.id.tipsRgroup);

        bp1 = (RadioButton) findViewById(R.id.rbeep1);
        bp2 = (RadioButton) findViewById(R.id.rbeep2);
        bp3 = (RadioButton) findViewById(R.id.rbeep3);
        bptnpjeda = (RadioButton) findViewById(R.id.rbeepp);
        bpbrx = (RadioButton) findViewById(R.id.rbeepbrx);
        imgV1 = (ImageView) findViewById(R.id.imageView8);

        textView = (TextView) findViewById(R.id.textView5);
        button2 = (Button) findViewById(R.id.btnpnjl);
        button = (Button)findViewById(R.id.button4);
        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                int selectedId = radioGroup.getCheckedRadioButtonId();
                imgV1.setVisibility(View.INVISIBLE);

                // find which radioButton is checked by id
                if (selectedId == bp1.getId()) {
                    textView.setText("Masalah ini sering terjadi pada komputer kita yang disebabkan oleh masalah pada perangkat kerasnya.\n\n" +
                            "Terutama processor yang overhat atau terlampau panas. Panas berlebihnya processor ini biasa disebabkan oleh kinerja kipas" +
                            "pendingan yang kurang maksimal,\n" + "atau juga termal pasta pada processor sudah mengering.");
                    button2.setText("CEK PENJUAL FAN");
                    button2.setVisibility(View.VISIBLE);
                    imgV1.setImageResource(R.drawable.mobproc);
                    imgV1.setVisibility(View.VISIBLE);
                } else if (selectedId == bp2.getId()) {
                    textView.setText("Bunyi beep ini biasanya terdengar ketika pertama kali kita menyalakan komputer. Bunyi beep ini biasanya terdengar\n" +
                            "apabila terjadi kesalahan pada salah satu hardware yang terpasang pada komputer. Karena banyak produk BIOS\n" +
                            "dipasaran, maka kode beep yang terdengar pun bervariasi dengan berbagai permasalahannya. Namun perlu diingat,\n" +
                            "tidak semua beep itu berarti terdapat masalah, karena ada beberapa BIOS yang memang mengeluarkan bunyi beep\n" +
                            "sekali pada saat awal booting, dan itu menandakan komputer normal.");
                    button2.setText("CEK PENJUAL CMOS");
                    button2.setVisibility(View.VISIBLE);
                    imgV1.setImageResource(R.drawable.cmos);
                    imgV1.setVisibility(View.VISIBLE);

                } else if (selectedId == bp3.getId()) {
                    textView.setText("Masalah ini umumnya terjadi akibat RAM yang tidak terdeteksi sempurna. Karena fungsi sebuah RAM adalah sebagai\n" +
                            "penyimpanan sementara (menyimpan proses yang berjalan), jadi jika RAM tersebut bermasalah maka tidak ada\n" +
                            "perangkat yang bisa menyimpan proses yang sedang berjalan, sehingga tidak ada yang bisa ditampilkan pada monitor.\n" +
                            "Selain RAM, bisa juga karena kabel VGA yang terhubung ke monitor tidak tersambung dengan baik. Apabila Anda\n" +
                            "menggunakan VGA Card, maka tidak perlu lagi menhubungkan kebel VGA melalui port VGA onboard yang ada di\n" +
                            "motherboard.\n");
                    button2.setText("CEK PENJUAL RAM dan VGA");
                    button2.setVisibility(View.VISIBLE);
                    imgV1.setImageResource(R.drawable.ram);
                    imgV1.setVisibility(View.VISIBLE);
                } else if (selectedId == bptnpjeda.getId()) {
                    textView.setText("Pada kondisi mati total ini, biasanya berhubungan dengan arus listrik, apa komputer mendapat suplly arus listrik atau\n" +
                            "tidak. Sehingga apabila komputer tidak mendapat suply listrik, maka bisa dipastikan komputer tidak akan pernah\n" +
                            "menyala. Anda bisa melakukan pengecekan mulai dari kabel power yang mengarah ke sumber listrik, power suply, atau\n" +
                            "bahkan kabel-kabel front panel-nya. Apabila tidak ada masalah pada suply listrik, bisa dipastikan motherboard yang\n" +
                            "bermasalah.");
                    button2.setText("CEK PENJUAL POWERSUPPLY");
                    button2.setVisibility(View.VISIBLE);
                    imgV1.setImageResource(R.drawable.psu);
                    imgV1.setVisibility(View.VISIBLE);
                } else if (selectedId == bpbrx.getId()) {
                    textView.setText("Biasanya kondisi komputer yang HANG ini disebabkan oleh tingginya data yang diproses tanpa mengimbangi\n" +
                            "kemampuan processor dan memory RAM dalam mem-buffer atau menampung sementara data yang diproses. Karena\n" +
                            "RAM memiliki kapasitas yang terbatas, maka semakin banyak aplikasi dijalankan maka kapasitas RAM tersebut akan\n" +
                            "semakin berkurang dan habis. Nah pada kondisi ini, komputer akan mengalami HANG karena tidak kuat menjalankan\n" +
                            "perintah yang sedang dieksekusi.");
                    button2.setText("CEK PENJUAL RAM");
                    button2.setVisibility(View.VISIBLE);
                    imgV1.setImageResource(R.drawable.ram);
                    imgV1.setVisibility(View.VISIBLE);
                }
            }
        });
    }

    /////tombol

    public void sendPenjual(View view)
    {
        Intent intent = new Intent(DHardware.this, ListPenjual.class);
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
            Intent intent = new Intent(DHardware.this, About.class);
            startActivity(intent);
            return true;
        }


        return super.onOptionsItemSelected(item);

    }

    ////
}