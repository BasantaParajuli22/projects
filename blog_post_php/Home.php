<?php
session_start();
//verifying if it is username as same as on url 
// Dummy authentication check
if (!isset($_SESSION['username'])) {
    echo"<h2> The page couldnot be found plz try again ERROR 1</h2>"; 
    exit();
}
// Fetch username from session
$loggedInUser = $_SESSION['username'];
$url_username = $_GET['username'] ;
// Check if the username in URL matches the logged-in user
if ($url_username !== $loggedInUser) {
    echo"<h2> The page couldnot be found plz try again ERROR 2</h2>"; 
    exit();
}

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
    <h2> <?php echo $_SESSION['username']; ?> </h2>
    <br>

    <h1>Create a New Blog Post</h1>
    <form action="store.php" method="post">
        
        <label for="title">Title:</label><br>
        <input type="text" id="title" name="title" required><br><br>
        
        <label for="content">Content:</label><br>
        <textarea id="content" name="content" rows="10" cols="30" required></textarea><br><br>
        
        <input type="submit" value="Submit">
    </form>
    <h2>
    <?php
    
    if (isset($_SESSION['message'])) {//getting message from store.php
        echo "<p style='color: green;'>" . htmlspecialchars($_SESSION['message']) . "</p>";
        // Unset the message after displaying
        unset($_SESSION['message']);
    }
    ?></h2>
    <button type="submit" ><a href="register.php">Register</a></button> 
    <button type="submit" ><a href="logout.php">logout</a></button><br>

</body>
</html> 