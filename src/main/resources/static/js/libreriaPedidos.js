/* Desactivar todas las opciones del Menú */
var elemento = document.getElementsByClassName("opMenu");
for(var i=0; i < elemento.length; i++){
    elemento[i].className = "nav-link opMenu";
}

// Activar solo la opción de categoría
var opcion = document.getElementById("mPedidos");
opcion.className = "nav-link opMenu activado";

(function(){
    var listaBotonesEditar = document.querySelectorAll('.botonEditar')
    listaBotonesEditar.forEach(item => {
        item.addEventListener('click', e => {
            document.getElementById('id').value = item.dataset.id;
            console.log(document.getElementById('id').value)
            document.getElementById('txtNombre').value = item.dataset.nombre;
            document.getElementById('txtDescripcion').value = item.dataset.descripcion;
            new bootstrap.Modal(document.getElementById('editarModal')).show()
        });
    });
})();