<%-- 
    Document   : preco darovat
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
        <title>Prečo darovať</title>

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
            <h3 style="color: #00B4FF">Používateľ : <span style="color: #d50f11">${message}</span></h3>	
        </cor:if>

            <br />
            <center>   
                <h1>Prečo darovať krv</h1>
            </center>

            <p>
                Potreba krvi je veľká. Približne 180 000 transfúznych jednotiek červených krviniek sa každoročne spotrebuje iba na Slovensku. Obete úrazov a nehôd, ľudia podstupujúci operácie, pacienti liečiaci sa na leukémiu, nádorové ochorenia, ochorenia krvných buniek, tí všetci potrebujú krv. Celosvetovo je za jeden rok pacientom podaných viac ako 26,5 milióna jednotiek krvných zložiek.
            </p>
            <p>Darovanie krvi je skutočným „darom života“, ktorý zdravý jedinec môže poskytnúť ľuďom chorým a po úrazoch. Je to veľmi prospešný, bezpečný a jednoduchý humánny krok.
            </p>
            <p> Interval darovania je pre mužov každé 3 mesiace a pre ženy každé 4 mesiace. Celý proces darovania krvi trvá, od registrácie až po odchod domov, približne hodinu a samotný odber len 5 – 15 minút, počas ktorých daruje darca 450 ml krvi. Krv je ďalej spracovaná (rozdeľovaná) na jednotlivé zložky, ktoré môžu pomôcť zachrániť ľudské životy. Červené krvinky, prenášače kyslíka, zachraňujú životy pacientov počas operácií a po úrazoch. Plazma, tekutá zložka krvi, je určená pre pacientov trpiacich poruchami zrážania krvi. Tretia zložka, krvné doštičky, zastavuje krvácanie pri rezných poraneniach a pri otvorených krvácaniach. Často sa podávajú pacientom liečiacich sa na nádorové ochorenia a aj pacientom po transplantácii.
            </p>
        </div>
    </body>
</html>
