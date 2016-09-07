	<?php include "header.php"; ?>
								    <?php
                                        $mysqli = new mysqli("mysql.idhostinger.com", "u507115925_adm47", "28taptek", "u507115925_dbtpt");
                                        if ($mysqli->connect_errno) {
                                            echo "Failed to connect to MySQL: " . $mysqli->connect_error;
                                        }
                                    ?>

                                    <?php
                                        error_reporting(E_ALL & ~E_DEPRECATED & ~E_NOTICE & ~E_WARNING);
                                        if(isset($_POST['bts'])):
                                          if($_POST['nmteknisi']!=null && $_POST['hpteknisi']!=null && $_POST['email']!=null && $_POST['userteknisi']!=null && $_POST['pwteknisi']!=null && $_POST['fplink']!=null){
                                             $stmt = $mysqli->prepare("INSERT INTO teknisi(nm_teknisi,hp_teknisi,email,un_teknisi,pw_teknisi,fp_link) VALUES (?,?,?,?,?,?)");
                                             $stmt->bind_param('ssssss', $nmteknisi, $hpteknisi, $email, $userteknisi, $pwteknisi, $fplink);

                                             //$idteknisi = $_POST['idteknisi'];
                                             $nmteknisi = $_POST['nmteknisi'];
                                             $hpteknisi = $_POST['hpteknisi'];
                                             $email = $_POST['email'];
                                             $userteknisi = $_POST['userteknisi'];
                                             $pwteknisi = $_POST['pwteknisi'];
                                             //$ststerdftr = $_POST['ststerdftr'];
                                             //$stsrptasi = $_POST['stsrptasi'];
                                             $fplink = $_POST['fplink'];
                                             //$crtdate = $_POST['crtdate'];

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
                                                       <label for="nmteknisi">Nama Teknisi</label>
                                                       <input type="text" class="form-control" name="nmteknisi" id="nmteknisi" placeholder="Nama Teknisi">
                                                     </div>
                                                  </div>
                                                </div>
                                                <div class="form-group">
                                                  <div class="row">
                                                     <div class="col-xs-12 col-sm-4">
                                                       <div class="controls">
                                                       <label for="hpteknisi">No Telepon</label>
                                                       <input type="text" class="form-control" name="hpteknisi" id="hpteknisi" placeholder="No Telepon">
                                                     </div>
                                                  </div>
                                                </div>
                                                <div class="form-group">
                                                  <div class="row">
                                                     <div class="col-xs-12 col-sm-4">
                                                       <div class="controls">
                                                       <label for="email">Email</label>
                                                       <input type="text" class="form-control" name="email" id="email" placeholder="Email">
                                                     </div>
                                                  </div>
                                                </div> 
                                                <div class="form-group">
                                                  <div class="row">
                                                     <div class="col-xs-12 col-sm-4">
                                                       <div class="controls">
                                                       <label for="userteknisi">Username</label>
                                                       <input type="text" class="form-control" name="userteknisi" id="userteknisi" placeholder="UserName">
                                                     </div>
                                                  </div>
                                                </div>
                                                <div class="form-group">
                                                  <div class="row">
                                                     <div class="col-xs-12 col-sm-4">
                                                       <div class="controls">
                                                       <label for="pwteknisi">Passsword</label>
                                                       <input type="password" class="form-control" name="pwteknisi" id="pwteknisi" placeholder="Password">
                                                     </div>
                                                  </div>
                                                </div>
												<!--
                                                <div class="form-group">
                                                  <div class="row">
                                                     <div class="col-xs-12 col-sm-4">
                                                       <div class="controls">
                                                       <label for="ststerdftr">Status Terdaftar</label>
                                                        <select class="form-control" id="ststerdftr" name="ststerdftr">
                                                          <option value ="">Pilih</option>
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
                                                          <option value ="">Pilih</option>
                                                          <option value="Baik">Baik</option>
                                                          <option value="Buruk">Buruk</option>
                                                        </select>
                                                        </div>
                                                      </div>
                                                   </div>
                                                </div>
												--->
                                                <div class="form-group">
                                                  <div class="row">
                                                     <div class="col-xs-12 col-sm-4">
                                                       <div class="controls">
                                                       <label for="fplink">Fp Link</label>
                                                       <input type="text" class="form-control" name="fplink" id="fplink" placeholder="Link">
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
