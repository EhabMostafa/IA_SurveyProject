<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    
    <%@page import="Models.Answer"%>
<%@page import="Models.Survey"%>
<%@page import="Models.Question"%>
<%@page import="java.util.ArrayList"%>
<%@page import= "javax.servlet.http.HttpServletRequest"%>
<!DOCTYPE html>
<html class="no-js"> <!--<![endif]-->
	<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<title>Survey Me - AddSurvey</title>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	

 
	<link rel="shortcut icon" href="favicon.ico">

	<link href='https://fonts.googleapis.com/css?family=Roboto:400,300,600,400italic,700' rel='stylesheet' type='text/css'>
	<link href='https://fonts.googleapis.com/css?family=Montserrat:400,700' rel='stylesheet' type='text/css'>
	
	<!-- Animate.css -->
	<link rel="stylesheet" href="CSS/animate.css">
	<!-- Icomoon Icon Fonts-->
	<link rel="stylesheet" href="CSS/icomoon.css">
	<!-- Bootstrap  -->
	<link rel="stylesheet" href="CSS/bootstrap.css">
	<!-- Owl Carousel -->
	<link rel="stylesheet" href="CSS/owl.carousel.min.css">
	<link rel="stylesheet" href="CSS/owl.theme.default.min.css">
	<!-- Theme style  -->
	<link rel="stylesheet" href="CSS/style.css">

	<!-- Modernizr JS -->
	<script src="JavascriptCSS/modernizr-2.6.2.min.js"></script>
        
	<!-- jQuery -->
	<script src="JavascriptCSS/jquery.min.js"></script>
	<!-- jQuery Easing -->
	<script src="JavascriptCSS/jquery.easing.1.3.js"></script>
	<!-- Bootstrap -->
	<script src="JavascriptCSS/bootstrap.min.js"></script>
	<!-- Carousel -->
	<script src="JavascriptCSS/owl.carousel.min.js"></script>
	<!-- Stellar -->
	<script src="JavascriptCSS/jquery.stellar.min.js"></script>
	<!-- Waypoints -->
	<script src="JavascriptCSS/jquery.waypoints.min.js"></script>
	<!-- Counters -->
	<script src="JavascriptCSS/jquery.countTo.js"></script>
	
	
	<!-- MAIN JS -->
	<script src="JavascriptCSS/main.js"></script>
        <script src="JAVASCRIPT/AddSurvey.js"></script>
	<!-- FOR IE9 below -->
	<!--[if lt IE 9]>
	<script src="js/respond.min.js"></script>
	<![endif]-->

	</head>
	<body>


 
                                    
                                    <form action="addMCQ" >
                                         MCQ:
                                         <br>
                                         Question 
                                         <br>
                                         <input type="text" name="Question" size="100"/><br><br>
                                        A1  <input type="text" name="a1" size="15" />
                                        A2  <input type="text" name="a2" size="15" />
                                        A3  <input type="text" name="a3" size="15"/>
                                        A4  <input type="text" name="a4" size="15"/>
                                        
                                        
                                        <input type ="submit" name ="MCQSubmit"  >
                                     </form>
                                     
                                     
                                     <br> <br>
                                     <form  action="addTF" > 
                                         TrueFalse:
                                         <br>
                                         Question 
                                         <br>
                                         <input type="text" name="Question" size="100"><br><br>
                                         True  <input type="radio" name="Question" size="15">
                                            False  <input type="radio" name="Question" size="15">
                                            
                                             <input type ="submit" name ="TFSubmit" >
                                     </form>
                                     
                                     <br> <br>
                                     <form action="addFree" > 
                                         Free Answer:
                                         <br>
                                         Question 
                                         <br>
                                         <input type="text" name="Question" size="100"><br><br>
                                           <input type="submit" name="Question" size="100"><br><br>
                                     </form>
                                      <form action="AddSurveyForm" > 
                                        <center>
                                           <input type="submit" name="Question" value="finish" size="100"><br><br>
                                           </center>
                                     </form>
                                     
                                     
                                     


</body>
</html>