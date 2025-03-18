<?php 
require_once('database.php');
$query = "SELECT * FROM tena_nts";
$result = mysqli_query($connn, $query);

if (isset($_GET['tena_nts'])) {
    # code...
    $tena_nts=$_GET['tena_nts'];
    $delete=mysqli_query($connn,"DELETE FROM pay_ments WHERE tena_nts = '$tena_nts'");
}

if (isset($_POST['login'])) {
  # code...
  header("location: tryLogin.php");
}
?>


<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>PAYMENTS</title>
      <!-- font awesome cdn link  -->
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.2/css/all.min.css">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<!-- custom css file link  -->
<link rel="stylesheet" href="CSS/webdesign.css">
</head>
<body style="background: linear-gradient(to top, rgba(0,0,0,0.5)50%,rgba(0,0,0,0.5)50%),url('CSS/pic/background bh.jpeg');">


<!--UPDATE MODAL HERE-->

<div class="update-modal">
<!-- Modal -->
<div class="modal fade" id="updateData" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
  <div class="modal-dialog modal-dialog-centered" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLongTitle">Update Payments</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
<!----************************************************************************************************************-->
<form action="updatee.php" method="post" name="myForm">
<div class="questions">
    <input type="hidden" name="id" id="id">
    <input type="text" placeholder="Tenants"  id="tena_nts" name="tena_nts" required value="">
    <input type="text" placeholder="Bed Number" id="bed_number" name="bed_number" required value="">
    <input type="text" placeholder="Room Number"  id="room_number" name="room_number" required value="">
    <input type="text" placeholder="Expected Amount"  id="expected_amount" name="expected_amount" required value="">
    <input type="text" placeholder="Paid Amount" id="paid_amount" name="paid_amount" required value="">
    <input type="text" placeholder="Date of Paid"  id="date_of_paid" name="date_of_paid" required value="">
    <input type="text" placeholder="Balance"  id="bala_nce" name="bala_nce" required value="">
    <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
        <button type="submit" class="btn btn-primary" onclick="Myfunction()" name="update_payments">Save changes</button>
    </div>
</div>
</form>
<!----************************************************************************************************************-->
      </div>
    </div>
  </div>
</div>
</div>
<!--UPDATE MODAL HERE-->




<!--ADD  MODAL HERE-->
<div class="modal fade" id="updateDataq" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
  <div class="modal-dialog modal-dialog-centered" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLongTitle">ADD TENANTS</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
<!----************************************************************************************************************-->
<form action="connection_tenants.php" method="post" name="myForm">
<div class="questions">
    <input type="hidden" name="id" id="id">
    <input type="text" placeholder="Tenants"  id="tena_nts" name="tena_nts" required value="">
    <input type="text" placeholder="Bed Number" id="bed_number" name="bed_number" required value="">
    <input type="text" placeholder="Room Number"  id="room_number" name="room_number" required value="">
    <input type="text" placeholder="Expected Amount"  id="expected_amount" name="expected_amount" required value="">
    <input type="text" placeholder="Paid Amount" id="paid_amount" name="paid_amount" required value="">
    <input type="text" placeholder="Date of Paid"  id="date_of_paid" name="date_of_paid" required value="">
    <input type="text" placeholder="Balance"  id="bala_nce" name="bala_nce" required value="">
    <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
        <button type="submit" class="btn btn-primary" onclick="Myfunction()" name="save_payments">Save changes</button>
    </div>
</div>
</form>
<!----************************************************************************************************************-->
      </div>
    </div>
  </div>
</div>
<!--ADD  MODAL HERE-->


<!--LOGOUT HERE-->
<div class="modal fade" id="updateDataqw" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
  <div class="modal-dialog modal-dialog-centered" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLongTitle"></h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        <!----*************************************ADD BEDROOM***********************************************************************-->
          
          <div class="questions"> 
          <form action="" method="post">
          <h1>    Are you sure you want to logout?</h1>
          <div class="modal-footer">
          <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
          <button type="submit" name="login" class="btn btn-primary">Logout</button>
          </div>
          </form>
      </div>
<!----***********************************************ADD BEDROOM*************************************************************-->
      </div>
    </div>
  </div>
</div>
<!--ADD  MODAL HERE-->




<header class="header">
   <section class="flex">

      <a href="home.html" class="logo">  </a>

      <form action="" method="GET" class="search-form">
              <input type="text" name="search" value="<?php if(isset($_GET['search'])){echo $_GET['search']; }?>" placeholder="Search" maxlength="100">
              <button type="submit" class="fas fa-search"></button>
           </form>

      <div class="icons">
         <div id="menu-btn" class="fas fa-bars" data-toggle="modal" data-target="#updateDataqw"></div>
         <div id="search-btn" class="fas fa-search"></div>
      </div>

      

   </section>

</header>   

