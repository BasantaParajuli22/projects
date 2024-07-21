<?php
session_start();

//connecting database for username and password
$conn = new mysqli('localhost',"root","",'basanta_db');
if($conn->connect_error){
    die("connection failed". $conn->connect_error);
}

// Check if the form has been submitted
if ($_SERVER["REQUEST_METHOD"] == "POST") {
    // Get the submitted username and password from form
    $username = $_POST["username"];
    $password = $_POST["password"]; 
    
    $sql ="SELECT password FROM blog_table WHERE username = ?";
    $stmt = $conn->prepare($sql);
    if($stmt === false){
        echo "prepare stmt failed " . htmlspecialchars($conn->error) ;
        exit();
    }
    // Bind parameters
    $stmt->bind_param("s",$username);
    $stmt->execute();

    // Bind result variables
    $stmt->bind_result($stored_password);//variables should be same as selected
    $stmt->fetch();
    
    if ($password == $stored_password) {
        // Set the session variables
        $_SESSION["username"] = $username;
        $_SESSION["loggedin"] = true;
        // Redirect the user to the next page
        header("Location: /blog_post/$username");
        exit();
    } else {
        // Display an error message
        $error_message = "Invalid username or password.";
    }
    $stmt->close();
    $conn->close();
}
?>


<!DOCTYPE html>
<html>
<head>
    <title>Login</title>
</head>
<body>
    <h2>Login</h2>
    <form action="login.php" method="post">
        <label for="username">Username:</label>
        <input type="text" id="username" name="username" required>
        <br>
        <label for="password">Password:</label>
        <input type="password" id="password" name="password" required>
        <br>
        <br>
        <button type="submit">Login</button>
        <button type="submit" ><a href="register.php">Register</a></button>
    </form>
</body>
</html>
