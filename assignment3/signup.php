<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>signup</title>
	<link href="https://codd.cs.gsu.edu/~lhenry23/Asg03/nerdieluv.css" type="text/css" rel="stylesheet">
</head>
<body>
	<!--Show the header-->
	<?php require 'common.php'; headerFunc();?>
	<!--the form that will pass onto signup-submit.php-->
	<form action="signup-submit.php" method="post" enctype="multipart/form-data">
		<fieldset>
			<legend>New User Signup:</legend>
			<strong>Name:</strong>
				<input type="text" name="name" size="16"><br><br>
			<strong>Gender:</strong>
				<label><input type="radio" name="gender" value="M"> Male </label>       <!--label tag makes text clickable-->
 				<label><input type="radio" name="gender" value="F"> Female</label> <br><br>
			<strong>Age:</strong>
				<input type="text" name="age" size="6" maxlength="2" ><br><br>
			<strong>Personality type:</strong>
				<input type="text" name="perType" size="6" maxlength="4" > (<a href="http://www.humanmetrics.com/cgi-win/JTypes2.asp">Don't know your type?</a>)<br><br>
			<strong>Favorite OS:</strong>
				<select name="system"> 
				<option selected> Windows </option>
				<option> Mac OS X </option>
				<option> Linux </option>
				</select> <br><br>
			<strong>Seeking age:</strong>
				<input type="text" name="ageMin" size="6" maxlength="2" placeholder="min"> to <input type="text" name="ageMax" size="6" maxlength="2" placeholder="max"><br><br>
			<strong>Photo:</strong>
				<input type="file" name="profilePic">
			<input type="submit" value="Sign Up">
		</fieldset>
	</form>
	<br><br><br>
	<!--Show the footer-->
	<?php 
		footerFunc();
		backToFP();
		validatorImages();
	?>

</body>
</html>