<div class="side-bar">
   <div id="close-btn">
      <i class="fas fa-times"></i>
   </div>
   <div class="profile">
   <h3 class="name"><i class="fa-solid fa-house"></i>  BHMS</h3>
   </div>
   <nav class="navbar">
            <a href="Dashhboard.php"><i class="fas fa-home"></i><span>DASHBOARD</span></a>
            <a href="tenants_page.php"><i class="fa-solid fa-user-tie"></i><span>TENANTS</span></a>
            <a href="rooms_page.php"><i class="fa-solid fa-door-open"></i><span>ROOM MANAGEMENT</span></a>
            <a href="bed_page.php"><i class="fas fa-bed"></i><span>BED MANAGEMENT</span></a>
            <a href="billrates_page.php"><i class="fa-solid fa-plug"></i><span>BILL RATES</span></a>
            <a href="payments_page.php"><i class="fa-solid fa-dollar-sign"></i><span>PAYMENTS</span></a>
            <a href="suggestions_page.php"><i class="fa-solid fa-envelope"></i><span>SUGGESTION</span></a>
           
        </nav>
</div>


<section class="courses">
 <h1 class="heading">PAYMENTS</h1>
 <button type="button" class="editbtn btn-primary btn" style="width:270px;"  data-toggle="modal" data-target="#updateDataq">
 <i class="fa fa-user-plus" aria-hidden="true"></i>
 ADD BILLRATES
 </button>
<br>
 <div class="containe">
    <div class="tbl_containe">   
      <table class="tbl">
            <thead>
                <tr>
                    <th style="width:70px;" >No.</th>
                    <th>Tenants</th>
                    <th>Bed Number</th>
                    <th>Room Number</th>
                    <th>Expected Amount</th>  
                    <th>Paid Amount</th>
                    <th>Date of Paid</th>
                    <th>Balance</th>
                    <th colspan="2">Action</th>
                </tr>
            </thead>

            <tbody>
                  <?Php

                   $connn = mysqli_connect("localhost","user","","bhms");

                   if (isset($_GET['search'])) {
                    # code...
                    $filtervalues = $_GET['search'];
                    $query = "SELECT * FROM pay_ments WHERE CONCAT (id,tena_nts,bed_number,room_number,expected_amount,paid_amount,date_of_paid,bala_nce) LIKE '%$filtervalues%' ";
                    $query_run = mysqli_query($connn, $query);
                     if (mysqli_num_rows($query_run)>0) {
                      # code...
                      foreach($query_run as $bed){
                      ?>
                      <tr>
                      <td><?=$bed['id'];?></td>
                      <td><?=$bed['tena_nts'];?></td>
                      <td><?=$bed['bed_number'];?></td>
                      <td><?=$bed['room_number'];?></td>
                      <td><?=$bed['expected_amount'];?></td>
                      <td><?=$bed['paid_amount'];?></td>
                      <td><?=$bed['date_of_paid'];?></td>
                      <td><?=$bed['bala_nce'];?></td>
                      <td>
                        <button type="button" class="editbtn" data-toggle="modal" data-target="#updateData">
                        <i class="fa fa-pencil"></i>
                        </button>
                      </td>
                        <td>
                        <a href="payments_page.php?tena_nts=<?=$bed['tena_nts'];?>" class="" ><i class="fa fa-trash"></i></a>
                        </td>
                        </tr>
                      <?php 
                      }
                    }
                  }else {
                    $queryy = "SELECT * FROM pay_ments";
                    $query_runn = mysqli_query($connn, $queryy);
                    
                    foreach ($query_runn as $row) {
                      # code...
                      ?>
                      <tr>
                      <td><?php echo $row['id'];?></td>
                      <td><?php echo $row['tena_nts'];?></td>
                      <td><?php echo $row['bed_number'];?></td>
                      <td><?php echo $row['room_number'];?></td>
                      <td><?php echo $row['expected_amount'];?></td>
                      <td><?php echo $row['paid_amount'];?></td>
                      <td><?php echo $row['date_of_paid'];?></td>
                      <td><?php echo $row['bala_nce'];?></td>
                      <td>
                        <button type="button" class="editbtn" data-toggle="modal" data-target="#updateData">
                        <i class="fa fa-pencil"></i>
                        </button>
                      </td>

                      <td>
                           <a href="payments_page.php?tena_nts=<?=$row['tena_nts'];?>" class="" ><i class="fa fa-trash"></i></a>
                          </td>
                      </tr>
                      <?php
                    }
                    
                }


               ?> 
              </tbody>
        </table>
    </div>
</div>
 
</section>

















<footer class="footer">

   &copy; copyright @ 2024 by <span>GROUP 6</span> | all rights reserved!

</footer>

<!-- custom js file link  -->
<script src="js/script.js"></script>

<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
<script>
  $(document).ready(function() {
    $('.editbtn').on('click', function(){
      $('#updateDate').modal('show');
        $tr = $(this).closest('tr');
        var data = $tr.children("td").map(function(){
          return $(this).text();
        }).get();

        console.log(data);
        $('#id').val(data[0]);
        $('#tena_nts').val(data[1]);  
        $('#bed_number').val(data[2]);
        $('#room_number').val(data[3]);
        $('#expected_amount').val(data[4]);
        $('#paid_amount').val(data[5]);
        $('#date_of_paid').val(data[6]);
        $('#bala_nce').val(data[7]);
    });
  });
</script>

</body>
</html>