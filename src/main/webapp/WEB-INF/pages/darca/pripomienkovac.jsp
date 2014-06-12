<%-- 
    Document   : pripomienkovac
    Created on : 28-Apr-2014, 16:19:00
    Author     : nox
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://www.springframework.org/tags" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="cor" %>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@page session="true"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pripomienkovač</title>

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

            <h1>Pripomienkovač</h1>
            
            
            <cor:if  test="${!empty daysBetween}">
                <cor:if  test="${daysBetween <= 0}">
                    <span style="color: #00B4FF">Už dávno môžete darovať.</span>
                </cor:if>
                
                    <cor:if  test="${daysBetween > 0}">
                        <h2 style="color: #00B4FF">
                            Môžete darovať o:
                            <span style="color: red">
                                <cor:if  test="${daysBetween == 1}">${daysBetween} deň</cor:if>
                                <cor:if  test="${daysBetween > 1}">${daysBetween} dní</cor:if>
                                </span>
                                .
                        </cor:if>
                </h2>
                
                <h2 style="color: #00B4FF">Dátum ďalšieho možného odberu je:<span style="color: red"> ${datumd}. ${mesiac+1}. 
                    <cor:if  test="${den == 1}">v Pondelok</cor:if>
                    <cor:if  test="${den == 2}">v Utorok</cor:if>
                    <cor:if  test="${den == 3}">v Streda</cor:if>
                    <cor:if  test="${den == 4}">v Štvrtok</cor:if>
                    <cor:if  test="${den == 5}">v Piatok</cor:if>
                    <cor:if  test="${den == 6}">Sobota (takže o 2 dni v Pondelok)</cor:if>
                    <cor:if  test="${den == 0}">Nedeľa (takže o 1 den v Pondelok)</cor:if>
                    </span>.
                </h2>
            </cor:if>




            <p id="x"></p>                
            <br>
            <div id="mapholder"></div>
        </div>
    </body>
</html>
