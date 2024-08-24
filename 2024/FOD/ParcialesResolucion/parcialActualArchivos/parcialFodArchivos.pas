program JuanchiIntento;

type
  DIA = 1..31;
  MES = 1..12;
  ANO = 1900..2024;

  Fecha = record
    dia: DIA;
    mes: MES;
    ano: ANO;
  end;

  Prestamo = record
    numSucursal: Integer;
    dniEmpleado: Integer;
    numPrestamo: Integer;
    fechaOtorgacion: Fecha;
    monto: Real;
  end;

  ArchivoPrestamos = File of Prestamo;

function extraerAno(f: Fecha): Integer;
begin
  extraerAno := f.ano;
end;

procedure GenerarInforme(var arch: ArchivoPrestamos);
var
  sucursalActual, empleadoActual, ano, cantVentasEmpleado, cantVentasSucursal, cantVentasTotal: Integer;
  montoEmpleado, montoSucursal, montoTotal: Real;
  prestamo: Prestamo;
  archivoTxt: Text;
begin
  reset(arch);
  Assign(archivoTxt, 'informe_ventas.txt');
  Rewrite(archivoTxt);
  
  cantVentasTotal := 0;
  montoTotal := 0;
  sucursalActual := -1;
  empleadoActual := -1;

  writeln(archivoTxt, 'Informe de ventas de la empresa');

  while not EOF(arch) do
  begin
    read(arch, prestamo);

    if prestamo.numSucursal <> sucursalActual then
    begin
      if sucursalActual <> -1 then
      begin
        writeln(archivoTxt, 'Cantidad total de ventas sucursal: ', cantVentasSucursal);
        writeln(archivoTxt, 'Monto total vendido por sucursal: ', montoSucursal:0:2);
        writeln(archivoTxt);
      end;

      sucursalActual := prestamo.numSucursal;
      writeln(archivoTxt, 'Sucursal: ', sucursalActual);
      cantVentasSucursal := 0;
      montoSucursal := 0;
    end;

    if prestamo.dniEmpleado <> empleadoActual then
    begin
      if empleadoActual <> -1 then
      begin
        writeln(archivoTxt, 'Totales       ', cantVentasEmpleado, '        ', montoEmpleado:0:2);
        writeln(archivoTxt);
      end;

      empleadoActual := prestamo.dniEmpleado;
      writeln(archivoTxt, 'Empleado: DNI ', empleadoActual);
      writeln(archivoTxt, 'Año        Cantidad de ventas        Monto de ventas');
      cantVentasEmpleado := 0;
      montoEmpleado := 0;
    end;

    ano := extraerAno(prestamo.fechaOtorgacion);
    writeln(archivoTxt, ano:4, '        ', 1, '        ', prestamo.monto:0:2);

    cantVentasEmpleado := cantVentasEmpleado + 1;
    montoEmpleado := montoEmpleado + prestamo.monto;

    cantVentasSucursal := cantVentasSucursal + 1;
    montoSucursal := montoSucursal + prestamo.monto;

    cantVentasTotal := cantVentasTotal + 1;
    montoTotal := montoTotal + prestamo.monto;
  end;

  writeln(archivoTxt, 'Totales       ', cantVentasEmpleado, '        ', montoEmpleado:0:2);
  writeln(archivoTxt);
  writeln(archivoTxt, 'Cantidad total de ventas sucursal: ', cantVentasSucursal);
  writeln(archivoTxt, 'Monto total vendido por sucursal: ', montoSucursal:0:2);
  writeln(archivoTxt);

  writeln(archivoTxt, 'Cantidad de ventas de la empresa: ', cantVentasTotal);
  writeln(archivoTxt, 'Monto total vendido por la empresa: ', montoTotal:0:2);

  Close(archivoTxt);
  Close(arch);
end;

var
  arch: ArchivoPrestamos;
  nombreArch: String;
begin
  write('Escriba el nombre del archivo: ');
  ReadLn(nombreArch);
  Assign(arch, nombreArch);
  if FileExists(nombreArch) then
  begin
    Reset(arch);
    GenerarInforme(arch);
  end
  else
    writeln('El archivo no existe.');
end.
