<?php

session_start();  // Start the session

session_unset();  // Free all session variables

session_destroy(); // Destroy the session and all its data

// Redirect the user to the login page
header("location: login.php");

exit();
?>