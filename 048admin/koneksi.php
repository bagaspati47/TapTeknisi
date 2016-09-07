<?php 
  $db = new mysqli('mysql.idhostinger.com','u507115925_adm47', '28taptek', 'u507115925_dbtpt');
                             
   if($db->connect_errno > 0){
                             
   die('Unable to connect to database [' . $db->connect_error . ']');
  }
?>