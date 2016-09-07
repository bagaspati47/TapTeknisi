<?php
if($_SERVER['REQUEST_METHOD']=='POST'){
		$nm = $_POST['nm_teknisi'];
		$un = $_POST['un_teknisi'];
		$pw = $_POST['pw_teknisi'];
		$hp = $_POST['hp_teknisi'];
		$email = $_POST['email'];
		$fp = $_POST['fp_link'];
		
		if($nm == '' || $un == '' || $pw == '' || $hp == '' || $email == ''){
			echo 'tolong isi semua kolom.';
		}else{
			require_once('dbConnect.php');
			$sql = "SELECT * FROM teknisi WHERE un_teknisi='$un' OR email='$email'";
			
			$check = mysqli_fetch_array(mysqli_query($con,$sql));
			
			if(isset($check)){
				echo 'gagal, inisial atau email sudah terdaftar.';
			}else{
				/// encryption by www.youtube.com/watch?v=8uFPVm_LPH8 @ 22 Januari 2016
				$pwsha1 = sha1($pw);
				$sql = "INSERT INTO teknisi (nm_teknisi,un_teknisi,pw_teknisi,hp_teknisi,email,fp_link) VALUES('$nm','$un','$pwsha1','$hp','$email','$fp')";
				if(mysqli_query($con,$sql)){
					echo 'Sukses terdaftar, silahkan lakukan pembayaran untuk aktifasi.';
				}else{
					echo 'waduhh! Ayo coba lagi!';
				}
			}
			mysqli_close($con);
		}
}else{
echo 'error';
}