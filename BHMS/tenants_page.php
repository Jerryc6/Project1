<?php 
require_once('database.php');
$query = "SELECT * FROM addtenants";
$result = mysqli_query($connn, $query);

if (isset($_GET['fullname'])) {
    # code...
    $fullname=$_GET['fullname'];
    $delete=mysqli_query($connn,"DELETE FROM addtenants WHERE fullname = '$fullname'");
}


if (isset($_POST['submit'])) {
  # code...
  $fullname = $_POST['fullname'];
  $contact = $_POST['contact'];
  $address = $_POST['address'];
  $file_name = $_FILES['profile']['name'];
  $tempname = $_FILES['profile']['tmp_name'];
  $folder = '/opt/lampp/htdocs/prac/uploads'.$file_name;

  $query = mysqli_query($connn, "insert into addtenants(profile, fullname,contact,address)values('$file_name','$fullname','$contact','$address')");
  if (move_uploaded_file($tempname, $folder)) {
    # code...
  }else{
    echo"
    <h2>File not uploaded successfully Added</h2>
    ";
  }
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
    <title>Add Tenants</title>
      <!-- font awesome cdn link  -->
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.2/css/all.min.css">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<!-- custom css file link  -->
<link rel="stylesheet" href="CSS/webdesign.css">
</head>
<body>


<!--UPDATE MODAL HERE-->

<div class="update-modal">
<!-- Modal -->
<div class="modal fade" id="updateData" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
  <div class="modal-dialog modal-dialog-centered" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLongTitle">Update Tenants</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
<!----************************************************************************************************************-->
<form action="updatee.php" method="post" name="myForm" enctype="multipart/form-data">
<div class="questions">
    <input type="hidden" name="id" id="id"> 
    <input type="text" placeholder="Full Name"  id="fullname" name="fullname" required value="">
    <input type="text" placeholder="Contact Number" id="contact" name="contact" required value="">
    <input type="text" placeholder="Address"  id="address" name="address" required value=""><br>
    <label for="InputPicture">Profile</label>
    <input type="file" id="profile" name="profile"> 
    <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
        <button type="submit" class="btn btn-primary" onclick="Myfunction()" name="updatet" id="updatet">Save changes</button>
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
<form action="" method="post" name="myForm" enctype="multipart/form-data" autocomplete="off">
<div class="questions">
<input type="hidden" name="id" id="id">
    <input type="text" placeholder="Full Name"  id="fullname" name="fullname" required value="">
    <input type="text" placeholder="Contact Number" id="contact" name="contact" required value="">
    <input type="text" placeholder="Address"  id="address" name="address" required value=""><br>
    <label for="InputPicture">Profile</label>
    <input type="file" id="profile" name="profile">
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
      <h3 class="name">BHMS</h3>
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
 <h1 class="heading">ADD TENANTS</h1>
 <button type="button" class="editbtn btn-primary btn" style="width:270px;"  data-toggle="modal" data-target="#updateDataq">
 <i class="fa fa-user-plus" aria-hidden="true"></i>
 ADD TENANTS
 </button>
<br>
 <div class="containe">
    <div class="tbl_containe">   
      <table class="tbl">
            <thead>
                <tr>
                    <th style="width:100px;" >No.</th>
                    <th style="width: 300px;">Profile</th>
                    <th>Full Name</th>
                    <th>Contact Number</th>
                    <th>Address</th>
                    <th colspan="2">Action</th>
                </tr>
            </thead>

            <tbody>
                  <?Php

                   $connn = mysqli_connect("localhost","user","","bhms");

                   if (isset($_GET['search'])) {
                    # code...
                    $filtervalues = $_GET['search'];
                    $query = "SELECT * FROM addtenants WHERE CONCAT (id,fullname,contact,address,profile) LIKE '%$filtervalues%' ";
                    $query_run = mysqli_query($connn, $query);
                     if (mysqli_num_rows($query_run)>0) {
                      # code...
                      foreach($query_run as $bed){
                      ?>
                      <tr>
                      <td><?=$bed['id'];?></td>
                      <td><img src="uploads/<?php echo $bed['profile'];?>" height="100" title="<?php echo $bed['profile'];?>"> </td>
                      <td><?=$bed['fullname'];?></td>
                      <td><?=$bed['contact'];?></td>
                      <td><?=$bed['address'];?></td>
                      <td>
                        <button type="button" class="editbtn" data-toggle="modal" data-target="#updateData">
                        <i class="fa fa-pencil"></i>
                        </button>
                      </td>
                        <td>
                        <a href="tenants_page.php?fullname=<?=$bed['fullname'];?>" class="" ><i class="fa fa-trash"></i></a>
                        </td>
                        </tr>
                      <?php 
                      }
                    }
                  }else {
                    $queryy = "SELECT * FROM addtenants";
                    $query_runn = mysqli_query($connn, $queryy);
                    
                    foreach ($query_runn as $row) {
                      # code...
                      ?>
                      <tr>
                      <td><?php echo $row['id'];?></td>
                      <td><img src="uploads/<?php echo $row['profile'];?>" height="100" title="<?php echo $row['profile'];?>"> </td>
                      <td><?php echo $row['fullname'];?></td>
                      <td><?php echo $row['contact'];?></td>
                      <td><?php echo $row['address'];?></td>
                      <td>
                        <button type="button" class="editbtn" data-toggle="modal" data-target="#updateData">
                        <i class="fa fa-pencil"></i>
                        </button>
                      </td>

                      <td>
                        <a href="tenants_page.php?fullname=<?=$row['fullname'];?>" class="" ><i class="fa fa-trash"></i></a>
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
        $('#fullname').val(data[2]);
        $('#contact').val(data[3]);
        $('#address').val(data[4]);
    });
  });
</script>

</body>
</html>