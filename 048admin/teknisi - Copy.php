<?php   session_start();  ?>
<?php
      if(!isset($_SESSION['use'])) // If session is not set that redirect to Login Page                            {
		{ header("Location:login.php"); }

          echo "<strong>".$_SESSION['use']."</strong>";

          echo " Login Success";

          echo "<a href='logout.php'> Logout</a> "; 
?>
<?php include "header.php"; 
?>
								<div class="content table-responsive table-full-width">
                             <div style="widht: 500px; border: 0px solid black; padding: 8px">
                              <p>
                              <a href="add_teknisi.php" class="btn btn-primary btn-md"><span class="glyphicon glyphicon-plus" aria-hidden="true"></span> Add Data</a><br/>
                              </p>
                                <table id="example" table class="table table-hover table-striped" cellspacing="0" width="100%">
                                    <thead>
                                        <tr>
                                            <th>Kode Teknisi</th>
                                            <th>Nama Teknisi</th>
                                            <th>No Telepon</th>
                                            <th>Email</th>
                                            <th>Username</th>
                                            <th>Password</th>
                                            <th>Status</th>
                                            <th>Reputasi</th>
                                            <th>Fp Link</th>
                                            <th>Create Date</th>
                                            <th>Action</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                     <?php include "koneksi.php" ;?>
                                     <?php
                                      error_reporting(E_ALL & ~E_DEPRECATED & ~E_NOTICE & ~E_WARNING);
                                      $view=mysqli_query($db,"select * from teknisi");
                                      $no=0;
                                      while($row=mysqli_fetch_array($view)){
                                      ?>
                                        <tr>
                                          <td><?php echo $row['0'];?></td>
                                          <td><?php echo $row['1'];?></td>
                                          <td><?php echo $row['2'];?></td>
                                          <td><?php echo $row['3'];?></td>
                                          <td><?php echo $row['4'];?></td>
                                          <td><?php echo $row['5'];?></td>
                                          <td><?php if($row['6'] == Terdaftar){
                                            echo '<span class="label label-success">Terdaftar</span>';
                                          }else{
                                            echo '<span class="label label-danger">Belum Terdaftar</span>';
                                          }
                                          ;?></td>
                                          <td><?php if($row['7'] == Baik){
                                            echo '<span class="label label-success">Baik</span>';
                                          }else{
                                            echo '<span class="label label-danger">Buruk</span>';
                                          }
                                          ;?></td>
                                          <td><?php echo $row['8'];?></td>
                                          <td><?php echo $row['9'];?></td>
                                          <td>
                                             <a href="edit_teknisi.php?u=<?php echo $row['id_teknisi'] ?>"><span class="glyphicon glyphicon-pencil" aria-hidden="true"></span></a>

                                            <a onclick="return confirm('Yakin Arek Di Hapus')" href="hapus_teknisi.php?d=<?php echo $row['id_teknisi'] ?>"><span class="glyphicon glyphicon-trash" aria-hidden="true"></span></a>
                                          </td>
                                        </tr>
                                        <?php
                                        }
                                        ?>  
                                        </tbody>
                                    </table>
                                       
                                </div>
                            </div>        
<?php include "footer.php"; ?>