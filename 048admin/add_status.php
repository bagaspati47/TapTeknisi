<?php include "header.php"; ?>
								                    <?php
                                        $mysqli = new mysqli("localhost", "root", "", "database_tapteknisi");
                                        if ($mysqli->connect_errno) {
                                            echo "Failed to connect to MySQL: " . $mysqli->connect_error;
                                        }
                                    ?>

                                    <?php
                                        error_reporting(E_ALL & ~E_DEPRECATED & ~E_NOTICE & ~E_WARNING);
                                        if(isset($_POST['bts'])):
                                          if($_POST['idteknisi']!=null && $_POST['ststerdftr']!=null && $_POST['stsrptasi']!=null){
                                             $stmt = $mysqli->prepare("INSERT INTO reputasi(id_teknisi, sts_terdaftar,sts_reputasi) VALUES (?,?,?)");
                                             $stmt->bind_param('sss', $idteknisi, $ststerdftr, $stsrptasi);

                                             $idteknisi = $_POST['idteknisi'];									
                                             $ststerdftr = $_POST['ststerdftr'];
                                             $stsrptasi = $_POST['stsrptasi'];
                                         
                                            

                                             if($stmt->execute()):
                                    ?>

                                    <p></p>
                                <div class="alert alert-success alert-dismissible" role="alert">
                                  <button type="button" class="close" data-dismiss="alert"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
                                  <strong>Berhasil!</strong> Silahkan tambah lagi, jika ingin keluar klik <a href="teknisi.php">Home</a>.
                                </div>
                                <?php
                                     else:
                                ?>
                                <p></p>
                                <div class="alert alert-danger alert-dismissible" role="alert">
                                  <button type="button" class="close" data-dismiss="alert"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
                                  <strong>Gagal!</strong> Gagal total, Silahkan coba lagi!!!.<?php echo $stmt->error; ?>
                                </div>
                                <?php
                                     endif;
                                  } else{
                                ?>
                                <p></p>
                                <div class="alert alert-warning alert-dismissible" role="alert">
                                  <button type="button" class="close" data-dismiss="alert"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
                                  <strong>Gagal!</strong> Form tidak boleh kosong, tolong diisi.
                                </div>
                                <?php
                                  }
                                endif;
                                ?>

                                    
                                     <div style="widht: 500px; border: 0px solid black; padding: 8px">
                                     <div class="panel panel-default">
                                        <div class='panel-body'>
                                               <form role="form" method="post">
                                                <div class="form-group">
                                                  <div class="row">
                                                     <div class="col-xs-12 col-sm-4">
                                                       <div class="controls">
                                                       <label for="idteknisi">ID Teknisi</label>
                                                       <input type="text" class="form-control" name="idteknisi" id="idteknisi" placeholder="ID Teknisi">
                                                     </div>
                                                  </div>
                                                </div>
                                          
                                                <div class="form-group">
                                                  <div class="row">
                                                     <div class="col-xs-12 col-sm-4">
                                                       <div class="controls">
                                                       <label for="ststerdftr">Status Terdaftar</label>
                                                        <select class="form-control" id="ststerdftr" name="ststerdftr">
                                                          <option value ="">Status Terdaftar</option>
                                                          <option value="Terdaftar">Terdaftar</option>
                                                          <option value="Belum Terdaftar">Belum Terdaftar</option>
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
                                                        <select class="form-control" id="stsrptasi" name="stsrptasi">
                                                          <option value ="">Status Reputasi</option>
                                                          <option value="Baik">Baik</option>
                                                          <option value="Buruk">Buruk</option>
                                                        </select>
                                                        </div>
                                                      </div>
                                                   </div>
                                                </div>
                                              
                                              
                                                <br>
                                                <div class="form-group"> 
                                                     <input type="submit" name="bts" class="btn btn-primary" value="TAMBAH">
                                                     <a href="teknisi.php" class="btn btn-warning">BATAL</a>
                                                </div>
                                            </form>
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
