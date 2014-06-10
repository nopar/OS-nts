<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://www.springframework.org/tags" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="cor" %>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@page session="true"%>
<!DOCTYPE html>
<!--<global-method-security pre-post-annotations="enabled" />-->

<html lang="sk"
      xmlns="http://www.w3.org/1999/xhtml"
      xmlns:ui="http://java.sun.com/jsf/facelets"
      xmlns:h="http://java.sun.com/jsf/html">

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <title>NTS - Bakalarka</title>

        <link rel="icon" href="${pageContext.request.contextPath}/resources/favicon.ico"/>
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
                            
                
        
            <h1>Home page</h1>

            <center>
                <p>
                    <button onclick="location.href='${pageContext.request.contextPath}/rest/getStaty'">
                        JSON- zoznam statov
                    </button><br/>
                    
                    <span>za poslednou lomkou sa pre test moze zmenit nick napr. na: </span><br/>
                    <span>nopar / darca / lekar / sestra</span><br/>
                    <button onclick="location.href='${pageContext.request.contextPath}/rest/poc/nopar'">
                        JSON - pocitadlo odberov usera
                    </button><br/><br/>
                    
                    <span>Tu tiez tie nicky</span><br/>
                    <button onclick="location.href='${pageContext.request.contextPath}/rest/getMojeOdbery/nopar'">
                        JSON historia mojych odberov
                    </button><br/>
                </p>



        <sec:authorize ifAnyGranted="ROLE_ADMIN">
            <h1>Áno som ROLA: ADMIN</h1>
        </sec:authorize>
        <sec:authorize ifNotGranted="ROLE_ADMIN">
            <h2>Nie nie som ROLA: ADMIN</h2>
        </sec:authorize>

        <sec:authorize ifAnyGranted="ROLE_LEKAR">
            <h1>Áno som ROLA: LEKAR</h1>
        </sec:authorize>
        <sec:authorize ifNotGranted="ROLE_LEKAR">
            <h2>Nie nie som ROLA: LEKAR</h2>
        </sec:authorize>

        <sec:authorize ifAnyGranted="ROLE_DARCA">
            <h1>Áno som ROLA: DARCA</h1>
        </sec:authorize>
        <sec:authorize ifNotGranted="ROLE_DARCA">
            <h2>Nie nie som ROLA: DARCA</h2>
        </sec:authorize>

                
                
            </center>

            <p id="x"></p>
                
        <br>
        <div id="mapholder"></div>
        </div>
    </body>
</html>