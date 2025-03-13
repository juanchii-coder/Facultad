const mensaje= document.getElementById('mensajeError');
const formulario= document.getElementById('formulario');
const boton1= document.getElementById('estilo1');
const boton2= document.getElementById('estiloContraste');
const linkEstilo= document.getElementById('estilo');

formulario.addEventListener('submit', function (event){

    event.preventDefault();

    const nombre= document.getElementById('nombre').value;
    const apellido= document.getElementById('apellido').value;
    const email= document.getElementById('email').value;
    const fecha= document.getElementById('fecha').value;
    const pais= document.getElementById('pais').value;

    mensaje.innerHTML = '';
    mensaje.style.color= 'red';

    if (nombre.length<2){
        mensaje.innerHTML += 'El Nombre no es valido. <br>';
    }
    if (apellido.length<2){
        mensaje.innerHTML += 'El Apellido no es valido. <br>';
    }
    if (!email.includes('@') || !email.includes('.com')){
        mensaje.innerHTML += 'El Email no es valido. <br>';
    }
    if (!fecha){
        mensaje.innerHTML += 'Ingresar una Fecha. <br>';
    }
    if (!pais){
        mensaje.innerHTML += 'Ingresar un Pais. <br>';
    }
});

boton1.addEventListener('click', function () {
    linkEstilo.href= 'estilo.css';
});
boton2.addEventListener('click', function () {
    linkEstilo.href= 'estilo-altoContraste.css';
});
