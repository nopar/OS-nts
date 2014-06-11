<%-- 
    Document   : profil
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
        <title>Môj profil</title>

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

            <h1>Môj profil</h1>
            <cor:set var="count" value="${0}"/>
            
            <script>
                function zmena(cislo){
                    
                    if(cislo == 1) {
                        if( document.getElementById("odber").checked ==  "checked"){
                            document.getElementById("odber_txt").innerHTML = "+";
                        }else{
                             document.getElementById("odber_txt").innerHTML = "-";
                        }
                    }
                    
                    if(cislo == 2) {document.getElementById("vyjazd").src = "bg/girl.png";}
                    if(cislo == 3) {document.getElementById("urgent").src = "bg/boy.png";}
                    if(cislo == 4) {document.getElementById("kraj").src = "bg/girl.png";}
                    
                    if(document.getElementById("ober_butt").checked){
                      element.setAttribute('name', 'zapnuté');
                    }else{
                        element.setAttribute('name', 'vypnuté');
                    }
                }
                
                
            </script>
            
            
            
            <cor:if  test="${!empty list}">
                <table border="1px" cellpadding="0" cellspacing="0" >
                    <thead>
                        <tr>
                            <th width="50%">NASTAVENIE</th>
                            <th width="20%">ZAPNUTE / VYPNUTE</th>
                          
                        </tr>
                    </thead>
                    <tbody align="center">
                       
                                <tr>
                                    <td style="padding-left: 15px;" align="left">Kedy môžem darovať:</td>
                                    <td>
                                        <input type="checkbox" name="odber" value="${odber}" 
                                               <cor:if  test="${odber == 'zapnuté'}">checked="checked"</cor:if>
                                               <cor:if  test="${odber == 'vypnuté'}"></cor:if>
                                               >
                                        <p id="odber_txt"></p>
                                    </td>
                                </tr>

                                
                                <tr>
                                    <td style="padding-left: 15px;" align="left">Výjazdové odbery:</td>
                                    <td>
                                    <input type="checkbox" name="vyjazd" value="${vyjazd}" 
                                           <cor:if  test="${vyjazd == 'zapnuté'}">checked="checked"</cor:if>
                                               <cor:if  test="${vyjazd == 'vypnuté'}"></cor:if>
                                               >
                                    </td>
                                </tr>

                                
                                <tr>
                                    <td style="padding-left: 15px;" align="left">Urgentné prípady:</td>
                                    <td>
                                        <input type="checkbox" name="urgent" value="${urgent}" 
                                               <cor:if  test="${urgent == 'zapnuté'}">checked="checked"</cor:if>
                                               <cor:if  test="${urgent == 'vypnuté'}"></cor:if>
                                               >
                                    </td>
                                    
                                </tr>

                                
                                <tr>
                                    <td style="padding-left: 15px;" align="left">Len z môjho kraja:</td>
                                    <td>
                                        <input type="checkbox" name="kraj" value="${kraj}" 
                                               <cor:if  test="${kraj == 'zapnuté'}">checked="checked"</cor:if>
                                               <cor:if  test="${kraj == 'vypnuté'}"></cor:if>
                                               >
                                    
                                    </td>
                                    
                                </tr>
                            
                    </tbody>
                </table>
            </cor:if>
            
            




            <p id="x"></p>                
            <br>
            <div id="mapholder"></div>
        </div>
    </body>
</html>
