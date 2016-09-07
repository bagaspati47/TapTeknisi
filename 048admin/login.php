<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Administrator</title>
 
    <!-- Bootstrap -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
 
    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
  </head>
  <body>
  <p>
</p>
  <div class="container">
<?php  session_start(); ?>
  
<?php
if(isset($_SESSION['use']))   // Checking whether the session is already there or not if 
                              // true that header redirect it to the home page directly 
 {
    header("Location:teknisi.php"); 
 }

@$un_admin=$_POST['un_admin'];
@$pw_admin=$_POST['pw_admin'];
@$login=$_POST['login'];
if(isset($login)){
  $mysqli = new mysqli("mysql.idhostinger.com", "u507115925_adm47", "28taptek", "u507115925_dbtpt");;
  if ($mysqli->connect_errno) {
    echo "Failed to connect to MySQL: " . $mysqli->connect_error;
  }
  $res = $mysqli->query("SELECT * FROM admin where un_admin='$un_admin' and pw_admin='$pw_admin'");
  $row = $res->fetch_assoc();
  $user = $row['un_admin'];
  $pass = $row['pw_admin'];
  if($user==$un_admin && $pass=$pw_admin){
	  $_SESSION['use']=$user;
      echo "<script>window.location.assign('teknisi.php')</script>";
    } else
      echo "<script>window.location.assign('login.php')</script>";
    }	
?>
<div class="alert alert-danger alert-dismissible" role="alert">
  <button type="button" class="close" data-dismiss="alert"><span aria-hidden="true">×</span><span class="sr-only">Close</span></button>
  <strong>Notifikasi:</strong> Tolong periksa kembali Username dan Password Anda.
</div>
<?php
    
    
?>
   
    <div class="panel panel-default">
      <div class="panel-body">
     
    <h2>TapTeknisi Administrator</h2>
    <form role="form" method="post">
      <div class="form-group">
 <input type="text" placeholder="Username" class="form-control" id="un_admin" name="un_admin">
      </div>
      <div class="form-group">
 <input type="password" placeholder="Password" class="form-control" id="pw_admin" name="pw_admin">
      </div>
      <button type="submit" name="login" class="btn btn-primary">Login</button>
    </form>
       
      </div>
     </div>
     
  </div>
 
    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="js/jquery.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="js/bootstrap.min.js"></script>
  </body>
</html> 