<?php
mysql_connect('localhost','root','') or die('Could not connect');
mysql_select_db('youtube') or die('Could not connect');

$username_in = $_POST['username'];
$drink_in = $_POST['drink'];

$query= "select * from e_menu where name='".$username_in."' AND password = '".$password_in. "'";
$inquery =" update e_menu set drink='".$drink_in."' where name='".$username_in."'";

$query_exec = mysql_query($inquery) or die('Could not connect query');

echo "1";

?>
