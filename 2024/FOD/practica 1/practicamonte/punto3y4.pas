program GestionEmpleados;

uses crt;

type
  Empleado = record
    numero: Integer;
    apellido: String[50];
    nombre: String[50];
    edad: Integer;
    dni: String[10];
  end;
  
  ArchivoEmpleados = file of Empleado;

var
  archivo: ArchivoEmpleados;
  nombreArchivo: String;

procedure CrearArchivo(var archivo: ArchivoEmpleados);
var
  empleado: Empleado;
begin
  Rewrite(archivo);
  writeln('Ingrese los datos del empleado (fin en apellido para terminar):');
  with empleado do
  begin
    write('Número: '); readln(numero);
    write('Apellido: '); readln(apellido);
    while apellido <> 'fin' do
    begin
      write('Nombre: '); readln(nombre);
      write('Edad: '); readln(edad);
      write('DNI: '); readln(dni);
      write(archivo, empleado);
      
      write('Número: '); readln(numero);
      write('Apellido: '); readln(apellido);
    end;
  end;
  Close(archivo);
end;

procedure ListarPorNombreApellido(var archivo: ArchivoEmpleados);
var
  empleado: Empleado;
  nombreApellido: String;
begin
  Reset(archivo);
  write('Ingrese el nombre o apellido a buscar: '); readln(nombreApellido);
  while not EOF(archivo) do
  begin
    read(archivo, empleado);
    if (empleado.nombre = nombreApellido) or (empleado.apellido = nombreApellido) then
    begin
      writeln('Número: ', empleado.numero, ', Apellido: ', empleado.apellido, ', Nombre: ', empleado.nombre, ', Edad: ', empleado.edad, ', DNI: ', empleado.dni);
    end;
  end;
  Close(archivo);
end;

procedure ListarTodosLosEmpleados(var archivo: ArchivoEmpleados);
var
  empleado: Empleado;
begin
  Reset(archivo);
  while not EOF(archivo) do
  begin
    read(archivo, empleado);
    writeln('Número: ', empleado.numero, ', Apellido: ', empleado.apellido, ', Nombre: ', empleado.nombre, ', Edad: ', empleado.edad, ', DNI: ', empleado.dni);
  end;
  Close(archivo);
end;

procedure ListarMayoresDe70(var archivo: ArchivoEmpleados);
var
  empleado: Empleado;
begin
  Reset(archivo);
  while not EOF(archivo) do
  begin
    read(archivo, empleado);
    if empleado.edad > 70 then
    begin
      writeln('Número: ', empleado.numero, ', Apellido: ', empleado.apellido, ', Nombre: ', empleado.nombre, ', Edad: ', empleado.edad, ', DNI: ', empleado.dni);
    end;
  end;
  Close(archivo);
end;

procedure AnadirEmpleados(var archivo: ArchivoEmpleados);
var
  empleado: Empleado;
  existe: Boolean;
  temp: Empleado;
begin
  Reset(archivo);
  write('Ingrese los datos del empleado (fin en apellido para terminar):');
  with empleado do
  begin
    write('Número: '); readln(numero);
    while numero <> -1 do
    begin
      write('Apellido: '); readln(apellido);
      write('Nombre: '); readln(nombre);
      write('Edad: '); readln(edad);
      write('DNI: '); readln(dni);
      
      existe := False;
      while not EOF(archivo) do
      begin
        read(archivo, temp);
        if temp.numero = numero then
        begin
          existe := True;
          Break;
        end;
      end;
      
      if not existe then
      begin
        Seek(archivo, FileSize(archivo));
        write(archivo, empleado);
      end
      else
      begin
        writeln('El número de empleado ya está registrado.');
      end;
      
      write('Número: '); readln(numero);
    end;
  end;
  Close(archivo);
end;

procedure ModificarEdad(var archivo: ArchivoEmpleados);
var
  numero, nuevaEdad: Integer;
  encontrado: Boolean;
  empleado: Empleado;
begin
  Reset(archivo);
  write('Ingrese el número del empleado cuya edad desea modificar: ');
  readln(numero);
  encontrado := False;
  while not EOF(archivo) do
  begin
    read(archivo, empleado);
    if empleado.numero = numero then
    begin
      encontrado := True;
      write('Ingrese la nueva edad: ');
      readln(nuevaEdad);
      empleado.edad := nuevaEdad;
      Seek(archivo, FilePos(archivo) - 1);
      write(archivo, empleado);
      Break;
    end;
  end;
  if not encontrado then
    writeln('Empleado no encontrado.');
  Close(archivo);
end;

procedure ExportarATodosEmpleadosTxt(var archivo: ArchivoEmpleados);
var
  archivoTxt: Text;
  empleado: Empleado;
begin
  Reset(archivo);
  Assign(archivoTxt, 'todos_empleados.txt');
  Rewrite(archivoTxt);
  while not EOF(archivo) do
  begin
    read(archivo, empleado);
    writeln(archivoTxt, 'Número: ', empleado.numero, ', Apellido: ', empleado.apellido, ', Nombre: ', empleado.nombre, ', Edad: ', empleado.edad, ', DNI: ', empleado.dni);
  end;
  Close(archivo);
  Close(archivoTxt);
  writeln('Exportación a todos_empleados.txt completada.');
end;

procedure ExportarAFaltaDniEmpleadoTxt(var archivo: ArchivoEmpleados);
var
  archivoTxt: Text;
  empleado: Empleado;
begin
  Reset(archivo);
  Assign(archivoTxt, 'faltaDNIEmpleado.txt');
  Rewrite(archivoTxt);
  while not EOF(archivo) do
  begin
    read(archivo, empleado);
    if empleado.dni = '00' then
      writeln(archivoTxt, 'Número: ', empleado.numero, ', Apellido: ', empleado.apellido, ', Nombre: ', empleado.nombre, ', Edad: ', empleado.edad, ', DNI: ', empleado.dni);
  end;
  Close(archivo);
  Close(archivoTxt);
  writeln('Exportación a faltaDNIEmpleado.txt completada.');
end;

procedure MostrarMenu;
begin
  writeln('Seleccione una opción:');
  writeln('1. Crear archivo de empleados');
  writeln('2. Listar empleados por nombre o apellido');
  writeln('3. Listar todos los empleados');
  writeln('4. Listar empleados mayores de 70 años');
  writeln('5. Añadir empleados');
  writeln('6. Modificar edad de empleados');
  writeln('7. Exportar empleados a todos_empleados.txt');
  writeln('8. Exportar empleados sin DNI a faltaDNIEmpleado.txt');
  writeln('0. Salir');
  writeln;
end;

var
  opcion: Integer;

begin
  write('Ingrese el nombre del archivo de empleados: '); readln(nombreArchivo);
  Assign(archivo, nombreArchivo);
  
  repeat
    clrscr;
    MostrarMenu;
    readln(opcion);
    case opcion of
      1: CrearArchivo(archivo);
      2: ListarPorNombreApellido(archivo);
      3: ListarTodosLosEmpleados(archivo);
      4: ListarMayoresDe70(archivo);
      5: AnadirEmpleados(archivo);
      6: ModificarEdad(archivo);
      7: ExportarATodosEmpleadosTxt(archivo);
      8: ExportarAFaltaDniEmpleadoTxt(archivo);
    end;
    if opcion <> 0 then
    begin
      writeln('Presione una tecla para continuar...');
      readkey;
    end;
  until opcion = 0;
end.
