<?php
if ($_SERVER["REQUEST_METHOD"]=="POST") {
    # code...
    $school_year = $_POST["school_year"];
    $cam_pus = $_POST["cam_pus"];
    $ferst_degree = $_POST["ferst_degree"];
    $sicond_degree = $_POST["sicond_degree"];
    $therd_degree = $_POST["therd_degree"];
    $famely_name = $_POST["famely_name"];
    $ferst_name = $_POST["ferst_name"];
    $meddli_name = $_POST["meddli_name"];
    $Imail_addresss = $_POST["Imail_addresss"];
    $cuntact = $_POST["cuntact"];
    $munth = $_POST["munth"];
    $dey = $_POST["dey"];
    $yier = $_POST["yier"];
    $six = $_POST["six"];
    $sttatus = $_POST["sttatus"];
    $tawn = $_POST["tawn"];
    $brgy = $_POST["brgy"];
    $bungto = $_POST["bungto"];
    $province = $_POST["province"];
    $name_school = $_POST["name_school"];
    $address_school = $_POST["address_school"];
    $gen_average = $_POST["gen_average"];
    $highschool_year = $_POST["highschool_year"];

    

    try {
        require_once "data_server.php";
        $query = "INSERT INTO essu_form(school_year,cam_pus,ferst_degree,sicond_degree,therd_degree,famely_name,ferst_name,meddli_name,Imail_addresss,cuntact,munth,dey,yier,six,sttatus,tawn,brgy,bungto,province,name_school,address_school,gen_average,highschool_year)values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);";
        $stmt = $pdo-> prepare($query);
        $stmt->execute([$school_year, $cam_pus, $ferst_degree, $sicond_degree, $therd_degree, $famely_name, $ferst_name, $meddli_name, $Imail_addresss, $cuntact, $munth, $dey, $yier, $six, $sttatus, $tawn, $brgy, $bungto, $province, $name_school, $address_school, $gen_average, $highschool_year]);
        $pdo = null;
        $stmt = null;

        header("Location : ../essu_form.php");
        die();
    }catch(PDOException $e) {
        die("Query failed: " . $e->getMessage());
}

}
else {
    header("Location : ../essu_form.php");
}
?>