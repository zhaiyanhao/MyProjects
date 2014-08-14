<?php
mysql_connect('localhost','root','') or die('Could not connect');
mysql_select_db('youtube') or die('Could not connect');

$username_in = $_POST['username'];
$flavor_in = $_POST['flavor'];
$rice_in = $_POST['rice'];
$bean_in=$_POST['bean'];
$meat_in=$_POST['meat'];
$ingredient_in=$_POST['ingredient'];
$source_in=$_POST['source'];
$query= "select * from e_menu where name='".$username_in."' AND password = '".$password_in. "'";
$inquery =" update e_menu set flavor='".$flavor_in."', rice='".$rice_in. "',bean='".$bean_in. "',meat='".$meat_in. "',ingredient='".$ingredient_in. "',source='".$source_in. "' where name='".$username_in."'";

$query_exec = mysql_query($inquery) or die('Could not connect query');

echo "1";

?>
