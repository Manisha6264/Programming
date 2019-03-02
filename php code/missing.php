<?php
require "conn.php";

$fn1=$_POST["name"];
$ln1=$_POST["age"];
$mid1=$_POST["gn"];
$pwd1=$_POST["pn"];
$add1=$_POST["add1"];
//$pn1=$_POST["pn"]; 
$json=array();

$sql="insert into missing values ('".$fn1."','".$ln1."','".$mid1."','".$pwd1."','".$add1."','".$pn1."')";
$result=mysqli_query($conn,$sql);
if($result==1)
{
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