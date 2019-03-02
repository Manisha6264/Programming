<?php

$servername = "localhost";
$username = "root";
$password = "";
$dbname = "rescuethechild";

// Create connection
$conn = mysqli_connect($servername, $username, $password, $dbname);

// Check connection
if (!$conn) 
{
    die("Connection failed: " . mysqli_connect_error());
}

$offers=array();


$sql = "SELECT *FROM temple";
$result = mysqli_query($conn, $sql);

if (mysqli_num_rows($result) > 0) 
{
    // output data of each row
    while($row = mysqli_fetch_assoc($result)) 
	{
		        $row_array["id"]=$row["id"];
                $row_array["name"]=$row["name"];
                $row_array["age"]=$row["age"];
                $row_array["gname"]=$row["gname"];
                $row_array["phoneno"]=$row["phoneno"];
                $row_array["address"]=$row["address"];
                $row_array["imgpath"]=$row["imgpath"];
				array_push($offers,$row_array);
    	}
    echo json_encode($offers,JSON_UNESCAPED_SLASHES);
}
else 
{
    echo "Currently No Offers in this season";
}
mysqli_close($conn);
?>