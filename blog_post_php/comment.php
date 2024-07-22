<?php
session_start();
if (!isset($_SESSION['username'])) {
    echo"<h2> The page couldnot be found plz try again ERROR 1</h2>"; 
    exit();
}
$conn = new mysqli('localhost',"root","",'basanta_db');
if($conn->connect_error){
    die("connection failed". $conn->connect_error);
}

if($_SERVER['REQUEST_METHOD']=="POST"){
    $content = $_POST['content'];
    $username = $_SESSION['username'];

    $stmt = $conn->prepare("INSERT INTO comment_table (username, content) VALUES (?,?);");
    if ($stmt === false) {
        die("Prepare statement failed: " . $conn->connect_error);
        
    }
    $stmt->bind_param("ss", $username, $content);

    if($stmt->execute()){
        echo" comment successful";
        $_SESSION["username"] = $username;
        header('location:display.php');
        exit();
    }else{
        die(" execution failed".$stmt->error);
    }
    $stmt->close();
}
$conn->close();


?>