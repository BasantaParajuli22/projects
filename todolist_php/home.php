<?php
//checking if login is true or not
session_start();
if(!isset($_SESSION['USERNAME']) || $_SESSION['LOGGEDIN']!=true){
   header("location:login.php");
   exit();
}
//connecting to server
 $servername = "localhost";
 $database = "basanta_db";
 $username = "root";
 $password = "";

 $conn = new mysqli($servername,$username,$password,$database);
 if($conn->connect_error){
    die("Connection failed ". $conn->connect_error);
 }else{
    echo "Connection Established";
 }

//selecting all data from database
    $tasksarray = []; 
    $statusarray = []; 
    $idarray = []; 

    $sql = "SELECT * FROM todo_table";
    $result = $conn->query($sql);
     if($result->num_rows>0){
        while ($row = $result->fetch_assoc()) {
            $tasksarray[] = $row['TASK'];//TASK is table column name
            $statusarray[] = $row['Status'];
            $idarray[] = $row['id'];
        }
     }else{
        echo "no data found";
    }

    #for completed task removing them
    if($_SERVER["REQUEST_METHOD"]== "POST"){

        if(isset($_POST['completed'])){
            //making completed as [] to use foreach
            //for every value of id receive 
          foreach($_POST['completed']as $id_var) {
            //we delete them
            $sql = "DELETE FROM todo_table WHERE id = ?";
            $stmt =  $conn->prepare($sql);

            if($stmt == false){
                die("prepare failed".$conn->error);
            }
         
            $stmt->bind_param("s",$id_var);
            if($stmt->execute()==false){
                die("execution failed".$stmt->error);
            }
            $stmt->close();
        }
        }
        //refresh
        header('location:home.php');
        exit();
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
    <h2>All UnCompleted tasks::</h2>
    <ol>
    <form action="<?php echo htmlspecialchars($_SERVER['PHP_SELF']); ?>" method="post">

        <?php foreach ($tasksarray as $index => $task): ?>
        <li>
            <input type="checkbox"  name="completed[]" value="<?php echo htmlspecialchars($idarray[$index]);?>">
        
            <?php echo htmlspecialchars($tasksarray[$index]); ?>
            ==
            <?php echo htmlspecialchars($statusarray[$index]); ?>
        </li>

        <?php endforeach; ?>   
    <button type="submit">Submit</button>
    </form>
    </ol>
    <br>
    <button type="submit" ><a href="addtask.php">Add more task</a></button> 
    <button type="submit" ><a href="logout.php">logout</a></button><br>

</body>
</html> 