package com.kodingindonesia.mycrud;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;

public class TampilAnggota extends AppCompatActivity implements View.OnClickListener{


    private EditText idAnggota;
    private EditText kecamatan;
    private EditText desa;
    private EditText namaAnggota;
    private EditText luasLahan;
    private EditText jenisLahan;
    private EditText petak;
    private EditText premi;
    private Button buttonUpdate;
    private Button buttonDelete;

    private String id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tampil_anggota);

        Intent intent = getIntent();

        id = intent.getStringExtra(konfigurasi.AGT_ID);

        idAnggota = (EditText) findViewById(R.id.idAnggota);
        kecamatan = (EditText) findViewById(R.id.kecamatan);
        desa = (EditText) findViewById(R.id.desa);
        namaAnggota = (EditText) findViewById(R.id.namaAnggota);
        luasLahan = (EditText) findViewById(R.id.luasLahan);
        jenisLahan = (EditText) findViewById(R.id.jenisLahan);
        petak = (EditText) findViewById(R.id.petak);
        premi = (EditText) findViewById(R.id.premi);

        buttonUpdate = (Button) findViewById(R.id.buttonUpdate);
        buttonDelete = (Button) findViewById(R.id.buttonDelete);

        buttonUpdate.setOnClickListener(this);
        buttonDelete.setOnClickListener(this);

        idAnggota.setText(id);
        getEmployee();
    }

    private void getEmployee(){
        class GetEmployee extends AsyncTask<Void,Void,String> {
            ProgressDialog loading;
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(TampilAnggota.this,"Fetching...","Wait...",false,false);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                showEmployee(s);
            }

            @Override
            protected String doInBackground(Void... params) {
                RequestHandler rh = new RequestHandler();
                String s = rh.sendGetRequestParam(konfigurasi.URL_AGT_GET_EMP,id);
                return s;
            }
        }
        GetEmployee ge = new GetEmployee();
        ge.execute();
    }

    private void showEmployee(String json){
        try {
            JSONObject jsonObject = new JSONObject(json);
            JSONArray result = jsonObject.getJSONArray(konfigurasi.TAG_AGT_JSON_ARRAY);
            JSONObject c = result.getJSONObject(0);
            String kec = c.getString(konfigurasi.TAG_AGT_KEC);
            String des = c.getString(konfigurasi.TAG_AGT_DESA);
            String nama = c.getString(konfigurasi.TAG_AGT_NAMA);
            String luas = c.getString(konfigurasi.TAG_AGT_LUAS);
            String jenis = c.getString(konfigurasi.TAG_AGT_JENIS);
            String peta = c.getString(konfigurasi.TAG_AGT_JUMLAH);
            String prem = c.getString(konfigurasi.TAG_AGT_PREMI);

            kecamatan.setText(kec);
            desa.setText(des);
            namaAnggota.setText(nama);
            luasLahan.setText(luas);
            jenisLahan.setText(jenis);
            petak.setText(peta);
            premi.setText(prem);


        } catch (JSONException e) {
            e.printStackTrace();
        }
    }


    private void updateEmployee(){
        final String kec = kecamatan.getText().toString().trim();
        final String des = desa.getText().toString().trim();
        final String nama = namaAnggota.getText().toString().trim();
        final String luas = luasLahan.getText().toString().trim();
        final String jenis = jenisLahan.getText().toString().trim();
        final String peta = petak.getText().toString().trim();
        final String prem = premi.getText().toString().trim();

        class UpdateEmployee extends AsyncTask<Void,Void,String>{
            ProgressDialog loading;
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(TampilAnggota.this,"Updating...","Wait...",false,false);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                Toast.makeText(TampilAnggota.this,s,Toast.LENGTH_LONG).show();
            }

            @Override
            protected String doInBackground(Void... params) {
                HashMap<String,String> hashMap = new HashMap<>();
                hashMap.put(konfigurasi.KEY_AGT_ID,id);
                hashMap.put(konfigurasi.KEY_AGT_KEC,kec);
                hashMap.put(konfigurasi.KEY_AGT_DESA,des);
                hashMap.put(konfigurasi.KEY_AGT_NAMA,nama);
                hashMap.put(konfigurasi.KEY_AGT_LUAS,luas);
                hashMap.put(konfigurasi.KEY_AGT_JENIS,jenis);
                hashMap.put(konfigurasi.KEY_AGT_JUMLAH,peta);
                hashMap.put(konfigurasi.KEY_AGT_PREMI,prem);

                RequestHandler rh = new RequestHandler();

                String s = rh.sendPostRequest(konfigurasi.URL_AGT_UPDATE_EMP,hashMap);

                return s;
            }
        }

        UpdateEmployee ue = new UpdateEmployee();
        ue.execute();
    }

    private void deleteEmployee(){
        @SuppressLint("StaticFieldLeak")
        class DeleteEmployee extends AsyncTask<Void,Void,String> {
            ProgressDialog loading;

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(TampilAnggota.this, "Updating...", "Tunggu...", false, false);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                Toast.makeText(TampilAnggota.this, s, Toast.LENGTH_LONG).show();
            }

            @Override
            protected String doInBackground(Void... params) {
                RequestHandler rh = new RequestHandler();
                String s = rh.sendGetRequestParam(konfigurasi.URL_AGT_DELETE_EMP, id);
                return s;
            }
        }

        DeleteEmployee de = new DeleteEmployee();
        de.execute();
    }

    private void confirmDeleteEmployee(){
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setMessage("Apakah Kamu Yakin Ingin Menghapus Anggota ini?");

        alertDialogBuilder.setPositiveButton("Ya",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface arg0, int arg1) {
                        deleteEmployee();
                        startActivity(new Intent(TampilAnggota.this,TampilSemuaKlp.class));
                    }
                });

        alertDialogBuilder.setNegativeButton("Tidak",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface arg0, int arg1) {

                    }
                });

        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }

    @Override
    public void onClick(View v) {
        if(v == buttonUpdate){
            updateEmployee();
            startActivity(new Intent(this,TampilSemuaAgt.class));
        }

        if(v == buttonDelete){
            confirmDeleteEmployee();
        }
    }
}
