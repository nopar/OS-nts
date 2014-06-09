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
                    <button onclick="location.href='${pageContext.request.contextPath}/rest/poc/1'">
                        pocitadlo odberov
                    </button><br/>
                </p>

                        
                        
        <cor:choose>
            <cor:when test="${pageContext.request.isUserInRole('ROLE_ADMIN')}">
                <h1>admin 2</h1>
            </cor:when>
            <cor:otherwise>
                <h1>ne-admin 2</h1>
            </cor:otherwise>
        </cor:choose>         
                            
        <cor:choose>
            <cor:when test="${pageContext.request.isUserInRole('ROLE_LEKAR')}">
                <h1>lekar</h1>
            </cor:when>
            <cor:otherwise>
                <h1>ne-lekar</h1>
            </cor:otherwise>
        </cor:choose>
        

        <cor:choose>
            <cor:when test="${pageContext.request.isUserInRole('ROLE_DARCA')}">
                <h1>darca 2</h1>
            </cor:when>
            <cor:otherwise>
                <h1>ne-darca 2</h1>
            </cor:otherwise>
        </cor:choose>
                   


        <sec:authorize ifAnyGranted="ROLE_ADMIN">
             <h1>ano som admin__</h1>
        </sec:authorize>
        <sec:authorize ifNotGranted="ROLE_ADMIN">
            <h1>nie nie som admin__</h1>
        </sec:authorize>


        <sec:authorize ifAnyGranted="ROLE_LEKAR">
            <h1>ano som lekar__</h1>
        </sec:authorize>
        <sec:authorize ifNotGranted="ROLE_LEKAR">
            <h1>nie nie som lekar__</h1>
        </sec:authorize>

        <sec:authorize ifAnyGranted="ROLE_DARCA">
            <h1>ano som darca__</h1>
        </sec:authorize>
        <sec:authorize ifNotGranted="ROLE_DARCA">
            <h1>nie nie som darca__</h1>
        </sec:authorize>

            
            <sec:authorize access="hasRole('ROLE_ADMIN')">
                <p>si Admin</p>
            </sec:authorize>

            <sec:authorize access="hasRole('ROLE_LEKAR')">
                <p>si Lekar</p>
            </sec:authorize>
                
                <sec:authorize access="hasRole('ROLE_DARCA')">
                <p>si Darca</p>
            </sec:authorize>



                
    
                
                
            </center>

            <p id="x"></p>
                
        <br>
        <div id="mapholder"></div>
        </div>
    </body>
</html>