/*function caca()
{
	var e = document.getElementById("slcAsignatura");
  var asignatura = e.options[e.selectedIndex].value;
  var correo_alum = document.getElementById("txtCorreo").value;
  var docente =document.getElementById("slcDocente");
      if (typeof XMLHttpRequest != "undefined") {
        xmlHttp = new XMLHttpRequest();
    } else if (window.ActiveXObject) {
        xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
    }
    if (xmlHttp == null) {
        alert("Browser does not support XMLHTTP Request")
        return;
    }
    var url = "crearSolicitud.php";
    url += "?asig="+asignatura;
    xmlHttp.open("GET", url, true);
    xmlHttp.send(null);
}*/

    function caca(step)
    {
        var showPage;
        var e = document.getElementById("slcAsignatura");
        var asignatura = e.options[e.selectedIndex].value;
        var correo_alum = document.getElementById("txtCorreo").value;

        if (step==1)
        {
            showPage = 'cargarDocente.php?asig='+ asignatura+"_"+correo_alum;
            resultBox = 'destinationBox';
        }
        var xmlhttp;
        if (window.XMLHttpRequest)
        {// code for IE7+, Firefox, Chrome, Opera, Safari
            xmlhttp=new XMLHttpRequest();
        } else {// code for IE6, IE5
            xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
        }
            xmlhttp.onreadystatechange=function()
        {

        if (xmlhttp.readyState==4 && xmlhttp.status==200)
        {
            document.getElementById('slcDocente').innerHTML=xmlhttp.responseText;
        }
    }
        xmlhttp.open("GET",showPage,true);
        xmlhttp.send();
    }

    $(window).resize(function(){
    $(".sweet-alert").css("margin-top",-$(".sweet-alert").outerHeight()/2);
});

        function refrescar()
    {
        setTimeout(function(){
        window.location.reload(1);
        }, 15000);
    }