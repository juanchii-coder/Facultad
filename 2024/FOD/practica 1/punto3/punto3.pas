program punto3;
type
	empleado=record
		num:integer;
		apellido:string;
		nombre:string;
		edad:integer;
		dni:integer;
	end;
	
    archivo= file of empleado;
procedure leer(var emple:empleado);
begin
	Writeln('apellido: ');
	readln(emple.apellido);
	if (emple.apellido<>'fin') then begin
		Writeln('numero de empleado: ');
		readln(emple.num);
		Writeln('nombre: ');
		readln(emple.nombre);
		Writeln('edad: ');
		readln(emple.edad);
		Writeln('dni: ');
		readln(emple.dni);
	end;
end;

procedure listar(emple:empleado);
begin
	Writeln('EMPLEADO NUMERO: ',emple.num);
	Writeln('APELLIDO: ',emple.apellido);
	Writeln('NOMBRE: ',emple.nombre);
	Writeln('EDAD: ',emple.edad);
	Writeln('DNI: ',emple.dni);
	Writeln('>--------------------------------------<');
end;

procedure listarDatos(emple:empleado);
begin 
	Writeln('toString;');
	Writeln('-Empleado ',emple.apellido,' ',emple.nombre,' tiene ',emple.edad,' años');
end;

procedure listarEmpleados(emple:empleado);
begin 
	Writeln('datos completos');
	listar(emple);
end;

procedure listarJubilados(emple:empleado);
begin 
	if(emple.edad>=70)then begin
		Writeln('jubilado;');
	end;
end;

var
    arch:archivo;
    opcion:integer;
    emple:empleado;
begin
	assign(arch,'empleados.dat');
    writeln('opcion 1 o 2');
    readln(opcion);
    if(opcion =1)then begin
		rewrite(arch);
		leer(emple);
		while (emple.apellido<>'fin')do begin
			write(arch,emple);
			leer(emple);
		end;
		close(arch);
    end
    else if (opcion = 2) then begin
		reset(arch);
		while (not eof(arch)) do begin
			read(arch, emple);
			listarDatos(emple);
			listarJubilados(emple);
			listarEmpleados(emple);
		end;
		close(arch);
    end
    else
		writeln('no existe esa opcion');
end.
