<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>index</title>
	<link href="https://codd.cs.gsu.edu/~lhenry23/Asg03/nerdieluv.css" type="text/css" rel="stylesheet">
</head>
<body>
	<!--show header-->
	<?php require 'common.php'; headerFunc();?>
	<!--middle section with links to other pages-->
	<h3>Welcome!</h3>
	<a href="signup.php"><img src="imgs/signup.png" alt="signupPicture">Sign up for a new account</a>
	<br>
	<a href="matches.php"><img src="imgs/heart.png" alt="heart">&nbsp;Check your matches</a>
	<br><br><br>
	<!--show footer-->
	<?php 
		footerFunc();
		validatorImages();
	?>
</body>
</html>