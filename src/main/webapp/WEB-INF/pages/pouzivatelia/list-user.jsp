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
        <title>Zoznam Userov</title>

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
                //padding-left: 10px;  
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

            <h1>Zoznam Používateľov</h1>
            
            <cor:if  test="${!empty users}">
                <table border="1px" cellpadding="0" cellspacing="0" >
                    <thead>
                        <tr>
                            <th width="2%">ID</th>
                            <th width="15%">MAIL</th>
                            <th width="8%">NICK</th>                            
                            <th width="5%">PASS</th>
                            <th width="10%">MENO</th>
                            <th width="10%">PRIEZVISKO</th>
                            <th width="10%">DAT. NAR.</th>
                            <th width="10%">MOBIL</th>
                            <th width="5%">SEX</th>
                            <th width="5%">RST</th>
                            <th width="3%">SETT.</th>
                            <th width="5%">KRV</th>
                            <th width="10%">MESTO</th>
                        </tr>
                    </thead>
                    <tbody align="center">
                        <cor:forEach var="user" items="${users}">
                            <tr>
                                <td>
                                    ${user.idUser}
                                </td>
                                
                                <td style="padding-left: 10px;" align="left">
                                    ${user.email}
                                </td>
                                
                                <td>
                                    ${user.nick}
                                </td>
                                
                                <td>
                                    ${user.password}
                                </td>
                                
                                <td>
                                    ${user.meno}
                                </td>
                                
                                <td>
                                    ${user.priezvisko}
                                </td>
                                
                                <td>
                                    ${user.datumNarodenia}
                                </td>
                                
                                <td>
                                    ${user.telKontakt}
                                </td>
                                
                                <td>
                                    ${user.pohlavie}
                                </td>
                                
                                <td>
                                    ${user.resetPasswd}
                                </td>
                                
                                <td>
                                    ${user.idNastavenie.idNastavenie}
                                </td>
                                <td>
                                    ${user.idKrvnaSkupina.typKrvi}
                                </td>
                                
                                <td>
                                    ${user.idAdresa.idMesto.mesto}
                                </td>
                                
                                
                                <td>
                                    <div id="crud_icon_block">
                                        <input type="image"
                                               src="${pageContext.request.contextPath}/resources/img/edit.png"
                                               alt="Edituj skupinu"
                                               class="crud_icon"
                                               onclick="location.href = '${pageContext.request.contextPath}/logged/lekar/user/edit/${skupina.idGroup}.html'">


                                            <input type="image"
                                                   src="${pageContext.request.contextPath}/resources/img/delete.png"
                                                   alt="Zmaž skupinu"
                                                   class="crud_icon"
                                                   onclick="location.href ='${pageContext.request.contextPath}/logged/lekar/user/delete/${skupina.idGroup}.html'">
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
