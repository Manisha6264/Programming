<?php
require "conn.php";
session_start();
$fn1=$_POST["fn"];
$ln1=$_POST["ln"];
$pwd1=$_POST["pwd"];
$add1=$_POST["add"];
$pn1=$_POST["pn"]; 
$json=array();
//$md="select fn from peopleregistration where mid='".$_SESSION['mail']."';";

$sql= "update peopleregistration set fn='".$fn1."',ln='".$ln1."',pwd='".$pwd1."',add1='".$add1."',pn='".$pn1."' where mid='".$_SESSION['mail']."';";
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
		//echo $sql;
echo json_encode($json);
}
?>