package com.projekhalamanlangitblogspot.dokterpc2;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.HashMap;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText editTextName;
    private EditText editTextEmail;
    private EditText editTextHp;
    private EditText editTextFotoLink;
    private ProgressDialog progressDialog;

    private Button buttonRegister;

    private Button buttonLogin;

    ////alamat php register (untuk menginput ke database mysql)

    private static final String REGISTER_URL = "http://tapteknisi.hol.es/koneksi_android/register.php";
    //private static final String REGISTER_URL = "http://tapteknisi.hol.es/koneksi_android/register.php";
    ////

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        editTextName = (EditText) findViewById(R.id.editTextName);
        editTextEmail = (EditText) findViewById(R.id.editTextEmail);
        editTextHp = (EditText) findViewById(R.id.editTextHp);
        editTextFotoLink = (EditText) findViewById(R.id.editTextFotoLink);

        buttonRegister = (Button) findViewById(R.id.buttonRegister);

        buttonLogin = (Button) findViewById(R.id.buttonLogin);

        buttonRegister.setOnClickListener(this);

        buttonLogin.setOnClickListener(this);
    }
    public void drive (View view){
        Intent driveIntent=new Intent(Intent.ACTION_VIEW,Uri.parse("https://drive.google.com/folderview?id=0BxlJHYxZTqirS0NURkZFRDNNSkk&usp=sharing"));
        startActivity(driveIntent);
    }
    /**
     * kode koneksi tombol ke activity lain.
     * sourcecode by juned on 2/11/12 http://stackoverflow.com/questions/13194081/how-to-open-a-second-activity-on-click-of-button-in-android-app
     */
    /////////////////////////////////////////////////////////////////////



    ///////////////////////////////////////////////////////////////////////

    @Override
    public void onClick(View v) {
        if (v == buttonRegister) {
            registerUser();
        }
        if (v == buttonLogin) {
            startActivity(new Intent(this, StatusActivity.class));
        }
    }

    private void registerUser() {
        String nm_teknisi = editTextName.getText().toString().trim();
        String hp_teknisi = editTextHp.getText().toString().trim();
        String email = editTextEmail.getText().toString().trim();
        String fp_link = editTextFotoLink.getText().toString().trim();

        register(nm_teknisi, hp_teknisi, email, fp_link);
    }

    private void register(String nm_teknisi, String hp_teknisi, String email, String fp_link) {
        class RegisterUser extends AsyncTask<String, Void, String> {
            ProgressDialog loading;
            RequestHandler ruc = new RequestHandler();


            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(RegisterActivity.this, "Please Wait", null, true, true);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                Toast.makeText(getApplicationContext(), s, Toast.LENGTH_LONG).show();
            }

            @Override
            protected String doInBackground(String... params) {

                HashMap<String, String> data = new HashMap<String, String>();
                data.put("nm_teknisi", params[0]);
                data.put("hp_teknisi", params[1]);
                data.put("email", params[2]);
                data.put("fp_link", params[3]);

                String result = ruc.sendPostRequest(REGISTER_URL, data);

                return result;
            }
        }

        RegisterUser ru = new RegisterUser();
        ru.execute(nm_teknisi, hp_teknisi, email, fp_link);
    }

}