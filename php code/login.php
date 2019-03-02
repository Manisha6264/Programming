<?php 
require "conn.php";
$type= $_POST["type"];
$user_name= $_POST["username"];
$user_pass= $_POST["pwd"];
$json=array();
session_start();
if($type=="People")
{
  $mysql_qry = "select * from peopleregistration where mid='".$user_name."' and pwd='".$user_pass."'";
}
if($type=="Orphanage")
{
$mysql_qry = "select * from orphanageregistration where mid='".$user_name."' and pwd='".$user_pass."'";	
}	


$result = mysqli_query($conn,$mysql_qry);
if(mysqli_num_rows($result) > 0)
 {	$_SESSION['mail']= $_POST['username'];
	$json['msg']='Hai';
	$json['value']=1;
	//echo "Login Success !!!!! Welcome User";
echo  json_encode($json);
}
else
 {
	$json['msg']='sorry';
	$json['value']=0;
//echo "Login not success";
echo json_encode($json);

 }

 
?>