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

/**
 * Created by muhammadyusuf on 01/19/2017.
 * kodingindonesia
 */

public class TampilKelompok extends AppCompatActivity implements View.OnClickListener{

    private EditText idKelompok;
    private EditText kelompok;
    private EditText ketuaKelompok;
    private EditText luasLahan;
    private EditText noHP;
    private EditText musimTanam;
    private EditText kiraTanam;

    private Button buttonUpdate;
    private Button buttonDelete;

    private String id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tampil_pegawai);

        Intent intent = getIntent();

        id = intent.getStringExtra(konfigurasi.EMP_ID);

        idKelompok = (EditText) findViewById(R.id.idKelompok);
        kelompok = (EditText) findViewById(R.id.namaKelompok);
        ketuaKelompok = (EditText) findViewById(R.id.ketuaKelompok);
        luasLahan = (EditText) findViewById(R.id.luasLahan);
        noHP = (EditText) findViewById(R.id.noHp);
        musimTanam = (EditText) findViewById(R.id.musimTanam);
        kiraTanam = (EditText) findViewById(R.id.kiraTanam);

        buttonUpdate = (Button) findViewById(R.id.buttonUpdate);
        buttonDelete = (Button) findViewById(R.id.buttonDelete);

        buttonUpdate.setOnClickListener(this);
        buttonDelete.setOnClickListener(this);

        idKelompok.setText(id);

        getEmployee();
    }

    private void getEmployee(){
        class GetEmployee extends AsyncTask<Void,Void,String>{
            ProgressDialog loading;
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(TampilKelompok.this,"Fetching...","Wait...",false,false);
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
                String s = rh.sendGetRequestParam(konfigurasi.URL_GET_EMP,id);
                return s;
            }
        }
        GetEmployee ge = new GetEmployee();
        ge.execute();
    }

    private void showEmployee(String json){
        try {
            JSONObject jsonObject = new JSONObject(json);
            JSONArray result = jsonObject.getJSONArray(konfigurasi.TAG_JSON_ARRAY);
            JSONObject c = result.getJSONObject(0);
            String kel = c.getString(konfigurasi.TAG_KELOMPOK);
            String ketua = c.getString(konfigurasi.TAG_KETUA_KELOMPOK);
            String luas = c.getString(konfigurasi.TAG_LUAS);
            String hp = c.getString(konfigurasi.TAG_NO_HP);
            String musim = c.getString(konfigurasi.TAG_MUSIM_TANAM);
            String kira = c.getString(konfigurasi.TAG_KIRA_TANAM);

            kelompok.setText(kel);
            ketuaKelompok.setText(ketua);
            luasLahan.setText(luas);
            noHP.setText(hp);
            musimTanam.setText(musim);
            kiraTanam.setText(kira);

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }


    private void updateEmployee(){
        final String kel = kelompok.getText().toString().trim();
        final String ketua = ketuaKelompok.getText().toString().trim();
        final String luas = luasLahan.getText().toString().trim();
        final String HP = noHP.getText().toString().trim();
        final String musim = musimTanam.getText().toString().trim();
        final String kira = kiraTanam.getText().toString().trim();

        class UpdateEmployee extends AsyncTask<Void,Void,String>{
            ProgressDialog loading;
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(TampilKelompok.this,"Updating...","Wait...",false,false);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                Toast.makeText(TampilKelompok.this,s,Toast.LENGTH_LONG).show();
            }

            @Override
            protected String doInBackground(Void... params) {
                HashMap<String,String> hashMap = new HashMap<>();
                hashMap.put(konfigurasi.KEY_EMP_ID,id);
                hashMap.put(konfigurasi.KEY_EMP_NAMA,kel);
                hashMap.put(konfigurasi.KEY_EMP_KETUA,ketua);
                hashMap.put(konfigurasi.KEY_EMP_LUAS,luas);
                hashMap.put(konfigurasi.KEY_EMP_HP,HP);
                hashMap.put(konfigurasi.KEY_EMP_MUSIM_TANAM,musim);
                hashMap.put(konfigurasi.KEY_EMP_KIRA_TANAM,kira);

                RequestHandler rh = new RequestHandler();

                String s = rh.sendPostRequest(konfigurasi.URL_UPDATE_EMP,hashMap);

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
                loading = ProgressDialog.show(TampilKelompok.this, "Updating...", "Tunggu...", false, false);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                Toast.makeText(TampilKelompok.this, s, Toast.LENGTH_LONG).show();
            }

            @Override
            protected String doInBackground(Void... params) {
                RequestHandler rh = new RequestHandler();
                String s = rh.sendGetRequestParam(konfigurasi.URL_DELETE_EMP, id);
                return s;
            }
        }

        DeleteEmployee de = new DeleteEmployee();
        de.execute();
    }

    private void confirmDeleteEmployee(){
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setMessage("Apakah Kamu Yakin Ingin Menghapus Kelompok ini?");

        alertDialogBuilder.setPositiveButton("Ya",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface arg0, int arg1) {
                        deleteEmployee();
                        startActivity(new Intent(TampilKelompok.this,TampilSemuaKlp.class));
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
            startActivity(new Intent(this,TampilSemuaKlp.class));
        }

        if(v == buttonDelete){
            confirmDeleteEmployee();
        }
    }
}
