<?php
session_start();

$valid_username = "user1234";
$valid_password = "user1234";


if($_SERVER['REQUEST_METHOD']=="POST"){

    $user = $_POST['username'];
    $pass = $_POST['password'];
    if($user == $valid_username && $pass == $valid_password ){

        $_SESSION['USERNAME'] = "user";
        $_SESSION['LOGGEDIN'] = "true";
        
        header("location:home.php");
        exit();
    }else{
        echo "Wrong Credentials Please try again";
    }
}

?>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <form action="<?php echo htmlspecialchars($_SERVER['PHP_SELF']); ?>" method="post">

    <label for="username">UserName::</label>
    <input type="text" name="username" value="user1234"><br><br>
    <label for="password">Password::</label>
    <input type="text" name="password" value="">
    <input type="submit"  >
    </form>
</body>
</html>