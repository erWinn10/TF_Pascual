/* Desactivar todas las opciones del Menú */
var elemento = document.getElementsByClassName("opMenu");
for(var i=0; i < elemento.length; i++){
    elemento[i].className = "nav-link opMenu";
}

// Activar solo la opción de categoría
var opcion = document.getElementById("mArticulo");
opcion.className = "nav-link opMenu activado";

