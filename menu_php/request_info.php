<?php
mysql_connect('localhost','root','') or die('Could not connect');
mysql_select_db('youtube') or die('Could not connect');

$username_in = $_POST['username'];

$query= "select phone,email from e_menu where name='".$username_in."'";

$query_exec = mysql_query($query) or die('Could not connect query');

$row  = mysql_fetch_array($query_exec);

echo $row['email'] . " " . $row['phone'];


?>
