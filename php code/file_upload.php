<?php
    
    $iname=$_FILES['uploadedfile']['name'];
    $name=$_POST["t1"];
	 $age=$_POST["t2"];
	  $gname=$_POST["t3"];
	   $phoneno=$_POST["t4"];
	    $address=$_POST["t5"];
    
    //$tid=intval($_POST['sub1']);
    
	$target_path="missing/";
	
    
	$target_path =$target_path.basename( $_FILES['uploadedfile']['name']);
 
    if(move_uploaded_file($_FILES['uploadedfile']['tmp_name'], $target_path)) 
    {
    		echo "The file ".  basename( $_FILES['uploadedfile']['name'])." has been uploaded";
    		//chmod ("missing/".basename( $_FILES['uploadedfile']['name']), 0644);
                $servername = "localhost";
$username = "root";
$password = "";
$dbname = "rescuethechild";

$conn = mysqli_connect($servername, $username, $password, $dbname);
if (!$conn)
	{
    		die("Connection failed: " . mysqli_connect_error());
	}
$query="insert into temple(name,age,gname,phoneno,address,imgpath)values('$name','$age','$gname','$phoneno','$address','http://192.168.43.200/rescuethechild/$target_path')";
    if(mysqli_query($conn,$query))
		{ 
		echo "Image name saved into database".$name; 
		}
		else
		{
		
		echo "Sorry, there was a problem uploading your file.";
		}            

    } 
    else
    {
    echo "There was an error uploading the file, please try again!";
    echo "filename: " .  basename( $_FILES['uploadedfile']['name']);
    echo "target_path: " .$target_path;
    }
    ?>