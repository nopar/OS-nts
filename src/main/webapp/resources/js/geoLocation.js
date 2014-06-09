/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


function getDistance(lat, lon, lat2, lon2) {

    var R = 6371; // m (change this constant to get miles)

    var dLat = (lat2 - lat) * Math.PI / 180;

    var dLon = (lon2 - lon) * Math.PI / 180;

    var a = Math.sin(dLat / 2) * Math.sin(dLat / 2) +
            Math.cos(lat * Math.PI / 180) * Math.cos(lat2 * Math.PI / 180) * Math.sin(dLon / 2) * Math.sin(dLon / 2);

    var c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

    var d = R * c;

    return Math.round(d);

}


function getLocation()




{

    if (navigator.geolocation)

    {

        navigator.geolocation.getCurrentPosition(showPosition, showError);

    }

    else {

        x.innerHTML = "Geolocation is not supported by this browser.";

    }



}



function showPosition(position)

{

    x.innerHTML = "Vaša aktuálna poloha je:<br>" +
            "Zemepisná šírka: " + position.coords.latitude +
            "<br>Zemepisná dĺžka: " + position.coords.longitude;



    lat = position.coords.latitude;

    lon = position.coords.longitude;

    latlon = new google.maps.LatLng(lat, lon);

    mapholder = document.getElementById('mapholder');

    mapholder.style.height = '650px';

    mapholder.style.width = '800px';



    var myOptions = {
        center: latlon, zoom: 13,
        mapTypeId: google.maps.MapTypeId.ROADMAP,
        mapTypeControl: false,
        navigationControlOptions: {style: google.maps.NavigationControlStyle.SMALL}

    };


    var map = new google.maps.Map(document.getElementById("mapholder"), myOptions);

    var pinImage = new google.maps.MarkerImage(
            "http://www.patres.php5.sk/nts/marker.png");

    var marker = new google.maps.Marker({position: latlon, icon: pinImage, map: map, title: "Tu sa nachadzate!", animation: google.maps.Animation.BOUNCE});



    if (window.XMLHttpRequest)

    {// code for IE7+, Firefox, Chrome, Opera, Safari

        xmlhttp = new XMLHttpRequest();

    }

    else

    {// code for IE6, IE5

        xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");

    }
//treba dat pozor nepojde z mazania alebo z editovania
    xmlhttp.open("GET", "resources/poi.xml", false);

    xmlhttp.send();

    xmlDoc = xmlhttp.responseXML;





    var xm = xmlDoc.getElementsByTagName("poi");
    var d = 0;

    for (i = 0; i < xm.length; i++)

    {

        lat2 = xm[i].getElementsByTagName("latitude")[0].childNodes[0].nodeValue;

        lon2 = xm[i].getElementsByTagName("longitude")[0].childNodes[0].nodeValue;

        if (getDistance(lat, lon, lat2, lon2) < 50) {

            d++;

            var latlon2 = new google.maps.LatLng(xm[i].getElementsByTagName("latitude")[0].childNodes[0].nodeValue,
                    xm[i].getElementsByTagName("longitude")[0].childNodes[0].nodeValue);



            var marker2 = new google.maps.Marker({position: latlon2, map: map, title: xm[i].getElementsByTagName("poiTitle")[0].childNodes[0].nodeValue + "\n" + getDistance(lat, lon, lat2, lon2) + " km" + "\n" + xm[i].getElementsByTagName("poiDescription")[0].childNodes[0].nodeValue});

        }
        if (d == 20)
            break;

    }

}





function showError(error)

{

    switch (error.code)

    {

        case error.PERMISSION_DENIED:

            x.innerHTML = "User denied the request for Geolocation."

            break;

        case error.POSITION_UNAVAILABLE:

            x.innerHTML = "Location information is unavailable."

            break;

        case error.TIMEOUT:

            x.innerHTML = "The request to get user location timed out."

            break;

        case error.UNKNOWN_ERROR:

            x.innerHTML = "An unknown error occurred."

            break;

    }

}



