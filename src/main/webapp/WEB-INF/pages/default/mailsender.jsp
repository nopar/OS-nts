<%-- 
    Document   : mailsender
    Created on : 29-Apr-2014, 20:41:35
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
        <title>Zaslanie notifikácie - Mailsender</title>

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

            <h1>Zaslanie notifikácie</h1>
            <script>
                function off(){
                    document.getElementById('zoznam').style.visibility="hidden";
                }
                
                function on(){
                    document.getElementById('zoznam').style.visibility="visible";
                }
            
                    
                function nastav_blood(cislo){
                    
                }
                
            </script>

         <fieldset id="krv_radio" style="color: white">
             <legend style="color: #00B4FF">Krvná skupina - všeobecný stav zásob na Slovensku</legend>
             <button onclick="location.href = '${pageContext.request.contextPath}/logged/lekar/notify/1'">AB+</button>
             <button onclick="location.href = '${pageContext.request.contextPath}/logged/lekar/notify/2'">AB1</button>
             <button onclick="location.href = '${pageContext.request.contextPath}/logged/lekar/notify/3'">A+</button>
             <button onclick="location.href = '${pageContext.request.contextPath}/logged/lekar/notify/4'">A-</button>
             <button onclick="location.href = '${pageContext.request.contextPath}/logged/lekar/notify/5'">B+</button>
             <button onclick="location.href = '${pageContext.request.contextPath}/logged/lekar/notify/6'">B-</button>
             <button onclick="location.href = '${pageContext.request.contextPath}/logged/lekar/notify/7'">0+</button>             
             <button onclick="location.href = '${pageContext.request.contextPath}/logged/lekar/notify/8'">0-</button>

             <fieldset>
                 <button onclick="location.href = '${pageContext.request.contextPath}/logged/lekar/notify/9'">Bez ohľadu na krvnú skupiny a lokalitu</button>
             </fieldset>


         </fieldset></br></br>



         <fieldset id="kraj_radio" style="color: white">
             <legend style="color: #00B4FF">Lokalita</legend>
                 <button onclick="location.href = '${pageContext.request.contextPath}/logged/lekar/notify/10'">Len môj kraj</button>   

            
         </fieldset>
         </br></br>


            <p id="x"></p>                
            <br>
            <div id="mapholder"></div>
        </div>
    </body>
</html>
