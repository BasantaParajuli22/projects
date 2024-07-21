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
    $title = $_POST['title'];
    $content = $_POST['content'];
    $username = $_SESSION['username'];

    $stmt = $conn->prepare("INSERT INTO post_table (title, username, content) VALUES (?, ?, ?);");
    $stmt->bind_param("sss", $title,$content,$username);
    if($stmt->execute()){
        $_SESSION["username"] = $username;
        $_SESSION['message'] = "Posted successful! Congrats, $username.";
        header("location: /blog_post/$username");//double quotation compulsory
        exit();
    }else{
        die("prepared statement failed".$stmt->error);
    }
    $stmt->close();
}
$conn->close();


?>