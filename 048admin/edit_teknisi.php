<?php include "header.php"; ?>
                                  <?php
                                    $mysqli = new mysqli("mysql.idhostinger.com", "u507115925_adm47", "28taptek", "u507115925_dbtpt");
                                      if ($mysqli->connect_errno) {
                                       echo "Failed to connect to MySQL: " . $mysqli->connect_error;
                                    }
                                  ?>
                                  <?php
                                  error_reporting(E_ALL & ~E_DEPRECATED & ~E_NOTICE & ~E_WARNING);
                                  if(isset($_GET['u'])):
                                       if(isset($_POST['bts'])):
                                            $stmt = $mysqli->prepare("UPDATE teknisi SET nm_teknisi=?, hp_teknisi=?, email=?, un_teknisi=?, pw_teknisi=?, sts_terdaftar=?, sts_reputasi=?, fp_link=?, crt_date=? WHERE id_teknisi=?");
                                            $stmt->bind_param('ssssssssss', $nmteknisi, $hpteknisi, $email, $userteknisi, $pwteknisi, $ststerdftr, $stsrptasi, $fplink, $crtdate, $idteknisi);

                                             $nmteknisi = $_POST['nmteknisi'];
                                             $hpteknisi = $_POST['hpteknisi'];
                                             $email = $_POST['email'];
                                             $userteknisi = $_POST['userteknisi'];
                                             $pwteknisi = $_POST['pwteknisi'];
                                             $ststerdftr = $_POST['ststerdftr'];
                                             $stsrptasi = $_POST['stsrptasi'];
                                             $fplink = $_POST['fplink'];
                                             $crtdate = $_POST['crtdate'];
                                             $idteknisi = $_POST['idteknisi'];


                                            if($stmt->execute()):
                                                 echo "<script>location.href='teknisi.php'</script>";
                                            else:
                                                 echo "<script>alert('".$stmt->error."')</script>";
                                            endif;
                                       endif;
                                       $res = $mysqli->query("SELECT * FROM teknisi WHERE id_teknisi=".$_GET['u']);
                                       $row = $res->fetch_assoc();
                                  ?>

                                      <p><br/></p>
                              
                                <div class="panel panel-default">
                                  <div  style="widht: 10px; border: 0px solid black; padding: 8px" class="panel-body">      
                                      <form role="form" method="post">
                                        <input type="hidden" value="<?php echo $row['id_teknisi'] ?>" name="idteknisi"/>
                                        <div class="form-group">
                                          <div class="row">
                                          <div class="col-xs-12 col-sm-4">
                                          <label for="nmteknisi">Nama Teknisi</label>
                                          <input type="text" class="form-control" name="nmteknisi" id="nmteknisi" value="<?php echo $row['nm_teknisi'] ?>">
                                          </div>
                                          </div>
                                        </div>
                                        <div class="form-group">
                                          <div class="row">
                                          <div class="col-xs-12 col-sm-4">
                                          <label for="hpteknisi">No Telepon</label>
                                          <input type="text" class="form-control" name="hpteknisi" id="hpteknisi" value="<?php echo $row['hp_teknisi'] ?>">
                                          </div>
                                          </div>
                                        </div>
                                        <div class="form-group">
                                          <div class="row">
                                          <div class="col-xs-12 col-sm-4">
                                          <label for="email">Email</label>
                                          <input type="text" class="form-control" name="email" id="email" value="<?php echo $row['email'] ?>">
                                          </div>
                                          </div>
                                        </div>
                                        <div class="form-group">
                                          <div class="row">
                                          <div class="col-xs-12 col-sm-4">
                                          <label for="userteknisi">User Name</label>
                                          <input type="text" class="form-control" name="userteknisi" id="userteknisi" value="<?php echo $row['un_teknisi'] ?>">
                                          </div>
                                          </div>
                                        </div>
                                        <div class="form-group">
                                          <div class="row">
                                          <div class="col-xs-12 col-sm-4">
                                          <label for="pwteknisi">Passsword</label>
                                          <input type="password" class="form-control" name="pwteknisi" id="pwteknisi" value="<?php echo $row['pw_teknisi'] ?>">
                                          </div>
                                          </div>
                                        </div>
                                        <div class="form-group">
                                          <div class="row">
                                            <div class="col-xs-12 col-sm-4">
                                            <div class="controls">
                                            <label for="ststerdftr">Status Terdaftar</label>
                                            <select name="ststerdftr" class="form-control" required>
                                              <option value="">Pilih</option>
                                              <option value="Terdaftar" <?php if($row['sts_terdaftar'] == '1'){ echo 'selected'; } ?>>Terdaftar</option>
                                              <option value="Belum Terdaftar" <?php if($row['sts_terdaftar'] == '2'){ echo 'selected'; } ?>>Belum Terdaftar</option>
                                            </select>
                                          </div>
                                          </div>
                                         </div>
                                        </div>
                                        <div class="form-group">
                                          <div class="row">
                                            <div class="col-xs-12 col-sm-4">
                                            <div class="controls">
                                            <label for="stsrptasi">Status Reputasi</label>
                                            <select name="stsrptasi" class="form-control" required>
                                              <option value="">Pilih</option>
                                              <option value="Baik" <?php if($row['sts_reputasi'] == '1'){ echo 'selected'; } ?>>Baik</option>
                                              <option value="Buruk" <?php if($row['sts_reputasi'] == '2'){ echo 'selected'; } ?>>Buruk</option>
                                            </select>
                                          </div>
                                          </div>
                                         </div>
                                        </div>
                                        <div class="form-group">
                                          <div class="row">
                                          <div class="col-xs-12 col-sm-4">
                                          <label for="fplink">Fp Link</label>
                                          <input type="text" class="form-control" name="fplink" id="fplink" value="<?php echo $row['fp_link'] ?>">
                                          </div>
                                        </div>
                                        </div>
                                        <div class="form-group">
                                          <div class="row">
                                          <div class="col-xs-12 col-sm-4">
                                          <label for="crtdate">Create Date</label>
                                          <input class="datepicker form-control" id="crtdate" name="crtdate" type="date" value="<?php echo $row['crt_date'] ?>">
                                          </div>
                                          </div>
                                        </div>
                                        <br>
                                        <div class="form-group">
                                          
                                         <button type="submit" name="bts" class="btn btn-primary">Submit</button>
                                         <a href="teknisi.php" class="btn btn-warning">BATAL</a>
                                        </div>
                                      </form>
                                  </div>
                                 </div>
                         
                                  <?php
                                  endif;
                                  ?>

    <link href="date/bootstrap.css" rel="stylesheet" />
    <link href="date/bootstrap-datepicker.css" rel="stylesheet" />    
    <script src="date/jquery-1.10.2.js" type="text/javascript"></script>
    <script src="date/bootstrap.js" type="text/javascript"></script>
    <script src="date/bootstrap-datepicker.js"></script>
    <script type="text/javascript">
    $('.datepicker').datepicker({
       format: 'yyyy-mm-dd',
       weekStart:1,
       color: 'blue'
    });
    </script>  
<?php include "footer.php"; ?>