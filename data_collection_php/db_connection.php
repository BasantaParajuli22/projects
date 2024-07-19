<?php
// Database connection details

$db_host = "localhost";
$db_username = "root";
$db_password = "";
$db_name = "basanta_db";

// Create a connection
$conn = new mysqli($db_host, $db_username, $db_password, $db_name);

// Check connection
if ($conn->connect_error) {
    die("Connection failed: " . $conn->connect_error);
} 

// $conn->close();//not closing here because action is not completed where it is called
?>