<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://www.springframework.org/tags" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="cor" %>
<%@page session="true"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" 
    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html lang="sk"
      xmlns="http://www.w3.org/1999/xhtml"
      xmlns:ui="http://java.sun.com/jsf/facelets"
      xmlns:h="http://java.sun.com/jsf/html">

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <title>NTS - Bakalarka</title>

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
            .error {
                padding: 15px;
                margin-bottom: 20px;
                border: 1px solid transparent;
                border-radius: 4px;
                color: #a94442;
                background-color: #f2dede;
                border-color: #ebccd1;
            }

            .msg {
                padding: 15px;
                margin-bottom: 20px;
                border: 1px solid transparent;
                border-radius: 4px;
                color: #31708f;
                background-color: #d9edf7;
                border-color: #bce8f1;
            }

            #login-box {
                width: 300px;
                padding: 20px;
                margin: 100px auto;
                background: #fff;
                -webkit-border-radius: 2px;
                -moz-border-radius: 2px;
                border: 1px solid #000;

                background-image: url('resources/img/bg_shadow.png'), url('resources/img/bg_pattern.png');
                background-repeat: repeat-x, repeat;
                background-position: top center, top center;
            }
            
            span{
                color: #00B4FF;
            }


        </style>
    </head>

    <body onload='document.loginForm.username.focus();'>
        <script src="http://maps.google.com/maps/api/js?sensor=false"></script>

        <cor:choose>
            <cor:when test="${not empty pageContext.request.userPrincipal}">
                <!--NIEKTO JE LOGNUTY-->
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

            <center>

                <cor:choose>
                    <cor:when test="${pageContext.request.userPrincipal.name == null}">
                        <h1>Prosím prihláste sa.</h1>
                    </cor:when>
                    <cor:otherwise>
                        <h1></h1>
                    </cor:otherwise>
                </cor:choose>
                        

            <script>
    function show() { 
        if(document.getElementById('benefits').style.display=='none') { 
            document.getElementById('benefits').style.display='block'; 
             document.getElementById('toto').style.display='none'; 
        } 
        return false;
    } 
    function hide() { 
        if(document.getElementById('benefits').style.display=='block') { 
            document.getElementById('benefits').style.display='none'; 
            document.getElementById('toto').style.display='block'; 
        } 
        return false;
    }  
            </script>
                       
        <div id="opener"><a href="#1" id="toto" name="1" onclick="return show();">
                <button onclick="">
                    Zobraziť ukážku JSON výstupov pre Android aplikáciu
                </button>
            </a></div> 
        <div id="benefits" style="display:none;">
            <div id="upbutton"><a onclick="return hide();">
                    <button onclick="">
                        Skryť ukážku
                    </button>
                </a></div> 
            <p>
                    <table border="1px" cellpadding="0" cellspacing="0" >
                        <thead>
                            <tr>
                                REST EXAMPLE
                            </tr>
                        </thead>
                        <tbody align="left">                
                            <tr>
                                <td></td>
                                <td>
                                    <button style="width: 100%" onclick="location.href = '${pageContext.request.contextPath}/rest/getStaty'">
                                        JSON- zoznam statov
                                    </button>
                                </td>
                            </tr>

                            <tr>
                                <td>za poslednou lomkou sa pre test moze zmenit nick napr. na: <br/>nopar / darca / lekar / sestra</td>
                                <td>
                                    <button style="width: 100%" onclick="location.href = '${pageContext.request.contextPath}/rest/poc/nopar'">
                                        JSON - pocitadlo odberov usera
                                    </button>
                                </td>
                            </tr>

                            <tr>
                                <td>Tu tiez tie nicky</td>
                                <td>
                                    <button style="width: 100%" onclick="location.href = '${pageContext.request.contextPath}/rest/getMojeOdbery/nopar'">
                                        JSON historia mojych odberov
                                    </button>
                                </td>
                            </tr>

                            <tr>
                                <td></td>
                                <td>
                                    <button style="width: 100%" onclick="location.href = '${pageContext.request.contextPath}/rest/kalendar'">
                                        JSON Kalendar akcii od dnes++
                                    </button>
                                </td>
                            </tr>
                                        
                            <tr>
                                <td>Tu tiez tie nicky</td>
                                <td>
                                    <button style="width: 100%" onclick="location.href = '${pageContext.request.contextPath}/rest/nastavenie/darca'">
                                        JSON Moje nastavenie
                                    </button>
                                </td>
                            </tr>
                        </tbody>
                    </table>
                </p>
            
        </div> 
                                
                
            </center>






            <p id="x"></p> 
            <div id="mapholder"></div>

        </div>
    </body>
</html>