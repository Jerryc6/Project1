<?php
//connect to database
$conn = mysqli_connect('localhost','admin321','pass123','admin');

//Check connection
if(!$conn){
    echo 'Connection error:' .mysqli_connect_error();
}

//get database
$sql = 'SELECT id, Menu, Ingredients FROM jollikod';

//make query & get result
$result = mysqli_query($conn, $sql);

//fetch the result
$jollikod = mysqli_fetch_all($result, MYSQLI_ASSOC);
print_r ($jollikod);
?>