<?php

//checking if login is true or not
session_start();
if(!isset($_SESSION['USERNAME']) || $_SESSION['LOGGEDIN']!=true){
   header("location:login.php");
   exit();
}

#Connecting to Database
 $servername = "localhost";
 $database = "basanta_db";
 $username = "root";
 $password = "";

 $error = ""; 

 $conn = new mysqli($servername,$username,$password,$database);
 if($conn->connect_error){
    die("Connection failed ". $conn->connect_error);
 }else{
    echo "Connection Established";
 }

 //to add task to the database
 if($_SERVER['REQUEST_METHOD'] == "POST"){
    $task = $_POST['task'];
    $status = "incompleted";

    $sql = "INSERT INTO todo_table (task,status) VALUES (?,?)";
    $stmt = $conn->prepare($sql);
    $stmt->bind_param("ss",$task,$status);

    if($stmt->execute()){
        header("location:home.php");
        exit();
    }else{
       $error = "NO success";
    }
    $stmt->close();
  
 }
 $conn->close();
?>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Logged IN</title>
</head>
<body>
    <form action="<?php htmlspecialchars($_SERVER["PHP_SELF"]);?>" method="post">

    <label for="task">ADD Task::</label><input type="text" name="task">
    <button type="submit" value="add">Submit</button>

    </form>
<h2> <?php echo $error; ?></h2>
</body>
</html> 