package com.kodingindonesia.mycrud;

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

public class TambahAnggota extends AppCompatActivity implements View.OnClickListener{

    //Dibawah ini merupakan perintah untuk mendefinikan View
    private EditText kecamatan;
    private EditText desa;
    private EditText namaAnggota;
    private EditText luasLahan;
    private EditText jenisLahan;
    private EditText petak;
    private EditText premi;

    private Button buttonAdd;
    private Button buttonView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah_anggota);

        //Inisialisasi dari View
        kecamatan = (EditText) findViewById(R.id.kecamatan);
        desa = (EditText) findViewById(R.id.desa);
        namaAnggota = (EditText) findViewById(R.id.namaAnggota);
        luasLahan = (EditText) findViewById(R.id.luasLahan);
        jenisLahan = (EditText) findViewById(R.id.jenisLahan);
        petak = (EditText) findViewById(R.id.petak);
        premi = (EditText) findViewById(R.id.premi);

        buttonAdd = (Button) findViewById(R.id.buttonAdd);
        buttonView = (Button) findViewById(R.id.buttonView);

        //Setting listeners to button
        buttonAdd.setOnClickListener(this);
        buttonView.setOnClickListener(this);
    }


    //Dibawah ini merupakan perintah untuk Menambahkan Pegawai (CREATE)
    private void addEmployee(){

        final String kec = kecamatan.getText().toString().trim();
        final String des = desa.getText().toString().trim();
        final String nama = namaAnggota.getText().toString().trim();
        final String luas = luasLahan.getText().toString().trim();
        final String jenis = jenisLahan.getText().toString().trim();
        final String peta = petak.getText().toString().trim();
        final String prem = premi.getText().toString().trim();

        class AddEmployee extends AsyncTask<Void,Void,String> {

            ProgressDialog loading;

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(TambahAnggota.this,"Menambahkan...","Tunggu...",false,false);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                Toast.makeText(TambahAnggota.this,s,Toast.LENGTH_LONG).show();
            }

            @Override
            protected String doInBackground(Void... v) {
                HashMap<String,String> params = new HashMap<>();
                params.put(konfigurasi.KEY_AGT_KEC,kec);
                params.put(konfigurasi.KEY_AGT_DESA,des);
                params.put(konfigurasi.KEY_AGT_NAMA,nama);
                params.put(konfigurasi.KEY_AGT_LUAS,luas);
                params.put(konfigurasi.KEY_AGT_JENIS,jenis);
                params.put(konfigurasi.KEY_AGT_JUMLAH,peta);
                params.put(konfigurasi.KEY_AGT_PREMI,prem);

                RequestHandler rh = new RequestHandler();
                String res = rh.sendPostRequest(konfigurasi.URL_AGT_ADD, params);
                return res;
            }
        }

        AddEmployee ae = new AddEmployee();
        ae.execute();
    }

    @Override
    public void onClick(View v) {
        if(v == buttonAdd){
            addEmployee();
            startActivity(new Intent(this,TampilSemuaAgt.class));
        }

        if(v == buttonView){
            startActivity(new Intent(this,TampilSemuaAgt.class));
        }
    }
}
