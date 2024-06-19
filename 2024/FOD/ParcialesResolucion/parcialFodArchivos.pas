program InformeVentas;

uses SysUtils, crt;

type
  Prestamo = record
    numero: Integer;
    sucursal: Integer;
    dniEmpleado: String[10];
    nombreEmpleado: String[50];
    fechaOtorgacion: String[10];
    monto: Real;
  end;

  ArchivoPrestamos = file of Prestamo;

function extraerAno(fecha: String): Integer;
var
  ano: String;
begin
  ano := Copy(fecha, 7, 4);
  extraerAno := StrToInt(ano);
end;


procedure GenerarInforme(var archivo: ArchivoPrestamos);
var
  prestamo: Prestamo;
  archivoTxt: Text;
  sucursalActual, totalSucursales, totalMontoSucursal: Integer;
  totalVentasEmpresa, totalMontoEmpresa: Integer;
  anoActual, cantidadVentas, montoVentas: Integer;
  dniEmpleadoActual: String;
begin
  Reset(archivo);
  Assign(archivoTxt, 'informe_ventas.txt');
  Rewrite(archivoTxt);
  
  totalVentasEmpresa := 0;
  totalMontoEmpresa := 0;
  sucursalActual := -1;

  while not EOF(archivo) do
  begin
    Read(archivo, prestamo);
    if prestamo.sucursal <> sucursalActual then
    begin
      if sucursalActual <> -1 then
      begin
        writeln(archivoTxt, 'Cantidad total de ventas sucursal: ', totalSucursales);
        writeln(archivoTxt, 'Monto total vendido por sucursal: ', totalMontoSucursal:0:2);
        writeln(archivoTxt);
      end;
      sucursalActual := prestamo.sucursal;
      writeln(archivoTxt, 'Sucursal ', sucursalActual);
      totalSucursales := 0;
      totalMontoSucursal := 0;
    end;

    dniEmpleadoActual := prestamo.dniEmpleado;
    anoActual := extraerAno(prestamo.fechaOtorgacion);
    cantidadVentas := 0;
    montoVentas := 0;

    while (not EOF(archivo)) and (prestamo.sucursal = sucursalActual) and (prestamo.dniEmpleado = dniEmpleadoActual) do
    begin
      cantidadVentas := cantidadVentas + 1;
      montoVentas := montoVentas + prestamo.monto;
      totalSucursales := totalSucursales + 1;
      totalMontoSucursal := totalMontoSucursal + prestamo.monto;
      totalVentasEmpresa := totalVentasEmpresa + 1;
      totalMontoEmpresa := totalMontoEmpresa + prestamo.monto;

      if not EOF(archivo) then
        Read(archivo, prestamo);
    end;

    writeln(archivoTxt, 'Empleado: DNI ', dniEmpleadoActual);
    writeln(archivoTxt, 'Año ', anoActual, ' Cantidad de ventas: ', cantidadVentas, ' Monto de ventas: ', montoVentas:0:2);
    writeln(archivoTxt, 'Totales Empleado: ', cantidadVentas, ' ', montoVentas:0:2);
    writeln(archivoTxt);
  end;

  writeln(archivoTxt, 'Cantidad total de ventas de la empresa: ', totalVentasEmpresa);
  writeln(archivoTxt, 'Monto total vendido por la empresa: ', totalMontoEmpresa:0:2);

  Close(archivo);
  Close(archivoTxt);
end;


function extraerAno(fecha: String): Integer;
var
  ano: String;
begin
  ano := Copy(fecha, 7, 4);
  extraerAno := StrToInt(ano);
end;

procedure GenerarInforme(var archivo: ArchivoPrestamos);
var
  prestamo: Prestamo;
  archivoTxt: Text;
  sucursalActual, totalSucursales, totalMontoSucursal: Integer;
  totalVentasEmpresa, totalMontoEmpresa: Integer;
  anoActual, cantidadVentas, montoVentas: Integer;
  dniEmpleadoActual: String;
begin
  Reset(archivo);
  Assign(archivoTxt, 'informe_ventas.txt');
  Rewrite(archivoTxt);
  
  totalVentasEmpresa := 0;
  totalMontoEmpresa := 0;
  sucursalActual := -1;

  while not EOF(archivo) do
  begin
    Read(archivo, prestamo);
    if prestamo.sucursal <> sucursalActual then
    begin
      if sucursalActual <> -1 then
      begin
        writeln(archivoTxt, 'Cantidad total de ventas sucursal: ', totalSucursales);
        writeln(archivoTxt, 'Monto total vendido por sucursal: ', totalMontoSucursal:0:2);
        writeln(archivoTxt);
      end;
      sucursalActual := prestamo.sucursal;
      writeln(archivoTxt, 'Sucursal ', sucursalActual);
      totalSucursales := 0;
      totalMontoSucursal := 0;
    end;

    dniEmpleadoActual := prestamo.dniEmpleado;
    anoActual := extraerAno(prestamo.fechaOtorgacion);
    cantidadVentas := 0;
    montoVentas := 0;

    while (not EOF(archivo)) and (prestamo.sucursal = sucursalActual) and (prestamo.dniEmpleado = dniEmpleadoActual) do
    begin
      cantidadVentas := cantidadVentas + 1;
      montoVentas := montoVentas + prestamo.monto;
      totalSucursales := totalSucursales + 1;
      totalMontoSucursal := totalMontoSucursal + prestamo.monto;
      totalVentasEmpresa := totalVentasEmpresa + 1;
      totalMontoEmpresa := totalMontoEmpresa + prestamo.monto;

      if not EOF(archivo) then
        Read(archivo, prestamo);
    end;

    writeln(archivoTxt, 'Empleado: DNI ', dniEmpleadoActual);
    writeln(archivoTxt, 'Año ', anoActual, ' Cantidad de ventas: ', cantidadVentas, ' Monto de ventas: ', montoVentas:0:2);
    writeln(archivoTxt, 'Totales Empleado: ', cantidadVentas, ' ', montoVentas:0:2);
    writeln(archivoTxt);
  end;

  writeln(archivoTxt, 'Cantidad total de ventas de la empresa: ', totalVentasEmpresa);
  writeln(archivoTxt, 'Monto total vendido por la empresa: ', totalMontoEmpresa:0:2);

  Close(archivo);
  Close(archivoTxt);
end;

var
  archivo: ArchivoPrestamos;
  nombreArchivo: String;
begin
  write('Ingrese el nombre del archivo de préstamos: ');
  readln(nombreArchivo);
  Assign(archivo, nombreArchivo);

  GenerarInforme(archivo);

  writeln('Informe generado con éxito.');
end.

{Explicación del Código:
Estructura de Datos:

Prestamo: Define los campos necesarios para cada registro de préstamo.
ArchivoPrestamos: Tipo de archivo para manejar registros de préstamos.
Función extraerAno:

Extrae el año de una fecha en formato DD/MM/AAAA.
Procedimiento GenerarInforme:

Lee el archivo de préstamos y genera un informe agrupado por sucursal y empleado.
Calcula y muestra totales por sucursal y para toda la empresa.
Genera un archivo de texto con el informe.
Procedimiento Principal:

Solicita el nombre del archivo de préstamos.
Llama al procedimiento GenerarInforme para procesar el archivo y generar el informe.
Con este programa, deberías poder generar el informe requerido de manera efectiva. Si tienes alguna pregunta o necesitas más detalles, no dudes en preguntar.
}