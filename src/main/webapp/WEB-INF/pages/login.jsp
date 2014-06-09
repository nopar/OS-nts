<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" 
    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    
<title>Login Page</title>

    <link rel="shortcut icon" type="image/x-icon" href="<c:url value='/resources/img/favicon.ico'/>" />
    <link href="${pageContext.request.contextPath}/resources/css/style.css" rel="stylesheet" type="text/css"/>
    
    <cor:choose>
            <cor:when test="${not empty pageContext.request.userPrincipal}">
                <!--JE LOGNUTY-->
                <cor:choose>
                    <cor:when test="${pageContext.request.isUserInRole('ROLE_ADMIN')}">
                        <!--je-->
                        <link href="${pageContext.request.contextPath}/resources/css/menu_admin.css" rel="stylesheet" type="text/css"/>
                    </cor:when>
                    <cor:otherwise>
                    </cor:otherwise>
                </cor:choose>         

                <cor:choose>
                    <cor:when test="${pageContext.request.isUserInRole('ROLE_LEKAR')}">
                        <!--je-->
                        <link href="${pageContext.request.contextPath}/resources/css/menu_lekar.css" rel="stylesheet" type="text/css"/>
                    </cor:when>
                    <cor:otherwise>
                    </cor:otherwise>
                </cor:choose>


                <cor:choose>
                    <cor:when test="${pageContext.request.isUserInRole('ROLE_DARCA')}">
                        <!--je-->
                        <link href="${pageContext.request.contextPath}/resources/css/menu_darca.css" rel="stylesheet" type="text/css"/>
                    </cor:when>
                    <cor:otherwise>
                    </cor:otherwise>
                </cor:choose>

            </cor:when>
            <cor:otherwise>
                <!--ANNONYMOUS-->
                <link href="${pageContext.request.contextPath}/resources/css/menu.css" rel="stylesheet" type="text/css"/>
            </cor:otherwise>
        </cor:choose>

<style>
.error {
	padding: 15px;
	margin-bottom: 20px;
	border: 1px solid transparent;
	border-radius: 4px;
	color: #a94442;
	background-color: #f2dede;
	border-color: #ebccd1;
}

.msg {
	padding: 15px;
	margin-bottom: 20px;
	border: 1px solid transparent;
	border-radius: 4px;
	color: #31708f;
	background-color: #d9edf7;
	border-color: #bce8f1;
}

#login-box {
	width: 300px;
	padding: 20px;
	margin: 100px auto;
	background: #fff;
	-webkit-border-radius: 2px;
	-moz-border-radius: 2px;
	border: 1px solid #000;
        
        background-image: url('resources/img/bg_shadow.png'), url('resources/img/bg_pattern.png');
    background-repeat: repeat-x, repeat;
    background-position: top center, top center;
}

html, body {
    background-image: url('resources/img/bg_shadow.png'), url('resources/img/bg_pattern.png');
    background-repeat: repeat-x, repeat;
    background-position: top center, top center;
}
input[type="submit"]{
    color: red;
}
</style>
</head>
<body onload='document.loginForm.username.focus();'>

<center>
	<h1>Národná Transfúzna Stanica <BR /> (Databázová Authentifikácia)</h1>
</center>
	<div id="login-box">

		<center><h2>Prihlasovací formulár</h2></center>

		<c:if test="${not empty error}">
			<div class="error">${error}</div>
		</c:if>
		<c:if test="${not empty msg}">
			<div class="msg">${msg}</div>
		</c:if>

		<form name='loginForm'
			action="<c:url value='/j_spring_security_check' />" method='POST'>

			<table>
				<tr>
					<td>Login:</td>
                                        <td><input type='text' 
                                                   name='username' 
                                                   value="nopar"
                                                   placeholder="nick alebo email"></td>
				</tr>
				<tr>
					<td>Heslo:</td>
                                        <td><input type='password' 
                                                   name='password' 
                                                   value=""
                                                   placeholder="zadaj heslo"/></td>
				</tr>
				<tr>
					<td colspan='2'><input name="submit" type="submit"
						value="Prihlásiť" />
                                        </td>
                                                                               
				</tr>    
			</table>

			<input type="hidden" name="${_csrf.parameterName}"
				value="${_csrf.token}" />
		</form>                                  


<div>
    <center>
        <a id="1"href="${pageContext.request.contextPath}/">
        <button>Domov</button></a>


    <INPUT Type="button" VALUE="Naspäť" onClick="history.go(-1);
    return true;"></INPUT>      
    </center>
</div>
</body>
</html>