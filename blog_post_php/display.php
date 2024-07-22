<?php

session_start();
if (isset($_SESSION['username'])) {
    $username = $_SESSION['username'];
    echo 'Welcome, ' . $_SESSION['username'];
} else {
    echo 'You are not logged in.';
}
// authentication check
if (!isset($_SESSION['username'])) {
    echo"<h2> The page couldnot be found plz try again ERROR 1</h2>"; 
    exit();
}

$conn = new mysqli('localhost',"root","",'basanta_db');
if($conn->connect_error){
    die("connection failed". $conn->connect_error);
}


$sql ="SELECT * FROM post_table  ";
$result = $conn->query($sql);
$fetched_data = array();
if($result->num_rows>0){
    $fetched_data = $result->fetch_all(MYSQLI_ASSOC);
}else{
    $fetchedData = array();
    echo"no blog found";
}

$sql2 ="SELECT * FROM comment_table  ";
$result2 = $conn->query($sql2);
$fetched_data2 = array();
if($result2->num_rows>0){
    $fetched_data2 = $result2->fetch_all(MYSQLI_ASSOC);
}else{
    echo"no comment found";
}

?>
<!DOCTYPE html>
<html>
<head>
    <title>Blog Posts</title>
</head>
<body>
    <h1>Blog Posts</h1>
     <form action="Home.php">
        <!-- send username in url line 11 in home  -->
        <input type="hidden" name="username" value="<?php echo htmlspecialchars($username); ?>">
        <button type="submit">Create new Post</button>
     </form>
    <hr>
    <table border="1">
        <th>id</th>
        <th>author</th>
        <th>title</th>
        <th>content</th>
    
    <?php
            foreach ($fetched_data as $data) {
        ?>
        <tr>
            <td><?php echo $data['id']; ?></td>
            <td><?php echo $data['username']; ?></td>
            <td><?php echo $data['title']; ?></td>
            <td><?php echo $data['content']; ?></td>
        </tr>
        <?php
        }
    
    ?>
    </table>
    <br>
    <hr>
    <form action="comment.php" method="post">
    <textarea name="content" id="" cols="30" rows="10">this is a comment</textarea>
    <button>Add comment</button>
    <hr>
    <br>
    <table border="1">
        <th>id</th>
        <th>author</th>
        <th>content</th>
    
    <?php
            foreach ($fetched_data2 as $comment) {
        ?>
        <tr>
            <td><?php echo $comment['id']; ?></td>
            <td><?php echo $comment['username']; ?></td>
            <td><?php echo $comment['content']; ?></td>
        </tr>
        <?php
        }
    
    $conn->close();
    ?>
    </table>
</body>
</html>
