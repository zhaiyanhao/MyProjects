<?php
mysql_connect('localhost','root','') or die('Could not connect');
mysql_select_db('youtube') or die('Could not connect');

$username_in = $_POST['username'];
$password_in = $_POST['password'];
$email_in = $_POST['email'];
$phone_in=$_POST['phone'];
$query= "select * from e_menu where name='".$username_in."' AND password = '".$password_in. "'";
$inquery =" insert into e_menu(name, password, email,phone) values('".$username_in."','".$password_in. "','".$email_in. "','".$phone_in. "')";

$query_exec = mysql_query($inquery) or die('Could not connect query');

echo "1";

?>
