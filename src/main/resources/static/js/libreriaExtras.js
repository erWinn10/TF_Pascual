(function(){
    var listaBotonesEditar = document.querySelectorAll('.btnComprar')
    listaBotonesEditar.forEach(item => {
        item.addEventListener('click', e => {
            document.getElementById('id').value = item.dataset.id;
            document.getElementById('articuloId').value = item.dataset.id;

            console.log(document.getElementById('id').value)
            var nombre = item.dataset.nombre;
            //document.getElementById('txtNombre').value = nombre;
            document.getElementById('txtPrecio').value = item.dataset.precio;
            var imgModal = document.getElementById('imgCuna');
            // Establecer texto arriba model
            document.getElementById('exampleModalLabel').textContent = 'Set de Cuna: ' + nombre;
            // Establecer la URL de la imagen
            imgModal.src = '/images/' + item.dataset.imagen;
            new bootstrap.Modal(document.getElementById('editarModal')).show()
        });
    });
})();
