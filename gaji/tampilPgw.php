<?php

 /*

 penulis: Muhammad yusuf
 website: http://www.kodingindonesia.com/

 */

	//Mendapatkan Nilai Dari Variable ID Pegawai yang ingin ditampilkan
	$id = $_GET['id'];

	//Importing database
	require_once('koneksi.php');

	//Membuat SQL Query dengan pegawai yang ditentukan secara spesifik sesuai ID
	$sql = "SELECT * FROM tb_pegawai WHERE id=$id";

	//Mendapatkan Hasil
	$r = mysqli_query($con,$sql);

	//Memasukkan Hasil Kedalam Array
	$result = array();
	$row = mysqli_fetch_array($r);
	array_push($result,array(
			"id"=>$row['id'],
			"kelompok"=>$row['kelompok'],
			"ketua_kelompok"=>$row['ketua_kelompok'],//posisi == Nama Row di mySQL
			"luas_lahan"=>$row['luas_lahan'],//salary == Nama di konfigurasi android studio
			"no_hp"=>$row['no_hp'],
			"musim_tanam"=>$row['musim_tanam'],
			"kira_tanam"=>$row['kira_tanam']
		));

	//Menampilkan dalam format JSON
	echo json_encode(array('result'=>$result));

	mysqli_close($con);
?>
