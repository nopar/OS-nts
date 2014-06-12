<%-- 
    Document   : reset_hesla
    Created on : 28-Apr-2014, 16:19:11
    Author     : nox
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://www.springframework.org/tags" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="cor" %>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@page session="true"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Reset Hesla</title>

        <link rel="shortcut icon" type="image/x-icon" href="<cor:url value='/resources/img/favicon.ico'/>" />
        <link href="${pageContext.request.contextPath}/resources/css/layout.css" rel="stylesheet" type="text/css"/>

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

        <script src="${pageContext.request.contextPath}/resources/js/geoLocation.js" type="text/javascript"></script> 

    </head>

    <body>
        <script src="http://maps.google.com/maps/api/js?sensor=false"></script>

        <cor:choose>
            <cor:when test="${not empty pageContext.request.userPrincipal}">
                <!--JE LOGNUTY-->
                <cor:choose>
                    <cor:when test="${pageContext.request.isUserInRole('ROLE_ADMIN')}">
                        <!--je-->
                        <jsp:include flush="true" page="/WEB-INF/pages/menu/menu_admin_logged.jsp"></jsp:include> 
                    </cor:when>
                    <cor:otherwise>
                    </cor:otherwise>
                </cor:choose>         

                <cor:choose>
                    <cor:when test="${pageContext.request.isUserInRole('ROLE_LEKAR')}">
                        <!--je-->
                        <jsp:include flush="true" page="/WEB-INF/pages/menu/menu_lekar_logged.jsp"></jsp:include> 
                    </cor:when>
                    <cor:otherwise>
                    </cor:otherwise>
                </cor:choose>


                <cor:choose>
                    <cor:when test="${pageContext.request.isUserInRole('ROLE_DARCA')}">
                        <!--je-->
                        <jsp:include flush="true" page="/WEB-INF/pages/menu/menu_darca_logged.jsp"></jsp:include> 
                    </cor:when>
                    <cor:otherwise>
                    </cor:otherwise>
                </cor:choose>

            </cor:when>
            <cor:otherwise>
                <!--ANNONYMOUS-->
                <jsp:include flush="true" page="/WEB-INF/pages/menu/menu_non_logged.jsp"></jsp:include> 
            </cor:otherwise>
        </cor:choose> 


        <div class="container">

            <h1>Reset Hesla</h1>

            <p>${message}</p>
            
            
    <script type="text/javascript">
        window.onload = function () {
            document.getElementById("password1").onchange = validatePassword;
            document.getElementById("password2").onchange = validatePassword;
        }

        function validatePassword(){
            var pass2=document.getElementById("password2").value;
            var pass1=document.getElementById("password1").value;
            if(pass1!=pass2)
                document.getElementById("password2").setCustomValidity("Heslá musia byť rovnaké!");
            else
                document.getElementById("password2").setCustomValidity('');  
            //empty string means no validation error
        }
    </script>


            
    <cor:if  test="${!empty user}">
            <form:form method="POST" commandName="user" action="${pageContext.request.contextPath}/logged/profil/passw_rst/${user.idUser}.html">
                <table>
                    <tbody>
                        <tr>
                            <td>ID_</td>
                            <td><form:input path="idUser" /></td>
                        </tr>

                        <tr>
                            <td>Stat:</td>
                            <td><form:input type="hidden" path="email" /></td>
                        </tr>
                        <tr>
                            <td>:</td>
                            <td><form:input path="nick" /></td>
                        </tr>
                        <tr>
                            <td>:</td>
                            <td><form:input path="password" id="password1" required="required"/></td>
                        </tr>
                        <tr>
                            <td>:</td>
                            <td><form:input path="meno" /></td>
                        </tr>
                        <tr>
                            <td>:</td>
                            <td><form:input path="priezvisko" /></td>
                        </tr>
                        <tr>
                            <td>:</td>
                            <td><form:input path="datumNarodenia" /></td>
                        </tr>
                        <tr>
                            <td>:</td>
                            <td><form:input path="telKontakt" /></td>
                        </tr>
                        <tr>
                            <td>:</td>
                            <td><form:input path="pohlavie" /></td>
                        </tr>
                        <tr>
                            <td>rst:</td>
                            <td><form:input path="resetPasswd" id="password2" required="required"/></td>
                        </tr>
                        
                        <tr>
                            <td><input type="submit" value="Uložiť" /></td>
                            <td></td>
                        </tr>
                    </tbody>
                </table>
            </form:form>
        </cor:if>



            




            <p id="x"></p>                
            <br>
            <div id="mapholder"></div>
        </div>
    </body>
</html>
