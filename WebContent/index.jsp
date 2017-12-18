<!DOCTYPE html>
<html >
<head>
  <meta charset="UTF-8">
  <title> Login Form</title>
  
  
  <link rel='stylesheet prefetch' href='https://fonts.googleapis.com/css?family=Open+Sans:600'>

      <link rel="stylesheet" href="style.css">
   <script src='https://www.google.com/recaptcha/api.js'></script>
  
</head>
<!-- background:url(https://raw.githubusercontent.com/khadkamhn/day-01-login-form/master/img/bg.jpg) no-repeat center;
-->
<body>
  <div class="login-wrap">
      
	<div class="login-html">
            
		<input id="tab-1" type="radio" name="tab" class="sign-in" checked><label for="tab-1" class="tab">Sign In</label>
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
				<div class="hr"></div>
				<div class="foot-lnk">
				</div>
				</form>
                        
			</div>
			<div class="sign-up-htm">

			<form id='signup' action='AddAdminOrUser' method='post' >
                            <% HttpSession Session = request.getSession(true) ;
                            Session.setAttribute("type","user");
                            %>
			<input type='hidden' name='submitted' id='submitted' value='1'/>
				<div class="group">
					<label for="user" class="label">username</label> 
					<input id='username' name='username' type='text' class='input'>
				</div>
				<div class="group">
					<label for="pass" class="label">password</label>
					<input id='password' name='password' type='password' class='input' data-type='password'>
				</div>
				<div class="group">
					<label for="email" class="label">email</label>
					<input id='email'  name='email' type='text' class='input' required placeholder="@gmail.com">
				</div>
				<div class="group">
					<label for="gender" class="label">Gender</label>
				  	<label>female</label>	<input id='gender'  name='gender' type='radio'  class='input' value='female'>
					<label>Male</label>   <input id='gender'  name='gender' type='radio'  class='input' value='male'>
                                        
				</div>
                        
                                <div class="g-recaptcha" data-sitekey="6LfBez0UAAAAABp0PmqYF_bcW-Dk5c-1MO8NfYH7"></div>

				<div class="group">
					<input type="submit" class="button" value="Sign Up">
					</form>
				</div>
				<div class="hr"></div>
				
			</div>
		</div>
	</div>
</div>
  
  
</body>
</html>
