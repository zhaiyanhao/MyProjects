<?php
mysql_connect('localhost','root','') or die('Could not connect');
mysql_select_db('youtube') or die('Could not connect');

$username_in = $_POST['username'];
$password_in = $_POST['password'];
$query= "select email,phone from e_menu where name='".$username_in."' AND password = '".$password_in. "'";

$query_exec = mysql_query($query) or die('Could not connect query');

$row = mysql_num_rows($query_exec);
$result = mysql_fetch_array($query_exec);
if($row ==0){
	echo "0";
}else{
echo "1"." ".$result['email'] . " " . $result['phone'];
}

?>
