<?php
session_start();

$conn = new mysqli('localhost',"root","",'basanta_db');
if($conn->connect_error){
    die("connection failed". $conn->connect_error);
}

if($_SERVER['REQUEST_METHOD']=="POST"){
    $username = $_POST['username'];
    $email = $_POST['email'];
    $password = $_POST['password'];

    if(empty($username) || empty($email) || empty($password)){
        echo"Emptyness is not required";
        exit();//Output a message and terminate the current script
    }
   if(!filter_var($email,FILTER_VALIDATE_EMAIL)){
        echo "Invalid email format.";
        exit();
    }

     // Check if username or email already exists
    $sql1 ="SELECT *FROM blog_table WHERE username = ? OR email = ?";
    $stmt1 = $conn->prepare($sql1);
    if($stmt1 === false){
        echo"prepare stmt failed  ";
    }
    $stmt1->bind_param("ss",$username,$email);
    $stmt1->execute();

    $stmt1->store_result();//stores result
    
    //checking if stored result is greater than 0
    if($stmt1->num_rows > 0){
        echo"username or email is already taken ";
        $stmt1->close();
    }else{
        //ifnot insert data into table
        $sql = "INSERT INTO blog_table (username,email,password) VALUES (?,?,?)";
        $stmt = $conn->prepare($sql);
        if ($stmt === false) {
            die("Prepare statement failed: " . $conn->connect_error);
        }

        $stmt->bind_param("sss",$username,$email,$password);
        if($stmt->execute()){
            echo" Reggistration successful";
            $_SESSION["username"] = $username;
            header('location:login.php');
            exit();
        }else{
            die(" execution failed".$stmt->error);
        }
        $stmt->close();
        $stmt1->close();
        }
    $conn->close();
    }
   
?>


<!DOCTYPE html>
<html>
<head>
    <title>Register</title>
</head>
<body>
    <h2>Register</h2>
    <form action="register.php" method="post">
        <label for="username">Username:</label>
        <input type="text" id="username" name="username" required>
        <br>
        <label for="email">Email:::::::</label>
        <input type="email" id="email" name="email" required>
        <br>
        <label for="password">Password:</label>
        <input type="password" id="password" name="password" required>
        <br><br>
        <button type="submit">Register</button>
    </form>
    <br>
    <button ><a href="login.php">Login</a></button>
</body>
</html>
