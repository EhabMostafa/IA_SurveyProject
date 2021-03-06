


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
	<div id="fh5co-page">
            
		<a href="#" class="js-fh5co-nav-toggle fh5co-nav-toggle"><i></i></a>
		<aside id="fh5co-aside" role="complementary" class="border js-fullheight">

			<h1 id="fh5co-logo"><a href=""><img src="Resources/logo.png"></a></h1>
			<nav id="fh5co-main-menu" role="navigation">
				<ul>
                                        <li ><a>[UserName]</a></li>
					<li ><a href="/WEP-INF">Home</a></li>
                                        <li ><a href="getSurviesByuserId">Own Surveys</a></li>
                                        <li class="fh5co-active"><a >New Survey</a></li>
                                        <li ><a href="">Send E-mail</a></li>
                                        <li ><a href="">Open List</a></li>
                                        <li ><a href="">Reports</a></li>
                                        <li ><a href="">Logout</a></li>
				</ul>
			</nav>
		</aside>

		<div id="fh5co-main">
                     <% 
                        Survey s = new Survey();
                        ArrayList <Question> questions = new ArrayList <Question>();%>
                        
                    <%!  Survey survey(String name,String desc){
                                       
                                             Survey s = new Survey();   
                                                
                                             int userId=2;
                                                s.setDescription(desc);
                                                s.setName(name);
                                                s.setUserId(userId);
                                                s.setSuspend(false);
                                                return s;
                                                
                                    }
                                    %>
                   
                      
			<div class="fh5co-narrow-content">
				<h2 class="fh5co-heading animate-box" data-animate-effect="fadeInLeft">Add New Survey</h2>
                                 
                               
				<div class="row animate-box" data-animate-effect="fadeInLeft" >
				
				 <form action="addSurvey1"   >
                                    Survey Name
                                    <br>
                                     <input type="text" name="SurveyName" size="100"><br>
                                     Survey Description
                                     <input type="text" name="SurveyDescription" size="100"><br>
                                    
                                    <br>
                                    <center>
					            <input type="submit" name="survey" value="finish" size="150"  ><br><br>
					            </center>
					                    </form>
                                </div>
                                    
                                
                                     
				</div>
				
					             
                      
                    </div>

        </div>


	</body>
</html>
