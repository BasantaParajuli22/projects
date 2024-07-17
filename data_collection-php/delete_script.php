<?php
include "db_connection.php";// this statement copies everyting from db_connection.php to here 
/* no need to write cuz everything is included in db_connection.php
    // $db_host = "localhost";
    // $db_username = "root";
    // $db_password = "";
    // $db_name = "basanta_db";

    // // Create a connection
    // $conn = new mysqli($db_host, $db_username, $db_password, $db_name);

    // // Check connection
    // if ($conn->connect_error) {
    //     die("Connection failed: " . $conn->connect_error);
    // } 
*/


//to delete using id which is always unique so...
//when delete button is pressed id is taken
$id = $_GET["id"];
$sql = "DELETE FROM user_details WHERE id =" .$id;

//to check if something happened or not
if($conn->query($sql) === TRUE){
    echo "Delete successful";
}else{
    echo "ERROR::" . $conn->error;
}

$conn->close(); //connection closing here after action is completed
?>



<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <br>
    <br>
    <button><a href="display.php"> Display all </a> </button>

    <br>
    <br>
    <button> <a href="tableform.php">ADD New</a></button>
</body>
</html>