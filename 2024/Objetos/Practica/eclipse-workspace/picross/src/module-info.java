
module picross {
	requires java.desktop;
	requires spring.boot;
    requires spring.boot.autoconfigure;
    requires spring.web;
	exports picross.Controlador;
    exports picross.Modelo;
    exports picross.Vista;
}