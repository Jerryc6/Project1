<?php
$connn = mysqli_connect("localhost","user","");
$db = mysqli_select_db($connn, 'bhms');


if (isset($_POST['log'])) {

    $id = $_POST['id'];
    $user = $_POST['user'];
    $pass = $_POST['pass'];

    $sql = mysqli_query("SELECT pass FROM log_in WHERE user='$user' ");

    if ($row = mysqli_fetch_array($sql)) {
        # code...
        if ($pass == $row['pass']) {
            # code...                                                                                        
            header("location: tenants_client.php");
            exit(); 
        }else {
            # code...
            echo"Invalid";
        }                                                                                                                                                                         
        
    }else {
        
        echo"Invalid User";
    }

   
}
if (isset($_POST['login'])) {

    $id = $_POST['id'];
    $user = $_POST['user'];
    $pass = $_POST['pass'];

    $queryy = "UPDATE log_in SET user='$user', pass='$pass' WHERE id='$id' ";
    $query_run = mysqli_query($connn, $queryy);

    if ($query_run) {
        # code...                                                               
        echo '<script>alert("Data Updated");</script>';                          
        header("location: Dashhboard_page.php");
    }                                                                                                                                                                               
    else {
        echo '<script>alert ("Data Updated");</script>';
    }
}
if (isset($_POST['updatet'])) {
    $id = $_POST['id'];
    $fullname = $_POST['fullname'];
    $contact = $_POST['contact'];
    $address = $_POST['address'];
    $file_name = $_FILES['profile']['name'];
    $tempname = $_FILES['profile']['tmp_name'];
    $folder = '/opt/lampp/htdocs/prac/uploads/'.$file_name;


    $queryy = "UPDATE addtenants SET fullname='$fullname', contact='$contact', address='$address', profile='$file_name' WHERE id='$id' ";
    $query_runn = mysqli_query($connn, $queryy);

    if ($query_runn) {
        # code...                                                               
        echo '<script>alert("Data Updated");</script>';                          
        header("location: tenants_page.php");
    } 
    
    if (move_uploaded_file($tempname, $folder)) {
        # code...
    
        header("location: tenants_page.php");

      }else{
        echo"
        <h2>File not uploaded successfully Added</h2>
        ";
      }

}


if (isset($_POST['roomupdate'])) {
    # code...
    $id = $_POST['id'];
    $room_number = $_POST['room_number'];
    $description = $_POST['description'];
    $file_name = $_FILES['roompic']['name'];
    $tempname = $_FILES['roompic']['tmp_name'];
    $folder = 'file/'.$file_name;


    $queryy = "UPDATE addroom SET room_number='$room_number', description='$description', roompic='$file_name' WHERE id='$id' ";
    $query_runn = mysqli_query($connn, $queryy);

    if ($query_runn) {
        # code...                                                               
        echo '<script>alert("Data Updated");</script>';                          
        header("location: rooms_page.php");
    } 
    
    if (move_uploaded_file($tempname, $folder)) {
        # code...
    
        header("location: rooms_page.php");

      }else{
        echo"
        <h2>File not uploaded successfully Added</h2>
        ";
      }
}

if (isset($_POST['update_payments'])) {

    $id = $_POST['id'];
    $tena_nts = $_POST['tena_nts'];
    $bed_number = $_POST['bed_number'];
    $room_number = $_POST['room_number'];
    $expected_amount = $_POST['expected_amount'];
    $paid_amount = $_POST['paid_amount'];
    $date_of_paid = $_POST['date_of_paid'];
    $bala_nce = $_POST['bala_nce'];

    $queryy = "UPDATE pay_ments SET tena_nts='$tena_nts', bed_number='$bed_number', room_number='$room_number', expected_amount='$expected_amount',paid_amount='$paid_amount',date_of_paid='$date_of_paid', bala_nce='$bala_nce' WHERE id='$id' ";
    $query_runn = mysqli_query($connn, $queryy);

    if ($query_runn) {
        # code...                                                               
        echo '<script>alert("Data Updated");</script>';                          
        header("location: payments_page.php");
    }                                                                                                                                                                               
    else {
        echo '<script>alert ("ERROR!!");</script>';
    }
}


if (isset($_POST['update_suggest'])) {

    $id = $_POST['id'];
    $sug_gest = $_POST['sug_gest'];
    $da_te = $_POST['da_te'];
    $reply_owner = $_POST['reply_owner'];
    $sta_tus = $_POST['sta_tus'];


    $queryy = "UPDATE sugge_stion SET sug_gest='$sug_gest', da_te='$da_te', reply_owner='$reply_owner', sta_tus='$sta_tus' WHERE id='$id' ";
    $query_runn = mysqli_query($connn, $queryy);

    if ($query_runn) {
        # code...                                                               
        echo '<script>alert("Data Updated");</script>';                          
        header("location: suggestions_page.php");
    }                                                                                                                                                                               
    else {
        echo '<script>alert ("ERROR!!");</script>';
    }
}

if (isset($_POST['update_bedroom'])) {
    $id = $_POST['id'];
    $bed_number = $_POST['bed_number'];
    $room_number = $_POST['room_number'];
    $monthly_rent = $_POST['monthly_rent'];
    $sta_tus = $_POST['sta_tus'];
    $file_name = $_FILES['image']['name'];
    $tempname = $_FILES['image']['tmp_name'];
    $folder = 'file/'.$file_name;


    $queryy = "UPDATE bed_management SET bed_number='$bed_number', room_number='$room_number', monthly_rent='$monthly_rent', sta_tus='$sta_tus', image='$file_name' WHERE id='$id' ";
    $query_runn = mysqli_query($connn, $queryy);

    if ($query_runn) {
        # code...                                                               
        echo '<script>alert("Data Updated");</script>';                          
        header("location: bed_page.php");
    } 
    
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
?>