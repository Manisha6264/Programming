<?php
require "conn.php";
session_start();
$fn1=$_POST["fn"];
$ln1=$_POST["ln"];
$mid1=$_POST["mid"];
$pwd1=$_POST["pwd"];
$add1=$_POST["add"];
$pn1=$_POST["pn"]; 
$json=array();

$sql="insert into peopleregistration values ('".$fn1."','".$ln1."','".$mid1."','".$pwd1."','".$add1."','".$pn1."')";
$result=mysqli_query($conn,$sql);
if($result==1)
{	$_SESSION['mail']=$_POST['mid'];
	$json['msg']='Hai';
		$json['value']=1;
echo json_encode($json);
}
else
{	$json['msg']='Sorry';
	$json['value']=0;
echo json_encode($json);
}
?>