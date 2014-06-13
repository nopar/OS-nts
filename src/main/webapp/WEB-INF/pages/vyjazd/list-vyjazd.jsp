<%-- 
    Document   : list-vyjazd
    Created on : 29-Apr-2014, 20:41:35
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
        <title>Zoznam Výjazdov</title>

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
            th{
                color: #00B4FF;
            }
            
            td{
                 padding-left: 10px; 
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

            <h1>Zoznam Výjazdov</h1>
            
            <button onclick="location.href = '${pageContext.request.contextPath}/logged/lekar/vyjazd/add'">
                Pridaj výjazd
            </button></br></br>
            
            <cor:set var="li" value="${list}" /> 

            <cor:if  test="${!empty vyjazdy}">
                <table border="1px" cellpadding="0" cellspacing="0" >
                    <thead>
                        <tr>
                            <th width="15%">NÁZOV</th>
                            <th width="9%">DÁTUM</th>
                            <th width="15%">ADRESA</th>
                            <th width="8%">ZAČIATOK</th>
                            <th width="8%">KONIEC</th>
                            <th width="12%">POPIS</th>
                            <th width="15%">KRAJ</th>
                            <th width="10%">LEKÁR</th>
                            <th width="10%"></th>
                        </tr>
                    </thead>
                    <tbody align="center">
                        <cor:forEach items="${vyjazdy}" var="vyjazd" >
                            <cor:set var="akcia" value="${vyjazdy[i.index]}"/>
                            <tr>
                                <td style="padding-left: 10px;" align="left">${vyjazd.nazov}</td>
                                <td>${vyjazd.datum}</td>
                                <td align="left">${vyjazd.adresa}</td>
                                <td>${vyjazd.casZaciatku}</td>
                                <td>${vyjazd.casKonca}</td>
                                <td align="left">${vyjazd.blizsiPopis}</td>
                                <td  align="left">${vyjazd.idKraj.kraj}</td> 
                                <td align="left">${vyjazd.idLekar.priezvisko}</td>
                                <td>
                                    <div id="crud_icon_block">
                                        <input type="image"
                                               src="${pageContext.request.contextPath}/resources/img/edit.png"
                                               alt="Edituj"
                                               class="crud_icon" 
                                               onclick="location.href = '${pageContext.request.contextPath}/logged/lekar/vyjazd/edit/${vyjazd.idVyjazdovyOdber}'"/>

                                        <input type="image"
                                               src="${pageContext.request.contextPath}/resources/img/delete.png"
                                               alt="Zmaž"
                                               class="crud_icon"
                                               onclick="location.href ='${pageContext.request.contextPath}/logged/lekar/vyjazd/delete/${vyjazd.idVyjazdovyOdber}'"/>
                                    </div>
                                </td>
                            </tr>
                        </cor:forEach>  
                    </tbody>
                </table>
            </cor:if>




            <p id="x"></p>                
            <br>
            <div id="mapholder"></div>
        </div>
    </body>
</html>
