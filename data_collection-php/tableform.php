
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Simple Form</title>
</head>
<body>
    <h2>Simple Form</h2>
    <form action="insert.php" method="POST">
  
        <label for="name">Name:</label><br>
        <input type="text" id="name" name="name" required><br><br>
  
        <label for="email">Email:</label><br>
        <input type="text" id="email" name="email" required><br><br>

        <label for="phone">Phone no:</label><br>
        <input type="text" id="phone" name="phone" required><br><br>

        <label for="faculty">faculty:</label><br>
        <input type="text" id="faculty" name="faculty" required ><br><br>

        <label for="address">address:</label><br>
        <input type="text" id="address" name="address" required><br><br>

        <label for="gender">Gender:</label><br>
        <input type="text" id="gender" name="gender" value ="unknown"><br><br>  
        
        <input type="submit" value="Submit">
    </form>
</body>
</html>


<!-- Create a table in sql in this format id to uniquely identify them -->
<!--  
CREATE TABLE `user_details` (
    `id` INT NOT NULL AUTO_INCREMENT,
    `name` VARCHAR(50) NOT NULL,
    `email` VARCHAR(50) NOT NULL,
    `phone` VARCHAR(50) NOT NULL,
    `faculty` VARCHAR(50) NOT NULL,
    `address` VARCHAR(50) NOT NULL,
    `gender` VARCHAR(50) NOT NULL,
    PRIMARY KEY (`id`)
) ENGINE = InnoDB;
-->