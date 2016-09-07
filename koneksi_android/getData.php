<?php 
 
 if($_SERVER['REQUEST_METHOD']=='GET'){
 
 $id  = $_GET['id'];
 
 require_once('dbConnect.php');
 
 $sql = "SELECT * FROM teknisi WHERE hp_teknisi='".$id."'";
 
 $r = mysqli_query($con,$sql);
 
 $res = mysqli_fetch_array($r);
 
 $result = array();
 
 array_push($result,array(
 "nm_teknisi"=>$res['nm_teknisi'],
 "hp_teknisi"=>$res['hp_teknisi'],  "sts_terdaftar"=>$res['sts_terdaftar'],  "sts_reputasi"=>$res['sts_reputasi']
 )
 );
 
 echo json_encode(array("result"=>$result));
 
 mysqli_close($con);
 
 }