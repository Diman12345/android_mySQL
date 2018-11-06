package com.kodingindonesia.mycrud;

/**
 * Created by muhammadyusuf on 01/19/2017.
 * kodingindonesia
 */

public class konfigurasi {

    //Dibawah ini merupakan Pengalamatan dimana Lokasi Skrip CRUD PHP disimpan
    //Pada tutorial Kali ini, karena kita membuat localhost maka alamatnya tertuju ke IP komputer
    //dimana File PHP tersebut berada
    //PENTING! JANGAN LUPA GANTI IP SESUAI DENGAN IP KOMPUTER DIMANA DATA PHP BERADA
    public static final String URL_ADD="http://192.168.1.130/gaji/tambahPgw.php";
    public static final String URL_GET_ALL = "http://192.168.1.130/gaji/tampilSemuaPgw.php";
    public static final String URL_GET_EMP = "http://192.168.1.130/gaji/tampilPgw.php?id=";
    public static final String URL_UPDATE_EMP = "http://192.168.1.130/gaji/updatePgw.php";
    public static final String URL_DELETE_EMP = "http://192.168.1.130/gaji/hapusPgw.php?id=";

    public static final String URL_AGT_ADD="http://192.168.1.130/gaji/tambahAgt.php";
    public static final String URL_AGT_GET_ALL = "http://192.168.1.130/gaji/tampilSemuaAgt.php";
    public static final String URL_AGT_GET_EMP = "http://192.168.1.130/gaji/tampilAgt.php?id=";
    public static final String URL_AGT_UPDATE_EMP = "http://192.168.1.130/gaji/updateAgt.php";
    public static final String URL_AGT_DELETE_EMP = "http://192.168.1.130/gaji/hapusAgt.php?id=";

    //Dibawah ini merupakan Kunci yang akan digunakan untuk mengirim permintaan ke Skrip PHP
    public static final String KEY_EMP_ID = "id";
    public static final String KEY_EMP_NAMA = "kelompok";
    public static final String KEY_EMP_KETUA = "ketua_kelompok"; //desg itu variabel untuk posisi
    public static final String KEY_EMP_LUAS = "luas_lahan"; //salary itu variabel untuk gajih
    public static final String KEY_EMP_HP = "no_hp";
    public static final String KEY_EMP_MUSIM_TANAM = "musim_tanam";
    public static final String KEY_EMP_KIRA_TANAM = "kira_tanam";

    public static final String KEY_AGT_ID = "id";
    public static final String KEY_AGT_KEC = "kecamatan"; //desg itu variabel untuk posisi
    public static final String KEY_AGT_DESA = "desa"; //salary itu variabel untuk gajih
    public static final String KEY_AGT_NAMA = "nama_anggota";
    public static final String KEY_AGT_LUAS = "luas_lahan";
    public static final String KEY_AGT_JENIS = "jenis_lahan";
    public static final String KEY_AGT_JUMLAH = "jumlah_petak";
    public static final String KEY_AGT_PREMI = "premi";

    //JSON Tags
    public static final String TAG_JSON_ARRAY="result";
    public static final String TAG_ID = "id";
    public static final String TAG_KELOMPOK = "kelompok";
    public static final String TAG_KETUA_KELOMPOK = "ketua_kelompok";
    public static final String TAG_LUAS = "luas_lahan";
    public static final String TAG_NO_HP = "no_hp";
    public static final String TAG_MUSIM_TANAM = "musim_tanam";
    public static final String TAG_KIRA_TANAM = "kira_tanam";

    //JSON Tags
    public static final String TAG_AGT_JSON_ARRAY="result";
    public static final String TAG_AGT_ID = "id";
    public static final String TAG_AGT_KEC = "kecamatan";
    public static final String TAG_AGT_DESA = "desa";
    public static final String TAG_AGT_NAMA = "nama_anggota";
    public static final String TAG_AGT_LUAS = "luas_lahan";
    public static final String TAG_AGT_JENIS = "jenis_lahan";
    public static final String TAG_AGT_JUMLAH = "jumlah_petak";
    public static final String TAG_AGT_PREMI = "premi";

    //ID karyawan
    //emp itu singkatan dari Employee
    public static final String EMP_ID = "emp_id";
    public static final String AGT_ID = "agt_id";
}
