<?php
require_once "db_connection.php";

if (isset($_GET['edit'])) {
    $id = $_GET['edit'];
    $row = $conn->query("SELECT * FROM students WHERE id=$id")->fetch_array() or die($conn->error);
    extract($row);
}

if (isset($_POST['update'])) {
    $id = $_POST['id'];
    extract($_POST);
    $sql = "UPDATE students SET name=?, email=?, phone=?, faculty=?, gender=? WHERE id=?";
    $stmt = $conn->prepare($sql);
    $stmt->bind_param("sssssi", $name, $email, $phone, $faculty, $gender, $id);
    $stmt->execute() or die($stmt->error);
    header("Location: table.php");
    exit();
}
?>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Update Student</title>
</head>
<body>
    <form action="<?php echo htmlspecialchars($_SERVER["PHP_SELF"]);?>" method="POST">
        <input type="hidden" name="id" value="<?php echo $id ?? ''; ?>">
        <?php foreach (['name', 'email', 'phone', 'faculty', 'gender'] as $field): ?>
        <div>
            <label><?php echo ucfirst($field); ?>:</label>
            <input type="<?php echo $field == 'email' ? 'email' : 'text'; ?>" name="<?php echo $field; ?>" value="<?php echo $$field ?? ''; ?>" required>
        </div>
        <?php endforeach; ?>
        <div>
            <button type="submit" name="update">Update</button>
        </div>
    </form>
</body>
</html>