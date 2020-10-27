<?php  
	function headerFunc(){
		echo '<header id="bannerarea">';
		echo '<img src="imgs/nerdLuv.png">';
		echo '<br />';
		echo "where meek geeks meet";
		echo '</header>';
	}
	//I have 3 things that are "footers" instead of 1 because I didn't want to have a back to front page on index which is the front page
	function footerFunc(){
		echo '<footer>';
		echo 'This page is for single nerds to meet and date each other! Type in';
		echo '<br />';
		echo 'your personal information and wait for the nerdy luv to being!';
		echo '<br />';
		echo 'Thank you for using our site.';
		echo '<br /><br />';
		echo 'Results and page (C) Copyright NerdLuv Inc.';
		echo '</footer>';
	}
	function backToFP(){
		echo '<br /><a href="index.php"><img src="imgs/back.png">Back to front page</a>';
	}
	function validatorImages(){
		echo 
		'
		<br /><br /><br />
		<div id="w3c">
			<a href="https://validator.w3.org/"><img src="imgs/w3c-xhtml.png" alt="xhtml validator image"></a>
			<a href="http://jigsaw.w3.org/css-validator/"><img src="imgs/w3c-css.png" alt="css validator image"></a>
		</div>
		';
	}	
?>





