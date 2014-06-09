<%-- 
    Document   : priprava na darovanie
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
        <title>Pred darovaním</title>

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
            <h3>Message : ${message}</h3>	
        </cor:if>

        <br />
        <center>   
            <h1>Príprava na darovanie krvi</h1>
        </center>
        <p> 
            Je nutné, aby ste boli pred odberom dostatočne hydratovaní. 24 hodín pred odberom vypite dostatok tekutín, minimálne 2 litre (vodu, minerálku, čaje, ovocné šťavy). Ráno pred odberom vypite 500 ml tekutín. Čierna káva je tiež povolená (okrem povinného pol litra čaju).
        </p>
        
        <p> 
            <br>Nehladujte! Na odber krvi nechoďte nalačno!</br>
            Večer pred odberom a taktiež tesne pred odberom nejedzte tučné jedlá (syry, maslo, smotanu, mäsové jedlá a výrobky, údeniny...). Vhodné je jesť ľahké sacharidové jedlá: ovocie, zeleninu, sucháre, netukové pečivo, džem, med ...
        </p>
        
        <p> 
            Pred odberom krvi nefajčite (minimálne 6 hodín), nepite alkohol (aspoň 12 – 14 hodín) a 24 hodín pred odberom sa nevystavujte priveľkej psychickej a telesnej námahe, vynechajte tréningy a návštevu posilňovne.
        </p>
        
        <p> 
            Alkohol, tučné jedlá, telesná námaha a niektoré lieky môžu prechodne spôsobiť zvýšenú aktivitu pečeňových enzýmov (ALT). Dbajte na to, aby ste boli oddýchnutí, čerství, po výdatnom spánku, pretože váš fyzický stav sa odzrkadlí na kvalite vašej krvi.
        </p>
        </div>
    </body>
</html>
