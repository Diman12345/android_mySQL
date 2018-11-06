<?php

	if($_SERVER['REQUEST_METHOD']=='POST'){
		//MEndapatkan Nilai Dari Variable
		$id = $_POST['id'];
		$kecamatan = $_POST['kecamatan'];
		$desa = $_POST['desa'];
		$nama_anggota = $_POST['nama_anggota'];
		$luas_lahan = $_POST['luas_lahan'];
		$jenis_lahan = $_POST['jenis_lahan'];
		$jumlah_petak = $_POST['jumlah_petak'];
		$premi = $_POST['premi'];


		//import file koneksi database
		require_once('koneksi.php');

		//Membuat SQL Query
		$sql = "UPDATE tb_anggota SET kecamatan = '$kecamatan', desa = '$desa', nama_anggota = '$nama_anggota',
						luas_lahan = '$luas_lahan', jenis_lahan ='$jenis_lahan', jumlah_petak ='$jumlah_petak',premi = '$premi'  WHERE id = $id;";

		//Meng-update Database
		if(mysqli_query($con,$sql)){
			echo 'Berhasil Update Data Anggota';
		}else{
			echo 'Gagal Update Data Anggota';
		}

		mysqli_close($con);
	}
?>
