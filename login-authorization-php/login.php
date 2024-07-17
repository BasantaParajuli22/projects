<?php
// Start the session
session_start();

// Define the valid login credentials
$valid_username = "basanta";
$valid_password = "123";

// Check if the form has been submitted
if ($_SERVER["REQUEST_METHOD"] == "POST") {
    // Get the submitted username and password
    $username = $_POST["username"];
    $password = $_POST["password"];

    // Verify the login credentials
    if ($username == $valid_username && $password == $valid_password) {
        // Set the session variables
        $_SESSION["username"] = $username;
        $_SESSION["loggedin"] = true;

        // Redirect the user to the next page
        header("Location: logggedin.php");
        exit();
    } else {
        // Display an error message
        $error_message = "Invalid username or password.";
    }
}
?>

<!DOCTYPE html>
<html>
<head>
    <title>Login Page</title>
</head>
<body>
    <h1>Login</h1>
    <?php if (isset($error_message)) { ?>
        <p style="color: red;"><?php echo $error_message; ?></p>
    <?php } ?>
    <form method="post" action="<?php echo htmlspecialchars($_SERVER["PHP_SELF"]);?>">
        Username: <input type="text" name="username"><br>
        Password: <input type="password" name="password"><br>
        <input type="submit" name="submit" value="Submit">
    </form>
</body>
</html>