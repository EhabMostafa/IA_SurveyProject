<%-- 
    Document   : ChangePass
    Created on : Dec 18, 2017, 1:20:35 PM
    Author     : norhan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
       
         <meta charset="UTF-8">
       <title> Login Form</title>
  
  
  <link rel='stylesheet prefetch' >

      <link rel="stylesheet" href="style.css">

      
    </head>
    <body>
        <div class="login-wrap">
      <div class="login-form">
       <div class="sign-in-htm">
            <div class="login-html">
        <form id='login' action='ChangePassWord' method='post' accept-charset='UTF-8'>
				<div class="group">
					<label for="OldPassWord" class="label">Old Password</label>
					<input id="OldPassWord" name ='OldPassWord' type="password" class="input">
				</div>
				<div class="group">
					<label for="NewPassWord" class="label">New Password</label>
					<input id="NewPassWord" type="password" class="input" data-type="password" name='NewPassWord'>
				</div>
				<div class="group">
					<input type="submit" class="button" value="Change">
				</div>
				<div class="hr"></div>
				<div class="foot-lnk">
				</div>
				</form>
            </div>
        </div>
         </div>
             </div>
    </body>
</html>
