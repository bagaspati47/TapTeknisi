package com.projekhalamanlangitblogspot.dokterpc2;

import android.app.ProgressDialog;
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

public class ListTeknisi extends AppCompatActivity {
    private Toolbar toolbar;
    private RecyclerView recyclerView;
    private static final String URL = "http://10.0.3.2//koneksi_android/myjson.php";
    //private static final String URL = "http://tapteknisi.hol.es/koneksi_android/myjson.php";

    private String name, image, number, reputasi;
    private MyTask task;
    private HttpURLConnection urlConnection;
    private URL url;
    private List<Stock> customList;
    private ProgressDialog progressDialog;
    private Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_teknisi_activity);
        toolbar = (Toolbar)findViewById(R.id.toolBar);
        setSupportActionBar(toolbar);
        recyclerView = (RecyclerView)findViewById(R.id.recyclerList);
        recyclerView.setNestedScrollingEnabled(true);
        recyclerView.setHasFixedSize(true);
        final SwipeRefreshLayout swipeRefreshLayout = (SwipeRefreshLayout)findViewById(R.id.swipe);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(ListTeknisi.this);
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
            Snackbar.with(ListTeknisi.this).text("No Internet Connection").actionLabel("Retry").actionListener(new ActionClickListener() {
                @Override
                public void onActionClicked(Snackbar snackbar) {
                    accessWebService();
                    snackbar.dismiss();
                }
            }).show(ListTeknisi.this);
        }

        recyclerView.addOnItemTouchListener(new RecyclerItemClickListener(ListTeknisi.this, new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Toast.makeText(ListTeknisi.this, "Teknisi " + customList.get(position).getName() + " dipilih", Toast.LENGTH_LONG).show();
            }
        }));
    }

    private class MyTask extends AsyncTask<String, Void, List>{

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressDialog = new ProgressDialog(ListTeknisi.this);
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
                customList = new ArrayList<>();
                JSONObject jsonResponse = new JSONObject(jsonResult.toString());
                JSONArray jsonMainNode = jsonResponse.optJSONArray("result");
                for (int i = 0; i < jsonMainNode.length(); i++) {
                    JSONObject jsonChildNode = jsonMainNode.getJSONObject(i);
                    name = jsonChildNode.optString("namateknisi");
                    number = jsonChildNode.optString("nomerhpteknisi");
                    image = jsonChildNode.optString("foto");
                    reputasi = jsonChildNode.optString("reputasi");

                    customList.add(new Stock(name, number, image, reputasi));

                }
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return customList;
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
                ListTeknisi.this.finish();
            }
            return answer;
        }

        @Override
        protected void onPostExecute(List list) {
            ListDrawer(list);
            progressDialog.dismiss();
        }
    }
    public void ListDrawer(List<Stock> customList) {
        adapter = new Adapter(customList);
        adapter.notifyDataSetChanged();
        recyclerView.setAdapter(adapter);
    }

    private void accessWebService(){
        task = new MyTask();
        task.execute(new String[] {URL});
    }
}
