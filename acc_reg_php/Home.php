<?php
session_start();
//if login username true then login
if (!isset($_SESSION['username'])) {
    header("Location: login.php");
    exit();
}
// echo "Welcome, " . $_SESSION['username'] . "!";

?>


<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Logged IN</title>
</head>
<body>
    <h2>WELCOME HOME:</h2>
    <h2><?php echo "Welcome, " . $_SESSION['username'] . "!"; ?></h2>
    <br>
    <button type="submit" ><a href="register.php">Register</a></button> 
    <button type="submit" ><a href="logout.php">logout</a></button><br>

</body>
</html> 