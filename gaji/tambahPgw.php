<?php

 /*

 penulis: Muhammad yusuf
 website: http://www.kodingindonesia.com/

 */

	if($_SERVER['REQUEST_METHOD']=='POST'){

		//Mendapatkan Nilai Variable
		$kelompok = $_POST['kelompok'];
		$ketua_kelompok = $_POST['ketua_kelompok'];
		$luas_lahan = $_POST['luas_lahan'];
		$no_hp = $_POST['no_hp'];
		$musim_tanam = $_POST['musim_tanam'];
		$kira_tanam = $_POST['kira_tanam'];


		//Pembuatan Syntax SQL
		$sql = "INSERT INTO tb_pegawai (kelompok,ketua_kelompok,luas_lahan,no_hp,musim_tanam,kira_tanam) VALUES ('$kelompok','$ketua_kelompok','$luas_lahan','$no_hp','$musim_tanam','$kira_tanam')";

		//Import File Koneksi database
		require_once('koneksi.php');

		//Eksekusi Query database
		if(mysqli_query($con,$sql)){
			echo 'Berhasil Menambahkan kelompok';
		}else{
			echo 'Gagal Menambahkan Pegawai';
		}

		mysqli_close($con);
	}
?>
