<?php
require_once('dbConnect.php');
 
$con = mysqli_connect(HOST,USER,PASS,DB);
 
$sql = "select * from status";
$res = mysqli_query($con,$sql);
 
$result = array();
 
while($row = mysqli_fetch_array($res)){
array_push($result,
array('id_teknisi'=>$row['id_teknisi'],
'nm_teknisi'=>$row['nm_teknisi'],
'hp_teknisi'=>$row['hp_teknisi'],
'sts_terdaftar'=>$row['sts_terdaftar'],'sts_reputasi'=>$row['sts_reputasi'],'fp_link'=>$row['fp_link'],
));
}
 
echo json_encode(array("result"=>$result));
 
mysqli_close($con);
 
?>