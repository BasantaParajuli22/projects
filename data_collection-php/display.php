<?php
// Database connection
include "db_connection.php";

// SQL query to retrieve data from the table
$sql = "SELECT * FROM user_details";
$result = $conn->query($sql);

// Check if the query was successful
if ($result->num_rows > 0) {//is checking if the number of rows returned by the query is greater than 0
    // Fetch the data and store it in the $fetchedData variable
    $fetchedData = $result->fetch_all(MYSQLI_ASSOC);
} else {
    $fetchedData = array(); // Initialize as an empty array if no data is available
}
?>


<html>
    <style> 
    table{
        border:1px red solid;
    }
    tr{
        border:1px red solid;
    }
</style>
<body>

<table border="1">
        <tr>
            <th>S.N</th>
            <th>Name</th>
            <th>Email</th>
            <th>Phone</th>
            <th>Faculty</th>
            <th>Gender</th>
            <th>Action</th>
        </tr>
        <?php
        if (count($fetchedData) > 0) {
            $counter = 1; //being use for id column
            foreach ($fetchedData as $data) {
        ?>
                <tr>
                    <td><?php echo $counter; ?></td>  
                    <td><?php echo $data['name']; ?></td>
                    <td><?php echo $data['email']; ?></td>
                    <td><?php echo $data['phone']; ?></td>
                    <td><?php echo $data['faculty']; ?></td>
                    <td><?php echo $data['gender']; ?></td>
                    <td><a href="delete_script.php?id=<?php echo $data['id']; ?>">Delete</a></td>
                     <!-- when delete button is pressed id is echoed in web  -->
                    <td><a href="update_script.php?id=<?php echo $data['id']; ?>">Update</a></td>
                   
                </tr>
        <?php
                $counter++;
            }
        } else {
            echo '<tr><td colspan="6">No Data Available!!!</td></tr>';
        }
        // Close connection
        $conn->close();
        ?>
    </table>
    <br>
    <br>
    <button> <a href="tableform.php">ADD New</a></button>
</body>
</html>