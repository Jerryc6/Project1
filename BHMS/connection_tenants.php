<?Php
   
if(isset($_POST['save_billrates'])){
    $bi_lls = $_POST['bi_lls'];
    $ra_te = $_POST['ra_te'];

$connection_billrates = new mysqli('localhost','user','','bhms');

if($connection_billrates->connect_error){
    die ('Connection Error' . $connection_billrates->connect_error);

}else{
    $stmt = $connection_billrates->prepare("insert into bill_rates(bi_lls,ra_te)values(?,?)");
    $stmt -> bind_param("ss", $bi_lls,$ra_te,);
    $stmt -> execute();
    echo "Registered";
    $stmt ->close();
    $connection_billrates -> close();

    header("location: billrates_page.php");
}
}


if(isset($_POST['save_payments'])){
    $tena_nts = $_POST['tena_nts'];
    $bed_number = $_POST['bed_number'];
    $room_number = $_POST['room_number'];
    $expected_amount = $_POST['expected_amount'];
    $paid_amount = $_POST['paid_amount'];
    $date_of_paid = $_POST['date_of_paid'];
    $bala_nce = $_POST['bala_nce'];

$connection_payments = new mysqli('localhost','user','','bhms');

if($connection_payments->connect_error){
    die ('Connection Error' . $connection_payments->connect_error);

}else{
    $stmt = $connection_payments->prepare("insert into pay_ments(tena_nts,bed_number,room_number,expected_amount,paid_amount,date_of_paid,bala_nce)values(?,?,?,?,?,?,?)");
    $stmt -> bind_param("sssssss", $tena_nts,$bed_number,$room_number,$expected_amount,$paid_amount,$date_of_paid,$bala_nce);
    $stmt -> execute();
    //echo "Registered";
    $stmt ->close();
    $connection_payments -> close();

    header("location: payments_page.php");
}
}


if(isset($_POST['save_room'])){
    $room_number = $_POST['room_number'];
    $des_cription = $_POST['des_cription'];
    $ima_ge = $_POST['ima_ge'];

    $connection_room = new mysqli('localhost','user','','bhms');

    if($connection_room->connect_error){
        die ('Connection Error' . $connection_room->connect_error);

    }else{
        $stmt = $connection_room->prepare("insert into room_management(room_number,des_cription,ima_ge)values(?,?,?)");
        $stmt -> bind_param("sss",$room_number,$des_cription,$ima_ge);
        $stmt -> execute();
        echo "Registered";
        $stmt ->close();
        $connection_room -> close();

        header("location: rooms_page.php");
    }
}


if (isset($_POST['updateid'])) {

    $id = $_POST['id'];
    $user = $_POST['user'];
    $pass = $_POST['pass'];

    $query = "UPDATE log_in SET user='$user', pass='$pass' WHERE id='$id' ";
    $query_run = mysqli_query($connn, $query);

    if ($query_run) {
        # code...                                                               
        echo 'hello';                          
        //header("location: add_tenants.php");
    }                                                                                                                                                                               
    else {
        echo '<script>alert ("Data Updated");</script>';
    }
}



if (isset($_POST['save_bed'])) {
    # code...
    # code...
    $bed_number = $_POST['bed_number'];
    $file_name = $_FILES['image']['name'];
    $tempname = $_FILES['image']['tmp_name'];
    $folder = 'file/'.$file_name;
  
    $query = mysqli_query($connn, "insert into bed_management(image, bed_number)values('$file_name','$bed_number)");
    if (move_uploaded_file($tempname, $folder)) {
      # code...
      echo"
      <h2>File uploaded successfully Added</h2>
      ";
      header("location: bed_page.php");
    }else{
      echo"
      <h2>File not uploaded successfully Added</h2>
      ";
    }
}


if(isset($_POST['savebed'])){
    $user = $_POST['user'];
    $pass = $_POST['pass'];

$connection_log = new mysqli('localhost','user','','bhms');

if($connection_log->connect_error){
    die ('Connection Error' . $connection_log->connect_error);

}else{
    $stmt = $connection_log->prepare("insert into log(user,pass)values(?,?)");
    $stmt -> bind_param("ss", $user,$pass,);
    $stmt -> execute();
    echo "Registered";
    $stmt ->close();
    $connection_log -> close();
    
    header("location: login.php");  
}
}
?>