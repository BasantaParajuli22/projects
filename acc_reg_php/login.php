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

        //here hash password n password wont match
    // $sql ="SELECT *FROM register_table WHERE username = ? AND  password = ?";  
    
        $sql ="SELECT id,password FROM register_table WHERE username = ?";
        $stmt = $conn->prepare($sql);
        if($stmt === false){
            echo "prepare stmt failed  ";
        }
        $stmt->bind_param("s",$username);//s is args and giving value to ? //
        $stmt->execute();
        $stmt->store_result();
    
        if($stmt->num_rows()>0){
            $stmt->bind_result($id, $hashed_password);
            // using bind_result needs to match the number of columns selected in your SQL query. 
            $stmt->fetch();//binding to fetch hashed_pasword
            if(password_verify($password,$hashed_password)){
                echo"check true";
                $_SESSION['username']= "$username";
                $_SESSION['id']= "$id";
                header('location:Home.php');
                exit();
            }else{
            echo"login failed please try again";
            echo "<br>";
            echo $username;
            echo "<br>";
            echo $id;
            echo "<br>";
            echo $hashed_password;
            }  
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
