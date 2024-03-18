{ Realizar un algoritmo, que utilizando el archivo de números enteros no ordenados
creados en el ejercicio 1, informe por pantalla cantidad de números menores a 1500 y el
promedio de los números ingresados. El nombre del archivo a procesar debe ser
proporcionado por el usuario una única vez. Además, el algoritmo deberá listar el
contenido del archivo en pantalla.}

program punto2;
type
    archivo= file of integer;
var
    arch:archivo;
    nombre:string;
    cant,num:integer;
    prom:real;
begin
	cant:=0;
	num:=0;
	prom:=0;
	Writeln('ingresar nombre del archivo: ');
	readln(nombre);
    assign(arch,nombre);
    reset(arch);
    while(not eof(arch))do begin
		read(arch,num);
		if (num<1500)then
			cant:=cant+1;
		prom:=prom+num;
    end;
    prom:=prom/cant;
    writeln('cantidad: ',cant,', promedio: ',prom:2:2);
    close(arch);
end.
