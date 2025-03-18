<?php

require_once ('database.php');

if (isset($_POST['savebed'])) {
    # code...
    $user = $_POST['user'];
    $pass = $_POST['pass'];

    $query = mysqli_query($connn, "insert into log_in(user, pass)values('$user','$pass')");
    if (move_uploaded_file($tempname, $folder)) {
      # code...
        header("location: login.php");
    }else{
        header('location:login.php');
    }
  }

?>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="CSS/first.css">
    <title>create account</title>
</head>
<body>
 <div class="main-body">
    <div class="JPanel">
        <form action="" method="POST">
            <h1>Create Account</h1>
                    
            <div class="JTextField">
                <input type="text" placeholder="Username" id="user" name="user" required>
            </div>
    
            <div class="JPasswordField">
                <input type="text" placeholder="Password" id="pass" name="pass" required >
            </div>
            <button type="submit" class="btnLogin" name="savebed" >Login</button>
    
        </form>
    </div>
 </div>   


</body>
</html>