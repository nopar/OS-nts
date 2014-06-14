    <%-- 
    Document   : proces darovania
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
        <title>Proces darovania</title>

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
            
        <cor:if  test="${!empty message}">                
            <h3 style="color: #00B4FF">Používateľ : <span style="color: #d50f11">${message}</span></h3>	
        </cor:if>

        <br />
        <center>   
            <h1>Príchod do transfúziologického zariadenia a registrácia</h1>
        </center>
        <p> 
            Preukážete sa občianskym preukazom a vašou kartou poistenca a pokiaľ nie ste prvodarca, aj vašou kartou darcu krvi.
        </p>
        
        <p> 
            Vyplníte dotazník pre darcu krvi, plazmy a krvných buniek, ktorý zahŕňa vaše osobné identifikačné údaje a rôzne dôležité otázky týkajúce vášho zdravia, životného štýlu, rizikových faktorov a vami prekonaných chorôb. Vyplňte ho pravdivo, bez akéhokoľvek zatajenia závažných skutočností, ktoré by mohli spôsobiť ujmu na zdraví darcu (vyvolanie epileptických kŕčov pri epilepsii, zlyhanie srdca pri závažných srdcových ochoreniach, atď.), ale aj prípadného príjemcu transfúzneho lieku, ktorého organizmus je väčšinou oslabený.
        </p>
        
        <p> 
            Celý dotazník sa nachádza na webovej stránke, kde si ho môžete vopred pozrieť. Vypĺňa sa pri každej jednej návšteve transfúziologického zariadenia.
        </p>


        <p id="x"></p><br>
        <div id="mapholder"></div>
        </div>
    </body>
</html>
