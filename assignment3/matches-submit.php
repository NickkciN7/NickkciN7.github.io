<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>matches-submit</title>
	<link href="https://codd.cs.gsu.edu/~lhenry23/Asg03/nerdieluv.css" type="text/css" rel="stylesheet">
</head>
<body>
	<!--Show the header-->
	<?php require 'common.php'; headerFunc();?>
	<!--middle section that displays matches' profiles-->
	<h3>Matches for <?php echo $_GET["name"];?></h3>
	
	<?php 
		$user = returnUser();			//calls function that goes through singles.txt and returns the user info matching name with GET variable
		$file = fopen("singles.txt","r");		//open singles.txt and go through every users info to find if they are matches 
		$noMatches = true;
		while(!feof($file))
		{
			$potentialMatch = explode(',', trim(fgets($file)) );		//gets a line from txt file, trims \n, explodes based on comma, and saves as variable
			$matchBool = isMatch($user, $potentialMatch);	//calls function that checks the criteria for matches described in the assignment insructions
			if($matchBool){
				$noMatches = false;
				$profilePic = 'imgs/user.jpg';  //default picture in case none uploaded for user
				if(findImage($potentialMatch) != "noneFound"){		//calls function to find the profilePicture name
					$profilePic = findImage($potentialMatch);			//if found replace the default profile picture
				}
				matchingProf($profilePic, $potentialMatch[0], $potentialMatch[1], $potentialMatch[2], $potentialMatch[3], $potentialMatch[4]);		//if it is a match, display profile on webpage by calling function
			}
		}
		fclose($file);
		if($noMatches){
			echo "<br /><br /><h3>Sorry, there are no matches.</h3>";
		}
	?>
	
	<br><br><br>
	<!--Show the footer-->
	<?php 
		footerFunc();
		backToFP();
		validatorImages();
	?>
</body>
</html>




<?php 
	//gets user info and produces profile html filled with info
	function matchingProf($img ,$name, $gender, $age, $type, $OS){
		echo 
		'<div class="match">
			<p><img height="150" src="' . $img .'">' . $name . '</p>
				<ul>
				  <li><strong>gender:</strong></li>
				  <li>' . $gender . '</li>
				  <li><strong>age:</strong></li>
				  <li>' . $age . '</li>
				  <li><strong>type:</strong></li>
				  <li>' . $type . '</li>
				  <li><strong>OS:</strong></li>
				  <li>' . $OS . '</li>
				</ul>
		</div>';
	}
	//based on the name passed with GET from matches.php, will return an array of info for that user
	function returnUser(){
		$file = fopen("singles.txt","r");
		while(!feof($file))
		{
			$userInfo = explode(',', trim(fgets($file)) ); //gets a line from txt file, trims \n, explodes based on comma, and saves as variable
			if($userInfo[0] == $_GET["name"]){
				fclose($file);
				return $userInfo;
			}
		}
		fclose($file);
	}
	//checks the criteria for described in assignment instructions.
	//first checks if they have the same name and are thus the same profile,next if they are same gender, next if each other fit in their age range(this is over 2 | checks), next is checking if they have the same favorite OS, and finally it checks their personality types by calling a function checkType()
	function isMatch($user, $potentialMatch){
		if( ($potentialMatch[0] == $user[0]) | ($potentialMatch[1] == $user[1]) | !( ($user[5] <= $potentialMatch[2]) & ($potentialMatch[2] <= $user[6]) ) | 
		    !( ($potentialMatch[5] <= $user[2]) & ($user[2] <= $potentialMatch[6]) ) | ($potentialMatch[4] != $user[4]) | !(checkType($user[3], $potentialMatch[3])) ){
			return false;
		}
		return true;
	}
	//receives the personality types of 2 users, splits the 2 types into arrays of characters, checks if and of those letters match, then returns true or false
	function checkType($uType, $pMType){
		$u = str_split($uType);
		$p = str_split($pMType);
		for($i = 0; $i < 4; $i++){
			if($u[$i] == $p[$i]){
				return true;
			}
		}
		return false;
	}

	//checks if the profile picture exists in initialUsers folder, or in the newUsers uploaded by visitor to site and returns that location string, if not return noneFound string. checks for png and jpg in newUsers, but only png in initialUsers because there are only pngs there
	function findImage($potentialMatch){
		if(file_exists('imgs/initialUsers/' . $potentialMatch[0] . '.png')){
			$profilePic = 'imgs/initialUsers/' . $potentialMatch[0] . '.png';
			return $profilePic;
		}
		else if(file_exists('imgs/newUsers/' . $potentialMatch[0] . '.png')){
			$profilePic = 'imgs/newUsers/' . $potentialMatch[0] . '.png';
			return $profilePic;
		}
		else if(file_exists('imgs/newUsers/' . $potentialMatch[0] . '.jpg')){
			$profilePic = 'imgs/newUsers/' . $potentialMatch[0] . '.jpg';
			return $profilePic;
		}
		return "noneFound";
	}
?>