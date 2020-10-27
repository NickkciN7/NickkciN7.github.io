<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>matches</title>
	<link href="https://codd.cs.gsu.edu/~lhenry23/Asg03/nerdieluv.css" type="text/css" rel="stylesheet">
</head>
<body>
	<!--Show the header-->
	<?php require 'common.php'; headerFunc();?>
	<!--the form that will pass onto matches-submit.php-->
	<form action="matches-submit.php" method="get">
		<fieldset>
			<legend>Returning User:</legend>
			<strong>Name:</strong>
				<input type="text" name="name" size="16"><br><br>
			<input type="submit" value="View My Matches">
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