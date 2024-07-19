<?php
// Database connection details
require "db_connection.php";

// Insert data into the database table
if ($_SERVER ['REQUEST_METHOD'] == 'POST'){
    // Get form data
    $name = $_POST['name'];
    $email = $_POST['email'];
    $phone = $_POST['phone'];
    $faculty = $_POST['faculty'];
    $address = $_POST['address'];
    $gender = $_POST['gender'];
    
$sql = "INSERT INTO user_details (name, email, phone, faculty, address, gender) VALUES ('$name', '$email', '$phone', '$faculty', '$address', '$gender')";
}

if ($conn->query($sql) === TRUE) {//if connection established with sql
    echo "New record created successfully";
} else {
    echo "Error: " . $sql . "<br>" . $conn->error;
}
 
    // Close connection
    $conn->close();
    
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