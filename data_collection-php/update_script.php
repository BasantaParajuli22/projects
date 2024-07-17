<?php
require "db_connection.php";

$id = isset($_GET["id"]) ? $_GET["id"] : null;//define $ID N CHECK if it is empty or not

//selects all the previous data of table to modify
if ($id) {
    $sql = "SELECT * FROM user_details WHERE id = $id";
    $result = $conn->query($sql);//result making connection with query($sql) and gets num_rows

    if ($result->num_rows > 0) {//result ma no of rows aauxa num_rows tyo zero 0 bhanda dherai bahya
        $row = $result->fetch_assoc();
    } else {
        echo "No record found with the given ID";
    }
}
// after update button is pressed update pass here to post data
if (isset($_POST['update'])) {
    //all data as 'id' 'name' goes to variable
    $id = $_POST['id'];
    $name = $_POST['name'];
    $email = $_POST['email'];
    $phone = $_POST['phone'];
    $faculty = $_POST['faculty'];
    $gender = $_POST['gender'];

    $sql = "UPDATE user_details SET name='$name', email='$email', phone='$phone', faculty='$faculty', gender='$gender' WHERE id=$id";

    if ($conn->query($sql) === TRUE) {
        echo "Record updated successfully";
        echo " <br> <br>";
    } else {
        echo "Error updating record: " . $conn->error;
    }
}

?>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Update Record</title>
</head>
<body>
    <?php if ($id): ?>
        <form method="post" action="<?php echo $_SERVER['PHP_SELF'] . '?id=' . $id; ?>">
            <input type="hidden" name="id" value="<?php echo $id; ?>">
            <!-- to not be seen or changed -> hidden-->
            <label>Name:</label>
            <input type="text" name="name" value="<?php echo $row['name']; ?>"><br>
            <label>Email:</label>
            <input type="email" name="email" value="<?php echo $row['email']; ?>"><br>
            <label>Phone:</label>
            <input type="text" name="phone" value="<?php echo $row['phone']; ?>"><br>
            <label>Faculty:</label>
            <input type="text" name="faculty" value="<?php echo $row['faculty']; ?>"><br>
            <label>Gender:</label>

            <input type="text" name="gender" value="<?php echo $row['gender']; ?>"><br>
            <input type="submit" name="update" value="Update">
            <!-- if update button is pressed it sends name -> update   -->
        </form>
    <?php endif; ?>

    <br><br>
    <button><a href="display.php">Display All</a></button>
    <br><br>
    <button><a href="tableform.php">ADD New</a></button>
</body>
</html>