package com.projekhalamanlangitblogspot.dokterpc2;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import com.nispok.snackbar.Snackbar;
import com.nispok.snackbar.listeners.ActionClickListener;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class ListPenjual extends AppCompatActivity {
    private RecyclerView recyclerView;
    private static final String URL = "http://tapteknisi.hol.es/koneksi_android/myjson2.php";
    //private static final String URL = "http://tapteknisi.hol.es/koneksi_android/myjson.php";

    private String namatoko, link, stson;
    private MyTask task;
    private HttpURLConnection urlConnection;
    private URL url;
    private List<Stock2> customList2;
    private ProgressDialog progressDialog;
    private AdapterPenjual adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_penjual);
        findViewById(R.id.buttonGmaps).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ListPenjual.this, MapsActivity.class));
            }
        });
        recyclerView = (RecyclerView)findViewById(R.id.recyclerList2);
        recyclerView.setNestedScrollingEnabled(true);
        recyclerView.setHasFixedSize(true);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        final SwipeRefreshLayout swipeRefreshLayout = (SwipeRefreshLayout)findViewById(R.id.swipe);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(ListPenjual.this);
        recyclerView.setLayoutManager(linearLayoutManager);
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        boolean connected = networkInfo!=null && networkInfo.isAvailable() && networkInfo.isConnectedOrConnecting();
        if (connected){
            accessWebService();
            swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
                @Override
                public void onRefresh() {
                    accessWebService();
                    swipeRefreshLayout.setRefreshing(false);
                }
            });
        }else {
            Snackbar.with(ListPenjual.this).text("No Internet Connection").actionLabel("Retry").actionListener(new ActionClickListener() {
                @Override
                public void onActionClicked(Snackbar snackbar) {
                    accessWebService();
                    snackbar.dismiss();
                }
            }).show(ListPenjual.this);
        }

        recyclerView.addOnItemTouchListener(new RecyclerItemClickListener(ListPenjual.this, new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Toast.makeText(ListPenjual.this, "Penjual " + customList2.get(position).getNama() + " dipilih", Toast.LENGTH_LONG).show();
            }
        }));
    }
    /////////////////////////
    public void about(View view)
    {
        Intent intent = new Intent(ListPenjual.this, About.class);
        startActivity(intent);
    }
    //////////////////////////////
    private class MyTask extends AsyncTask<String, Void, List>{

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressDialog = new ProgressDialog(ListPenjual.this);
            progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
            progressDialog.setIndeterminate(true);
            progressDialog.setMessage("Tolong tunggu...");
            progressDialog.setCancelable(true);
            progressDialog.show();
        }

        @Override
        protected List doInBackground(String... params) {
            try {
                url = new URL(params[0]);
                urlConnection =(HttpURLConnection) url.openConnection();
                urlConnection.connect();
                urlConnection.setConnectTimeout(5000);
                InputStream in = new BufferedInputStream(urlConnection.getInputStream());
                StringBuilder jsonResult = inputStreamToString(in);
                customList2 = new ArrayList<>();
                JSONObject jsonResponse = new JSONObject(jsonResult.toString());
                JSONArray jsonMainNode = jsonResponse.optJSONArray("result");
                for (int i = 0; i < jsonMainNode.length(); i++) {
                    JSONObject jsonChildNode = jsonMainNode.getJSONObject(i);
                    namatoko = jsonChildNode.optString("nm_penjual");
                    link = jsonChildNode.optString("link_penjual");
                    stson = jsonChildNode.optString("status_online");

                    customList2.add(new Stock2(namatoko, link, stson));

                }
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return customList2;
        }

        private StringBuilder inputStreamToString(InputStream is) {
            String rLine = "";
            StringBuilder answer = new StringBuilder();
            BufferedReader rd = new BufferedReader(new InputStreamReader(is));
            try {
                while ((rLine = rd.readLine()) != null) {
                    answer.append(rLine);
                }
            } catch (Exception e) {
                ListPenjual.this.finish();
            }
            return answer;
        }

        @Override
        protected void onPostExecute(List list) {
            ListDrawer(list);
            progressDialog.dismiss();
        }
    }
    public void ListDrawer(List<Stock2> customList2) {
        adapter = new AdapterPenjual(customList2);
        adapter.notifyDataSetChanged();
        recyclerView.setAdapter(adapter);
    }

    private void accessWebService(){
        task = new MyTask();
        task.execute(new String[] {URL});
    }
}
