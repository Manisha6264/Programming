<?php
require "conn.php";
$name1=$_POST["name"];
$on1=$_POST["on"];
$mid1=$_POST["mid"];
$pwd1=$_POST["pwd"];
$add1=$_POST["add"];
$pn1=$_POST["pn"]; 

$sql="insert into orphanageregistration(name,ona,mid,pwd,add1,pn) 
values ('$name1','$on1','$mid1','$pwd1','$add1','$pn1')";
$result=mysqli_query($conn,$sql);
if($result==1)
{
	$json['msg']='Hai';
		$json['value']=1;
echo json_encode($json);
}
else
{
		$json['msg']='Sorry';
		$json['value']=1;
echo json_encode($json);
}
?>