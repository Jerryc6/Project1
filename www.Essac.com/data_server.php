<?Php
$dns = "mysql:host=localhost;dbname=essu_server";
$dbusername = "essuserver";
$dbpassword = "sandyogario24";

try {
    $pdo = new PDO($dns, $dbusername, $dbpassword);
    $pdo->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
} catch (PDOException $e) {
    //throw $th;
    echo "Connection failed: " .$e->getMessage();
}

?>