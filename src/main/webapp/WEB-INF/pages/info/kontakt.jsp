    <%-- 
    Document   : kontakt
    Created on : 28-Apr-2014, 16:19:00
    Author     : nox
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://www.springframework.org/tags" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="cor" %>

<!DOCTYPE html>
<html>
    <head>
         <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <title>Kontakt</title>

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
        
        <style>
            body > div > div > h2{
                color: #31708f;
            }
        </style>
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
            
        <cor:if  test="${!empty message}">                
            <h3 style="color: #00B4FF">Používateľ : <span style="color: #d50f11">${message}</span></h3>	
        </cor:if>

        <br />
        <center>   
            <h1>Kontakt</h1>
        </center>
        
        <div id="middlebox_right_subpage">
            <h1>Kontakt</h1>
            <p>&nbsp; NTS SR Bratislava, Ďumbierska 3/L, 831 01 Bratislava – riaditeľstvo</p>
            <p>&nbsp; E-mailová adresa konkrétneho pracovníka: priezviskopracovníka(zavináč)ntssr(bodka)sk</p>
            <table border="0" cellspacing="0" cellpadding="0">
                <tbody>
                    <tr valign="top">
                        <td width="25%" height="20"><strong>Meno</strong></td>
                        <td width="25%"><strong>Pozícia</strong></td>
                        <td width="15%"><strong>Telefón</strong></td>
                        <td width="15%"><strong>Fax</strong></td>
                    </tr>
                    <tr valign="top">
                        <td>Ing. Renáta Dundová</td>
                        <td>Riaditeľka NTS SR</td>
                        <td>+421 2 5910 3002</td>
                        <td>+421 2 5910 3020</td>
                    </tr>
                    <tr valign="top">
                        <td>MUDr. Mirko Peprný</td>
                        <td>Hlavný odborník MZ SR pre odbor transfúziológia</td>
                        <td>+421 48 3210 232</td>
                        <td>+421 48 3210 224</td>
                    </tr>
                    <tr valign="top">
                        <td>MUDr. Jana Rosochová</td>
                        <td>Hlavný odborný garant projektu „Dobudovanie infraštruktúry NTS SR"</td>
                        <td>+421 2 5910 3002</td>
                        <td>+421 2 5910 3020</td>
                    </tr>
                    <tr valign="top">
                        <td>MUDr. Daniela Cupaníková</td>
                        <td>Námestník pre LSP NTS SR a hlavný imunohematológ NTS SR</td>
                        <td>+421 2 5910 3057</td>
                        <td>+421 2 4364 2137</td>
                    </tr>
                    <tr>
                        <td>Ing. Mária Širicová</td>
                        <td>Hlavný manažér kvality NTS SR</td>
                        <td>+421 2 5910 3072</td>
                        <td>+421 2 4364 2137</td>
                    </tr>
                    <tr valign="top">
                        <td>Mgr. Martina Grožajová</td>
                        <td>Projektový manažér</td>
                        <td>+421 2 5910 3002</td>
                        <td>+421 2 5910 3020</td>
                    </tr>
                    <tr valign="top">
                        <td>Ing. Vojtech Augustín</td>
                        <td>Oddelenie informatiky</td>
                        <td>+421 2 5910 3029</td>
                        <td>+421 2 5910 3020</td>
                    </tr>
                    <tr valign="top">
                        <td>JUDr. Stanislav Macek</td>
                        <td>Útvar kontroly a sťažností</td>
                        <td>+421 2 5910 3024</td>
                        <td>+421 2 5910 3020</td>
                    </tr>
                    <tr valign="top">
                        <td>JUDr. Kristína Hajrová</td>
                        <td>Oddelenie ľudských zdrojov</td>
                        <td>+421 2 5910 3004</td>
                        <td>+421 2 5910 3020</td>
                    </tr>
                    <tr valign="top">
                        <td>Ľubica Mandáková</td>
                        <td>Oddelenie ekonomiky a učtovníctva</td>
                        <td>+421 2 5910 3019</td>
                        <td>+421 2 5910 3020</td>
                    </tr>
                    <tr valign="top">
                        <td>Vladimír Lacika</td>
                        <td>Oddelenie&nbsp;dopravy<br></td>
                        <td>+421 2 5910 3008</td>
                        <td>+421 2 5910 3020</td>
                    </tr>
                    <tr valign="top">
                        <td>Jaroslav Božek</td>
                        <td>Oddelenie&nbsp;technického úseku</td>
                        <td>+421 2 5910 3028</td>
                        <td>+421 2 5910 3020</td>
                    </tr>
                </tbody>
            </table> <div class="clearline"></div>
        </div>


        <p id="x"></p><br>
        <div id="mapholder"></div>
        </div>
    </body>
</html>
