<%-- 
    Document   : AddAdmin
    Created on : Dec 18, 2017, 5:16:09 PM
    Author     : norhan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
         <meta charset="UTF-8">
  <title> Add admin</title>
  
  
  <link rel='stylesheet prefetch' href='https://fonts.googleapis.com/css?family=Open+Sans:600'>

      <link rel="stylesheet" href="style2.css">
   
    </head>
    <body>
      <div class="sign-up-htm">

			<form id='signup' action='AddAdminOrUser' method='post' >
                            <% HttpSession Session = request.getSession(true) ;
                            Session.setAttribute("type","admin");
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
					<input type="submit" class="button" value="Add Admin">
					</form>
				</div>
				<div class="hr"></div>
				
			</div>
    </body>
</html>
