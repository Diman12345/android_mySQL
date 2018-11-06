<?php

 /*

 penulis: Muhammad yusuf
 website: http://www.kodingindonesia.com/

 */
	if($_SERVER['REQUEST_METHOD']=='POST'){
		//MEndapatkan Nilai Dari Variable
		$id = $_POST['id'];
		$kelompok = $_POST['kelompok'];
		$ketua_kelompok = $_POST['ketua_kelompok'];
		$luas_lahan = $_POST['luas_lahan'];
		$no_hp = $_POST['no_hp'];
		$musim_tanam = $_POST['musim_tanam'];
		$kira_tanam = $_POST['kira_tanam'];


		//import file koneksi database
		require_once('koneksi.php');

		//Membuat SQL Query
		$sql = "UPDATE tb_pegawai SET kelompok = '$kelompok', ketua_kelompok = '$ketua_kelompok', luas_lahan = '$luas_lahan', no_hp = '$no_hp', musim_tanam = '$musim_tanam', kira_tanam ='$kira_tanam'  WHERE id = $id;";

		//Meng-update Database
		if(mysqli_query($con,$sql)){
			echo 'Berhasil Update Data kelompok';
		}else{
			echo 'Gagal Update Data kelompok';
		}

		mysqli_close($con);
	}
?>
