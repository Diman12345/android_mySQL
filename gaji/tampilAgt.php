<?php

	//Mendapatkan Nilai Dari Variable ID Pegawai yang ingin ditampilkan
	$id = $_GET['id'];

	//Importing database
	require_once('koneksi.php');

	//Membuat SQL Query dengan pegawai yang ditentukan secara spesifik sesuai ID
	$sql = "SELECT * FROM tb_anggota WHERE id=$id";

	//Mendapatkan Hasil
	$r = mysqli_query($con,$sql);

	//Memasukkan Hasil Kedalam Array
	$result = array();
	$row = mysqli_fetch_array($r);
	array_push($result,array(
			"id"=>$row['id'],
			"kecamatan"=>$row['kecamatan'],//posisi == Nama Row di mySQL
			"desa"=>$row['desa'],//salary == Nama di konfigurasi android studio
			"nama_anggota"=>$row['nama_anggota'],
			"luas_lahan"=>$row['luas_lahan'],
			"jenis_lahan"=>$row['jenis_lahan'],
      "jumlah_petak"=>$row['jumlah_petak'],
      "premi"=>$row['premi']
		));

	//Menampilkan dalam format JSON
	echo json_encode(array('result'=>$result));

	mysqli_close($con);
?>
