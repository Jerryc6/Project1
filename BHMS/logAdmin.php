<?php
// Get username and password from POST request
if ($_SERVER["REQUEST_METHOD"] == "POST") {
    $user = $_POST['user'];
    $pass = $_POST['pass'];


    $servername = "localhost"; // Usually localhost
    $username = "user"; // Your database username
    $password = ""; // Your database password
    $dbname = "bhms"; // Your database name


    $con = new mysqli($servername, $username, $password, $dbname);

    if ($con->connect_error) {
        die("Connection failed: " . $con->connect_error);   
    }

    $query = "SELECT * FROM log_in WHERE user= '$user' AND pass= '$pass' ";
    $result = $con->query($query);

    if ($result->num_rows == 1 ) {
        # code...
        header("Location: Dashhboard.php");
        
    }else {
        # code...
        echo "<script> console.log('Errro');</script>";
        exit();
    }

    $con->close();
}

?>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="CSS/logAdmin.css">
    <title>Admin</title>
</head>
<body >
    <div class="JPanel">
        <form action="" method="post">
            <h1>Administrator</h1>
                
            <div class="JTextField">
                <input type="text" placeholder="Username" name="user" id="user" required>
            </div>

            <div class="JPasswordField">
                <input type="password" placeholder="Password" name="pass" id="pass" required >
            </div>



            <button type="submit" class="btnLogin" name="login">Login</button>

        </form>
    </div>

</body>
</html>

