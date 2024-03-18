{Realizar un algoritmo que cree un archivo de números enteros no ordenados y permita
incorporar datos al archivo. Los números son ingresados desde teclado. El nombre del
archivo debe ser proporcionado por el usuario desde teclado. La carga finaliza cuando
se ingrese el número 30000, que no debe incorporarse al archivo.}

program punto1;
type
    archivo= file of integer;
var
    arch:archivo;
    nombre:string;
    num:integer;
begin
	writeln('escribi un nombre de archivo');
	readln(nombre);
	assign(arch,nombre);
	rewrite(arch);
    writeln('ola escribi numeros!');
    readln(num);
    while (num<>30000) do begin
		write(arch,num);
		readln(num);
    end;
    close(arch);
end.
