<!DOCTYPE html>
<html >
<head>
  <meta charset="UTF-8">
  <title> Login Form</title>
  
  
  <link rel='stylesheet prefetch' href='https://fonts.googleapis.com/css?family=Open+Sans:600'>

      <link rel="stylesheet" href="CSS/style2.css">
   <script src='https://www.google.com/recaptcha/api.js'></script>
  
</head>
<!-- background:url(https://raw.githubusercontent.com/khadkamhn/day-01-login-form/master/img/bg.jpg) no-repeat center;
-->
<body>
  <div class="login-wrap">
      
	<div class="login-html">
            
		<input id="tab-1" type="radio" name="tab" class="sign-in" checked="true"><label for="tab-1" class="tab">Sign In</label>
		<input id="tab-2" type="radio" name="tab" class="sign-up"><label for="tab-2" class="tab">Sign Up</label>
		<div class="login-form">
			<div class="sign-in-htm">
			<br><br><br><br>
			<form id='login' action='LogIn' method='post' accept-charset='UTF-8'>
				<div class="group">
					<label for="username" class="label">Username</label>
					<input id="username" name ='username' type="text" class="input">
				</div>
				<div class="group">
					<label for="password" class="label">Password</label>
					<input id="password" type="password" class="input" data-type="password" name='password'>
				</div>
				<div class="group">
					<input type="submit" class="button" value="Sign In">
                                        
				</div>
                                <%
                                String Msg=(String)request.getAttribute("msg");
                                if(request.getAttribute("msg")!=null){
                                   out.print("<label>"+Msg+"</label>"); 
                                }
                                %>
                            
				<div class="hr"></div>
				<div class="foot-lnk">
				</div>
				</form>
                        
			</div>
			<div class="sign-up-htm">
         <script type="text/javascript">
    
        function sendajax(){
                 ;    
            var name = document.getElementById("usernameR").value;
            var xmlhttp = new XMLHttpRequest();
            
            xmlhttp.open("GET","CheckOnUsername?usernameR="+name,true);
            xmlhttp.send();
            
            xmlhttp.onreadystatechange=function()
            {
                if (xmlhttp.readyState==4 && xmlhttp.status==200)
                {
                   
                    document.getElementById("show_response").innerHTML=xmlhttp.responseText;
                }
            }
        }
    </script> 

    <form id='signup' action='AddAdminOrUser' method='post' onsubmit="sendajax()">
                            <% HttpSession Session = request.getSession(true) ;
                            Session.setAttribute("type","user");
                            %>
			<input type='hidden' name='submitted' id='submitted' value='1'/>
				<div class="group">
					<label for="user" class="label">username</label> 
                                        <input id='usernameR' name='usernameR' type='text' class='input' value='' required>
                                        <label id='show_response' class="label"></label>
				</div>
				<div class="group">
					<label for="pass" class="label">password</label>
					<input id='password' name='password' type='password' class='input' data-type='password' required>
				</div>
				<div class="group">
					<label for="email" class="label">email</label>
					<input id='email'  name='email' type='email' class='input' required >
				</div>
				<div class="group">
					<label for="gender" class="label">Gender</label>
				  	<label>female</label>	<input id='gender'  name='gender' type='radio'  class='input' value='female'>
					<label>Male</label>   <input id='gender'  name='gender' type='radio'  class='input' value='male' checked="true">
                                        
				</div>
                        
                               
				<div class="group">
                                  
					<input type="submit" class="button" value="Sign Up" >
					</form>
				</div>
				<div class="hr"></div>
				
			</div>
		</div>
	</div>
</div>
  
  
</body>
</html>
