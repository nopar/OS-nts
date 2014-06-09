<%-- 
    Document   : pred tym
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
        <title>Predtým ako darujete svoju krv</title>

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
                <h1>Predtým ako darujete svoju krv</h1>
            </center>
            <p> 
                Na webovej stránke si nájdite pre vás najbližšie transfúziologické pracovisko a zistite si, v akom čase je možné absolvovať odber.
            </p>

            <p> 
                <br>Pokiaľ ste sa rozhodli darovať krv, musíte spĺňať všeobecné základné kritériá:</br>
            <ul>
                <li>Musíte mať vek od 18 do 60 rokov. Pokiaľ ste pravidelným darcom, môžete darovať krv až do svojich 65 rokov. Frekvencia darovania je pre mužov 3 mesiace a pre ženy 4 mesiace od posledného odberu.</li>
                <li>Musíte mať telesnú hmotnosť minimálne 50 kg.</li>
                <li>Nesmiete byť nosičom vírusu HIV (mať AIDS)</li>
                <li>Nemôžete byť po prekonaní hepatitídy (žltačky) typu B a C.</li>
                <li>Nemôžete trpieť na iné závažné a chronické ochorenia.</li>
            </ul>
        </p>
        <p> 
            <br>Krv nedarujte v prípade (resp. trvalo nemôžete darovať krv):</br>
        <ul> 
            <li>Užívania drog vnútrožilovo či vnútrosvalovo teraz alebo v minulosti.</li>
            <li>Poskytovaní alebo prijímaní platených sexuálnych služieb.</li>
            <li>Pohlavného styku medzi mužmi.</li>
            <li>Promiskuitného spôsobu života s častým striedaním sexuálnych partnerov.</li>
            <li>Užívania anabolických steroidov, ktoré nie sú predpísané lekárom.</li>
            <li>Liečby poruchy zrážania krvi krvnými prípravkami.</li>
        </ul>
        </p>

        <br>Darovanie krvi nie je spôsobom otestovania sa na nosičstvo krvou prenosných chorôb! Pamätajte na to ešte predtým, než sa rozhodnete stať sa darcom krvi.</br>

        <p> 
            Pre ženy nie je vhodné ísť darovať krv počas menštruácie, resp. tesne pred ňou alebo po nej.
        </p>

        <p>
            V prípade, že si nie ste istí, či ste vhodným kandidátom na darovanie krvi, vopred zavolajte do transfúziologického pracoviska a vašu situáciu skonzultujte s lekárom.
        </p>        
        </div>
    </body>
</html>
