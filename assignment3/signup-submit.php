<!DOCTYPE html>
<html>
<head>
	<title></title>
	<link href="https://codd.cs.gsu.edu/~lhenry23/Asg03/nerdieluv.css" type="text/css" rel="stylesheet">
</head>
<body>
	<?php
		//upload the image to codd
		move_uploaded_file($_FILES["profilePic"]["tmp_name"], "imgs/newUsers/".$_FILES["profilePic"]['name']);
	?>



	<!--getting info from signup.php and storing it in singles.txt-->
	<?php
		$userInfo = $_POST["name"] . "," . $_POST["gender"] . "," . $_POST["age"] . "," . $_POST["perType"] . "," . $_POST["system"] . "," . $_POST["ageMin"] . "," . $_POST["ageMax"] . "\n"; 
		file_put_contents("singles.txt", $userInfo, FILE_APPEND);
	?>

	<!--Show the header-->
	<?php require 'common.php'; headerFunc();?>
	<!--Middle Section-->
	
	<h3>Thank you!</h3>
	Welcome to NerdLuv, <?php echo $_POST["name"]?>!
	<br><br>
	Now <a href="matches.php">log in to see your matches!</a>
	<br><br><br>
	<!--Show the footer-->
	<?php 
	footerFunc();
	backToFP();
	?>
</body>
</html>