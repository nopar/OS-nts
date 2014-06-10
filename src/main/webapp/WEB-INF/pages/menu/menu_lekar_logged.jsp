    <%-- 
    Document   : menu lekar logged
    Created on : 28-Apr-2014, 16:19:00
    Author     : nox
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://www.springframework.org/tags" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="cor" %>
<%@page session="true"%>
<!DOCTYPE html>
<html>
    <head>
         <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <title>Proces darovania</title>

        <link rel="shortcut icon" type="image/x-icon" href="<cor:url value='/resources/img/favicon.ico'/>" />
        <link href="${pageContext.request.contextPath}/resources/css/layout.css" rel="stylesheet" type="text/css"/>
        <link href="${pageContext.request.contextPath}/resources/css/menu_lekar.css" rel="stylesheet" type="text/css"/>
        <script src="${pageContext.request.contextPath}/resources/js/geoLocation.js" type="text/javascript"></script> 
         <style>
            body > div > div > h2{
                color: #31708f;
            }
        </style>
        
    </head>
    <body>
       <div class="container">
            
            <section>
                <div id="two">
<!--                <input type="image"
                       src="${pageContext.request.contextPath}/resources/img/login.png"
                       alt="Login"
                       class="log_icon"
                       onclick="location.href ='${pageContext.request.contextPath}/login'"/>-->

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
                    
            

                    <cor:if test="${pageContext.request.userPrincipal.name != null}">
                        <p>Prihlásení: ${pageContext.request.userPrincipal.name}
                            <input type="image"
                                   src="${pageContext.request.contextPath}/resources/img/exit.png"
                                   alt="Logout"
                                   class="log_icon"
                                   href="<c:url value="/j_spring_security_logout" />"
                                   onclick="location.href ='javascript:formSubmit()'"/>
                            
                        </p>
                    </cor:if>
                            
              
            </div>
                 
            <div id="one">
            <ul id="nav">
                <li><a id="1"
                       href="${pageContext.request.contextPath}/logged/index.html">Home</a>
                </li>
                
                
                <li><a href="#">-!-Darca</a>
                    <ul class="subs">
                        <li><a href="#">Pridaj používatľa</a></li>
                        <li><a href="#">Zoznam používateľov</a></li>
                    </ul>
                </li>
                
                <li><a href="#">-!-Odberové miesto</a>
                    <ul class="subs">
                        <li><a href="#">Pridaj výjazd</a></li>
                        <li><a href="#">Zoznam výjazdov</a></li>
                    </ul>
                </li>
                  
                <li><a href="#">-!- Kalendár akcií</a>
                </li>
                
                <li><a href="#">Informácie</a>
                    <ul class="subs">
                        <li><a href="${pageContext.request.contextPath}/info/priprava">Príprava na darovanie krvi</a></li>
                        <li><a href="${pageContext.request.contextPath}/info/pred-darovanim">Predtým ako darujete svoju krv</a></li>
                        <li><a href="${pageContext.request.contextPath}/info/proces">Proces darovania</a></li>
                        <li><a href="${pageContext.request.contextPath}/info/pravne-info">Právne Informácie</a></li>                        
                        <li><a href="${pageContext.request.contextPath}/resources/files/dotaznik-darcu.pdf">Dotazník darcu</a></li>
                    </ul>
                </li>
                
                
                
                <li><a  onclick="posun(6)"
                        href="#">-!-Nástroje</a>
                    <ul class="subs">
                        <li><a href="${pageContext.request.contextPath}/mapa">Nájdi najbližšiu stanicu</a></li>
                        <li><a href="#">Poslať notifikáciu</a></li>
                    </ul>
                </li>
                
                <cor:if test="${pageContext.request.userPrincipal.name != null}">
                    <li style="float: right; radius: 5px">
                        <ul class="subs">
                            <li><a href="${pageContext.request.contextPath}/logged/profil">Svoj profil</a></li>
                            <li><a href="${pageContext.request.contextPath}/logged/profil/odber/historia">Históoria odberov</a></li>
                            <li><a href="${pageContext.request.contextPath}/logged/profil/odber/pocitadlo">Počítadlo odberov</a></li>
                            <li><a href="${pageContext.request.contextPath}/logged/profil/odber/najblizsie">Kedy môžem znova darovať</a></li>
                            <li><a href="${pageContext.request.contextPath}/logged/profil/passw_rst">Reset hesla</a></li>
                            <%--<cor:out value="${accountId}"/>--%>
                        </ul>
                        <a  class="backbutton"
                            href="#">-!-Prihlásení: ${pageContext.request.userPrincipal.name}</a>

                    </li>
                </cor:if>
                
                <div id="lavalamp"></div>                
              
            </ul>
            </div>
            </section>
                    
                
        <cor:if  test="${!empty message}">                
        <h3>Message : ${message}</h3>
        </cor:if>
             
            <p id="x"></p>
                
        <br>
        <div id="mapholder"></div>
        </div>
    </body>
</html>
