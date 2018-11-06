<?php

	if($_SERVER['REQUEST_METHOD']=='POST'){

		//Mendapatkan Nilai Variable
		$kecamatan = $_POST['kecamatan'];
		$desa = $_POST['desa'];
		$nama_anggota = $_POST['nama_anggota'];
		$luas_lahan = $_POST['luas_lahan'];
		$jenis_lahan = $_POST['jenis_lahan'];
		$jumlah_petak = $_POST['jumlah_petak'];
		$premi = $_POST['premi'];


		//Pembuatan Syntax SQL
		$sql = "INSERT INTO tb_anggota (kecamatan,desa,nama_anggota,luas_lahan,jenis_lahan,jumlah_petak,premi)
						VALUES ('$kecamatan','$desa','$nama_anggota','$luas_lahan','$jenis_lahan','$jumlah_petak','$premi')";

		//Import File Koneksi database
		require_once('koneksi.php');

		//Eksekusi Query database
		if(mysqli_query($con,$sql)){
			echo 'Berhasil Menambahkan Anggota';
		}else{
			echo 'Gagal Menambahkan Pegawai';
		}

		mysqli_close($con);
	}
?>
