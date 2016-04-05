package com.projekhalamanlangitblogspot.dokterpc2;

import android.app.ProgressDialog;
import android.content.Intent;
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
    private EditText editTextUsername;
    private EditText editTextPassword;
    private EditText editTextEmail;
    private EditText editTextHp;
    private EditText editTextFotoLink;
    private ProgressDialog progressDialog;

    private Button buttonRegister;

    private Button buttonLogin;

    ////alamat php register (untuk menginput ke database mysql)

    private static final String REGISTER_URL = "http://10.0.3.2/koneksi_android/register.php";
    //private static final String REGISTER_URL = "http://tapteknisi.hol.es/koneksi_android/register.php";
    ////

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        editTextName = (EditText) findViewById(R.id.editTextName);
        editTextUsername = (EditText) findViewById(R.id.editTextUserName);
        editTextPassword = (EditText) findViewById(R.id.editTextPassword);
        editTextEmail = (EditText) findViewById(R.id.editTextEmail);
        editTextHp = (EditText) findViewById(R.id.editTextHp);
        editTextFotoLink = (EditText) findViewById(R.id.editTextFotoLink);

        buttonRegister = (Button) findViewById(R.id.buttonRegister);

        buttonLogin = (Button) findViewById(R.id.buttonLogin);

        buttonRegister.setOnClickListener(this);

        buttonLogin.setOnClickListener(this);
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
            startActivity(new Intent(this, Login.class));
        }
    }

    private void registerUser() {
        String namateknisi = editTextName.getText().toString().trim();
        String username = editTextUsername.getText().toString().trim();
        String katasandi = editTextPassword.getText().toString().trim();
        String nomerhpteknisi = editTextHp.getText().toString().trim();
        String email = editTextEmail.getText().toString().trim();
        String foto = editTextFotoLink.getText().toString().trim();

        register(namateknisi, username, katasandi, nomerhpteknisi, email, foto);
    }

    private void register(String namateknisi, String username, String katasandi, String nomerhpteknisi, String email, String foto) {
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
                data.put("namateknisi", params[0]);
                data.put("username", params[1]);
                data.put("katasandi", params[2]);
                data.put("nomerhpteknisi", params[3]);
                data.put("email", params[4]);
                data.put("foto", params[5]);

                String result = ruc.sendPostRequest(REGISTER_URL, data);

                return result;
            }
        }

        RegisterUser ru = new RegisterUser();
        ru.execute(namateknisi, username, katasandi, nomerhpteknisi, email, foto);
    }

}