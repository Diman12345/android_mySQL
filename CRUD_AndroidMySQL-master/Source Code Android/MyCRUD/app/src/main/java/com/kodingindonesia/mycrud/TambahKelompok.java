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

public class TambahKelompok extends AppCompatActivity implements View.OnClickListener{

    //Dibawah ini merupakan perintah untuk mendefinikan View
    private EditText namaKelompok;
    private EditText noHP;
    private EditText musimTanam;
    private EditText kiraTanam;
    private EditText ketuaKelompok;
    private EditText luasLahan;

    private Button buttonAdd;
    private Button buttonView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah_pegawai);

        //Inisialisasi dari View
        namaKelompok = (EditText) findViewById(R.id.namaKelompok);
        ketuaKelompok = (EditText) findViewById(R.id.ketuaKelompok);
        luasLahan = (EditText) findViewById(R.id.luasLahan);
        noHP = (EditText) findViewById(R.id.noHp);
        musimTanam = (EditText) findViewById(R.id.musimTanam);
        kiraTanam = (EditText) findViewById(R.id.kiraTanam);

        buttonAdd = (Button) findViewById(R.id.buttonAdd);
        buttonView = (Button) findViewById(R.id.buttonView);

        //Setting listeners to button
        buttonAdd.setOnClickListener(this);
        buttonView.setOnClickListener(this);
    }


    //Dibawah ini merupakan perintah untuk Menambahkan Pegawai (CREATE)
    private void addEmployee(){

        final String kelompok = namaKelompok.getText().toString().trim();
        final String ketua = ketuaKelompok.getText().toString().trim();
        final String luas = luasLahan.getText().toString().trim();
        final String hp = noHP.getText().toString().trim();
        final String musim = musimTanam.getText().toString().trim();
        final String kira = kiraTanam.getText().toString().trim();

        class AddEmployee extends AsyncTask<Void,Void,String> {

            ProgressDialog loading;

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(TambahKelompok.this,"Menambahkan...","Tunggu...",false,false);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                Toast.makeText(TambahKelompok.this,s,Toast.LENGTH_LONG).show();
            }

            @Override
            protected String doInBackground(Void... v) {
                HashMap<String,String> params = new HashMap<>();
                params.put(konfigurasi.KEY_EMP_NAMA,kelompok);
                params.put(konfigurasi.KEY_EMP_KETUA,ketua);
                params.put(konfigurasi.KEY_EMP_LUAS,luas);
                params.put(konfigurasi.KEY_EMP_HP,hp);
                params.put(konfigurasi.KEY_EMP_MUSIM_TANAM,musim);
                params.put(konfigurasi.KEY_EMP_KIRA_TANAM,kira);

                RequestHandler rh = new RequestHandler();
                String res = rh.sendPostRequest(konfigurasi.URL_ADD, params);
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
            startActivity(new Intent(this,TampilSemuaKlp.class));
        }

        if(v == buttonView){
            startActivity(new Intent(this,TampilSemuaKlp.class));
        }
    }
}
