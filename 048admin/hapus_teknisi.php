<?php
$mysqli = new mysqli("mysql.idhostinger.com", "u507115925_adm47", "28taptek", "u507115925_dbtpt");;
if ($mysqli->connect_errno) {
    echo "Failed to connect to MySQL: " . $mysqli->connect_error;
}
if(isset($_GET['d'])):
     $stmt = $mysqli->prepare("DELETE FROM teknisi WHERE id_teknisi=?");
     $stmt->bind_param('s', $id);

     $id = $_GET['d'];

     if($stmt->execute()):
          echo "<script>location.href='teknisi.php'</script>";
     else:
          echo "<script>alert('".$stmt->error."')</script>";
     endif;
endif;
?>