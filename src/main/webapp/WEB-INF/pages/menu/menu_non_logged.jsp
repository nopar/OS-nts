<%-- 
    Document   : menu non logged
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
        <link href="${pageContext.request.contextPath}/resources/css/menu.css" rel="stylesheet" type="text/css"/>
        <script src="${pageContext.request.contextPath}/resources/js/geoLocation.js" type="text/javascript"></script> 
         <style>
            body > div > div > h2{
                color: #31708f;
            }
        </style>
        
    </head>
    <body>
        <script src="http://maps.google.com/maps/api/js?sensor=false"></script>
        
         <div class="container">
            
            <section>
                <div id="two">
                    <cor:url value="/j_spring_security_logout" var="logoutUrl" />
                    <form action="${logoutUrl}" method="post" id="logoutForm">
                        <input type="hidden" name="${_csrf.parameterName}"
                               value="${_csrf.token}" />
                    </form>
                    <script>
                            function formSubmit() {
                                    document.getElementById("logoutForm").submit();
                            }
                    </script>
                    
                    <cor:choose>
                        <cor:when test="${pageContext.request.userPrincipal.name == null}">
                            <input type="image"
                                   src="${pageContext.request.contextPath}/resources/img/login.png"
                                   alt="Login"
                                   class="log_icon"
                                   onclick="location.href ='${pageContext.request.contextPath}/login'"/>
                        </cor:when>
                        <cor:otherwise>
                            <p>Prihlásení: ${pageContext.request.userPrincipal.name}
                                <input type="image"
                                       src="${pageContext.request.contextPath}/resources/img/exit.png"
                                       alt="Logout"
                                       class="log_icon"
                                       href="<c:url value="/j_spring_security_logout" />"
                                       onclick="location.href ='javascript:formSubmit()'"/>

                            </p>
                        </cor:otherwise>
                    </cor:choose>
                            
                    
                
                    <%--<cor:if test="${pageContext.request.userPrincipal.name != null}">--%>
                        
                    <%--</cor:if>--%>
                    <cor:if test="${not empty error}">
                <div class="error">${error}</div>
            </cor:if>
            <cor:if test="${not empty msg}">
                <div class="msg">${msg}</div>
            </cor:if>
                    
            </div>
            
                 
            <div id="one">
            <ul id="nav">
                <li><a id="1"
                       href="${pageContext.request.contextPath}/">Home</a>
                </li>
                
                <li><a href="#">Informácie</a>
                    <ul class="subs">
                        <li><a href="${pageContext.request.contextPath}/info/priprava">Príprava na darovanie krvi</a></li>
                        <li><a href="${pageContext.request.contextPath}/info/pred-darovanim">Predtým ako darujete svoju krv</a></li>
                        <li><a href="${pageContext.request.contextPath}/info/proces">Proces darovania</a></li>
                        <li><a href="${pageContext.request.contextPath}/resources/files/dotaznik-darcu.pdf">Dotazník darcu</a></li>
                    </ul>
                </li>
                
                <li><a href="${pageContext.request.contextPath}/info/pravne-info">Právne Informácie</a></li>
                <li><a href="${pageContext.request.contextPath}/info/faq">FAQ</a></li>

                <li><a  onclick="posun(6)"
                        href="#">Nástroje</a>
                    <ul class="subs">
                        <li><a 
                               href="${pageContext.request.contextPath}/mapa">
                               Nájdi najbližšiu stanicu</a>
                        </li>
                    </ul>
                </li>
                <li><a href="${pageContext.request.contextPath}/info/kontakt">Kontakt</a></li>

                
                <cor:if test="${pageContext.request.userPrincipal.name != null}">
                    <li style="padding-left: 100px;">
                        <a  class="backbutton"
                        href="#">Prihlásení: ${pageContext.request.userPrincipal.name}
                        </a>
                   
                </li>
                </cor:if>
                
                <div id="lavalamp"></div>
            </ul>
            </div>
                <br/>
                <cor:if test="${pageContext.request.userPrincipal.name != null}">
                    <h3>: ${username}</h3>
                </cor:if>
            </section>
                    
                
        <cor:if  test="${!empty message}">                
            <h3>Message : ${message}</h3>	
        </cor:if>
            
           

            
           

            <p id="x"></p><br>
        <div id="mapholder"></div>
        </div>    
    </body>
</html>
