<?php 
require_once ('database.php');


if (isset($_POST['submit'])) {
    # code...
    $sug_gest = $_POST['sug_gest'];
    $da_te = $_POST['da_te'];
    $reply_owner= $_POST['reply_owner'];
    $sta_tus = $_POST['sta_tus'];
  
    $query = mysqli_query($connn, "insert into sugge_stion(sug_gest, da_te, reply_owner, sta_tus)values('$sug_gest','$da_te','$reply_owner','$sta_tus')");
    if (move_uploaded_file($tempname, $folder)) {
      # code...
      header("location : suggestion_client");
    }else{
      echo"
    
      ";
    }
  }


  if (isset($_POST['login'])) {
    # code...
    header("location: login.php");
  }

?>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Suggestions</title>

    <!-- font awesome cdn link  -->
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.2/css/all.min.css">
<script src="https://cdn.jsdelivr.net/npm/sweetalert2@11.14.5/dist/sweetalert2.all.min.js"></script>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/sweetalert2@11.14.5/dist/sweetalert2.min.css">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<!-- custom css file link  -->
<link rel="stylesheet" href="designs/webdesign.css">
</head>
<body>




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
<form action="" method="post" name="myForm" autocomplete="off">
<div class="questions">
<input type="hidden" name="id" id="id">
    <input type="text" placeholder="Suggest"  id="sug_gest" name="sug_gest" required value="">
    <input type="text" placeholder="Date" id="da_te" name="da_te" required value="">
    <input type="text" placeholder="Reply of owner" id="reply_owner" name="reply_owner" required value="">
    <input type="text" placeholder="Status"  id="sta_tus" name="sta_tus" required value=""><br>
    <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
        <button type="submit" class="btn btn-primary" onclick="Myfunction()" name="submit">Save changes</button>
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
      <h3 class="name">BHMS</h3>
   </div>

   <nav class="navbar">
            <a href="tenants_client.php"><i class="fa-solid fa-user-tie"></i><span>TENANTS</span></a>
            <a href="bed_client.php"><i class="fa-solid fa-door-open"></i><span>ROOM MANAGEMENT</span></a>
            <a href="room_client.php"><i class="fas fa-bed"></i><span>BED MANAGEMENT</span></a>
            <a href="billrate_client.php"><i class="fa-solid fa-plug"></i><span>BILL RATES</span></a>
            <a href="payment_client.php"><i class="fa-solid fa-dollar-sign"></i><span>PAYMENTS</span></a>
            <a href="suggestion_client.php"><i class="fa-solid fa-envelope"></i><span>SUGGESTION</span></a>
        </nav>

</div>


<section class="courses">
 <h1 class="heading">Suggestion</h1>

 <button type="button" class="editbtn btn-primary btn" style="width:270px;"  data-toggle="modal" data-target="#updateDataq">
 <i class="fa fa-user-plus" aria-hidden="true"></i>
 ADD SUGGESTION
 </button>
<br>
 <div class="container>
    <div class="tbl_containe">
        
        <table class="tbl">
            <thead>
                <tr>
                    <th>Suggestion</th>
                    <th>Date</th>
                    <th>Reply owner</th>
                    <th>Status</th>
                </tr>
            </thead>
            <tbody>
               <?Php
               $query = "SELECT * FROM sugge_stion";
               $query_run = mysqli_query($connn, $query);
               if (mysqli_num_rows($query_run) > 0) {
                # code...
                foreach ($query_run as $bed) {
                    ?>
                        <tr>
                            <td><?=$bed['sug_gest'];?></td>
                            <td><?=$bed['da_te'];?></td>
                            <td><?=$bed['reply_owner'];?></td>
                            <td><?=$bed['sta_tus'];?></td>
                        </tr>
                    <?Php
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
</body>
</html>