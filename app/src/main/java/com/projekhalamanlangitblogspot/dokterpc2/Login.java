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

public class Login extends AppCompatActivity implements View.OnClickListener{

    public static final String USER_NAME = "USER_NAME";

    //public static final String PASSWORD = "PASSWORD";

    ////alamat php login (untuk memanggil ke database mysql)

    private static final String LOGIN_URL = "http://10.0.3.2/koneksi_android/login.php";
    //GENY/VBOX
    //private static final String LOGIN_URL = "http://tapteknisi.hol.es/koneksi_android/login.php";
    //AVM
    //private static final String LOGIN_URL = "http://10.0.2.2/123/login.php";
    ///

    private EditText editTextUserName;
    private EditText editTextPassword;

    private Button buttonLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        editTextUserName = (EditText) findViewById(R.id.username);
        editTextPassword = (EditText) findViewById(R.id.password);

        buttonLogin = (Button) findViewById(R.id.buttonUserLogin);

        buttonLogin.setOnClickListener(this);


        /**
         * kode koneksi tombol ke activity lain.
         * sourcecode by juned on 2/11/12 http://stackoverflow.com/questions/13194081/how-to-open-a-second-activity-on-click-of-button-in-android-app
         */
        /////////////////////////////////////////////////////////////////////
    }

    public void sendMessage(View view)
    {
        Intent intent = new Intent(Login.this, RegisterActivity.class);
        startActivity(intent);
    }
    /////////////////////////////////////////////////////////////////////

    private void login(){
        String username = editTextUserName.getText().toString().trim();
        String katasandi = editTextPassword.getText().toString().trim();
        userLogin(username,katasandi);
    }

    private void userLogin(final String username, final String katasandi){
        class UserLoginClass extends AsyncTask<String,Void,String>{
            ProgressDialog loading;
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(Login.this,"Proses..",null,true,true);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                if(s.equalsIgnoreCase("success")){
                    Intent intent = new Intent(Login.this,TeknisiProfile.class);
                    intent.putExtra(USER_NAME,username);
                    startActivity(intent);
                }else{
                    Toast.makeText(Login.this,"galat, cek koneksi internet kamu.", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            protected String doInBackground(String... params) {
                HashMap<String,String> data = new HashMap<>();
                data.put("username",params[0]);
                data.put("katasandi",params[1]);

                RequestHandler ruc = new RequestHandler();

                String result = ruc.sendPostRequest(LOGIN_URL,data);

                return result;
            }
        }
        UserLoginClass ulc = new UserLoginClass();
        ulc.execute(username,katasandi);
    }

    @Override
    public void onClick(View v) {
        if(v == buttonLogin){
            login();
        }
    }
}