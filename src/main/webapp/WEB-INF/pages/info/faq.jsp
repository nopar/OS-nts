    <%-- 
    Document   : faq
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
        <title>Najčastejšie otázky</title>

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
            body > div > div > h2{
                color: #31708f;
            }
        </style>
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
            <h1>Najčastejšie otázky</h1>
        </center>
       

        <div class="questions_list_box">
            <h2>Ako často môžem darovať?</h2>
            <div class="clearline"></div>
            <div class="questions_list_box_date">Otázka bola zodpovedaná  dňa 22.02.2012</div>
            <p>Frekvencia darovania je pre mužov 3 mesiace a pre ženy 4 mesiace od posledného odberu.</p>
            <div class="clearline"></div> 	
        </div>	
        <div class="questions_list_box">
            <h2>Čo môžem robiť, pokiaľ nie som vhodným darcom?</h2>
            <div class="clearline"></div>
            <div class="questions_list_box_date">Otázka bola zodpovedaná  dňa 11.11.2009</div>
            <p>V prípade nevhodného darcu môže ísť o stav dočasný (z rôznych príčin) a po uplynutí doby potrebnej na vyradenie môžete byť znova zaradený medzi darcov. Odberové strediská stále potrebujú schopných dobrovoľníkov podporujúcich odbery krvi, alebo organizujúcich odbery v teréne, mimo odberového strediska.</p>
            <div class="clearline"></div> 	
        </div>	
        <div class="questions_list_box">
            <h2>Ako sa budem cítiť po odbere?</h2>
            <div class="clearline"></div>
            <div class="questions_list_box_date">Otázka bola zodpovedaná  dňa 11.11.2009</div>
            <p>Väčšina ľudí sa po odbere cíti dobre. Ak by ste predsa len pocítili akýkoľvek príznak diskomfortu, ihneď upovedomte člena personálu. Vyvarujte sa zdvíhania ťažkých predmetov, a akýmkoľvek namáhavým cvičeniam budúcich 24 hodín po odbere. A potom sa môžete znova vrátiť k vašim bežným aktivitám, tak skoro a na tak dlho, ako sa budete cítiť dobre.</p>
            <div class="clearline"></div> 	
        </div>	
        <div class="questions_list_box">
            <h2>Ako môžem zistiť hladinu môjho železa?</h2>
            <div class="clearline"></div>
            <div class="questions_list_box_date">Otázka bola zodpovedaná  dňa 11.11.2009</div>
            <p>Darcovia môžu byť vylúčení z darcovstva pre nízku hladinu hemoglobínu (červeného krvného farbiva obsahujúceho železo). Toto opatrenie sa robí pre ochranu darcu a zaisťuje, že aj po darovaní krvi bude mať darca hladinu hemoglobínu v norme, t.j. bezpečnú pre dospelého jedinca. Darca môže zvýšiť svoju hladinu železa konzumáciou červeného mäsa, tmavozelenej zeleniny, rias, orechov, semien, obilnín alebo užívaním výživových doplnkov obsahujúcich železo. Vyšetriť vám ho môže váš lekár.</p>
            <div class="clearline"></div> 	
        </div>	
        <div class="questions_list_box">
            <h2>Môžem darovať krv ak mám anémiu?</h2>
            <div class="clearline"></div>
            <div class="questions_list_box_date">Otázka bola zodpovedaná  dňa 11.11.2009</div>
            <p>Pokiaľ trpíte anémiou, krv darovať nesmiete. Predtým ako darujete krv urobia vám test na hemoglobín. Zisťuje sa, či je jeho hladina akceptovateľná pre uskutočnenie odberu.</p>
            <div class="clearline"></div> 	
        </div>	
        <div class="questions_list_box">
            <h2>Čo ak užijem aspirín, alebo iný liek predpísaný mojím lekárom?</h2>
            <div class="clearline"></div>
            <div class="questions_list_box_date">Otázka bola zodpovedaná  dňa 11.11.2009</div>
            <p>Aspirín a ibuprofen nevadia pri darovaní celej krvi. Aferéza krvných doštičiek zakazuje užitie aspirínu a aspirínových prípravkov 5 dní pred darovaním. Veľa iných liekov je akceptovateľných. Odporúča sa vopred zavolať do odberového centra a informovať sa u lekára na lieky, ktoré užívate.</p>
            <div class="clearline"></div> 	
        </div>	
        <div class="questions_list_box">
            <h2>Môžem darovať krv ak mám vysoký krvný tlak?</h2>
            <div class="clearline"></div>
            <div class="questions_list_box_date">Otázka bola zodpovedaná  dňa 11.11.2009</div>
            <p>Áno, aj v prípade, že beriete lieky. Pokiaľ ste sledovaný lekárom a Váš tlak je pod kontrolou a stabilizovaný, darovať krv môžete. Sekundárne komplikácie hypertenzie (napr. poškodenie obličiek) sú dôvodom na vyradenie.</p>
            <div class="clearline"></div> 	
        </div>	
        <div class="questions_list_box">
            <h2>Ak mám nádchu alebo chrípku, môžem darovať krv?</h2>
            <div class="clearline"></div>
            <div class="questions_list_box_date">Otázka bola zodpovedaná  dňa 11.11.2009</div>
            <p>Darovať krv môžu darcovia bez akýchkoľvek symptómov, so všeobecne dobrým zdravotným stavom, takí, ktorí sa cítia dobre. Ak má darca nádchu alebo chrípku, darovanie krvi je možné až dva týždne od úplného vyliečenia a dva týždne po ukončení antibiotickej liečby.</p>
            <div class="clearline"></div> 	
        </div>	
        <div class="questions_list_box">
            <h2>Ak som bol očkovaný proti chrípke, môžem darovať krv?</h2>
            <div class="clearline"></div>
            <div class="questions_list_box_date">Otázka bola zodpovedaná  dňa 11.11.2009</div>
            <p>Áno, môžete. To isté platí po preventívnom očkovaní, napr. proti tetanu, hepatitíde typu B a besnote.</p>
            <div class="clearline"></div> 	
        </div>	
        <div class="questions_list_box last">
            <h2>Ak som bol raz vyradený, znamená to, že som už nežiaduci na darovanie krvi?</h2>
            <div class="clearline"></div>
            <div class="questions_list_box_date">Otázka bola zodpovedaná  dňa 11.11.2009</div>
            <p>Ak má vaše vyradenie trvalý charakter, budete o tom informovaní. Inak závisí doba vášho vyradenia od dôvodu vyradenia. Pred každým jedným odberom budete podrobení malému fyzickému a medicínskemu vyšetreniu, a tak sa zistí, či ste vhodným kandidátom na darovanie krvi práve v tento deň.</p>
            <div class="clearline"></div> 	
        </div>	
         <p id="x"></p><br>
        <div id="mapholder"></div>
        </div>
    </body>
</html>
