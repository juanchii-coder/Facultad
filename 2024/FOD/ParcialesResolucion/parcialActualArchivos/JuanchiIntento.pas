//tengo un archivo con prestamos de una empresa financiera con varias sucursales
//un prestamo= una venta
//archivo ordenado por los siguientes criterios numSucursal, dniEmpleado, fechaOtorgacion
//escibir un modulo que escriba enun archivo de texto:
{
Informe de ventas de la empresa

  Sucursal <número sucursal>

      Empleado: DNI <DNI empleado>
        Año            Cantidad de ventas              Monto de ventas
        ......         ................                ..............
        ......
        Totales        <Total ventas empleado>         <Monto total empleado>

      Empleado: DNI <DNI empleado>...
        ...

    Cantidad total de ventas sucursal: ..........
    Monto total vendido por sucursal: ...........

  Sucursal <número sucursal>...
    ...
cantidad de ventas de la empresa: ........
monto total vendido por la empresa: ......
}
program JuanchiIntento;
type
  DIA=1..31;
  MES=1..12;
  ANO=1900..2024;

  Fecha=record
    dia:DIA;
    mes:MES;
    ano:ANO;
  end;
  Prestamo=record
    numSucursal:Integer;
    dniEmpleado:Integer;
    numPrestamo:Integer;
    fechaOtorgacion:Fecha;
    monto:Real;
  end;
  ArchivoPrestamos=File of Prestamo;

function extraerAno(f: fecha): Integer;
begin
  extraerAno := f.ano;
end;

procedure GenerarInforme(var arch:ArchivoPrestamos);
var
  ano,sucursalActual,empleadoActual,cantVentasEmpleado,cantVentasSucursal,cantVentasTotal:Integer;
  montoEmpleado,montoSucursal,montoTotal:Real;
  prestamo:Prestamo;
  archivoTxt: Text;
begin
  reset(arch);
  Assign(archivoTxt,'archivo.txt');
  rewrite(archivoTxt);

  cantVentasTotal:= 0;
  montoTotal:= 0;
  sucursalActual:=0;
  empleadoActual:=0;
  cantVentasSucursal:=0;
  montoSucursal:=0;
  cantVentasEmpleado:=0;
  montoEmpleado:=0;

  write(archivoTxt,'informe de ventas de la empresa');

  While(not EOF(arch))do begin
    read(arch,prestamo);

    if(prestamo.numSucursal<>sucursalActual)then
    begin
      //-1 significa que se cambio de sucursal
      if(sucursalActual=-1)then
      begin
        //escribo los totales
        writeln(archivoTxt,'cantidad total de ventas sucursal: ', cantVentasSucursal);
        writeln(archivoTxt,'cantidad total vendido por sucursal: ', montoSucursal);
      end;
      sucursalActual:=prestamo.numSucursal;
      Writeln(archivoTxt,'sucursal: ',prestamo.numSucursal);
      cantVentasSucursal:=0;
      montoSucursal:=0;
    end;

    while((not EOF(arch))and(prestamo.numSucursal<>sucursalActual))do
    begin
      if(empleadoActual<>prestamo.dniEmpleado)then
      begin
        if(empleadoActual=-1)then 
        begin
          writeln(archivoTxt,'Totales','        ',cantVentasEmpleado,'        ',montoEmpleado);
          writeln(archivoTxt,'');
        end;
        writeln(archivoTxt,'Empleado: DNI ', prestamo.dniEmpleado);
        writeln(archivoTxt,'anio','        ','cantidad de ventas','        ','Monto de ventas');
        //fin o comienzo de empleado, actualizo empleado actual
        empleadoActual:=prestamo.dniEmpleado;
        cantVentasEmpleado:=0;
        montoEmpleado:=0;
      end;
      //actualizo total de empleado
      cantVentasEmpleado:=cantVentasEmpleado+1;
      montoEmpleado:=montoEmpleado+prestamo.monto;
      
      ano:=extraerAno(prestamo.fechaOtorgacion);
      writeln(archivoTxt,ano,'       ',prestamo.numPrestamo,'        ',prestamo.monto);
      //actualizo el total de la sucursal
      cantVentasSucursal:=cantVentasSucursal+1;
      montoSucursal:=montoSucursal+prestamo.monto;
      //actualizo el total de la empresa
      cantVentasTotal:=cantVentasTotal+1;
      montoTotal:=montoTotal+prestamo.monto;
      //leo otro prestamo
      read(arch,prestamo);
    end;
    //fin da la sucursal, informo los totales reseteo y sucursal =-1
    writeln(archivoTxt,'Totales','        ',cantVentasSucursal,'        ',montoSucursal);
    writeln(archivoTxt,'');
    sucursalActual:=-1;
  end;
  writeln(archivoTxt,'cantidad total de ventas sucursal: ',cantVentasTotal);
  writeln(archivoTxt,'monto total vendido por sucursal: ',montoTotal);
  close(arch);
  close(archivoTxt);
end;

procedure CargarArchivo(var arch: ArchivoPrestamos);
var
  prestamo: Prestamo;
  dia, mes, ano: Integer;
  sucursal, empleado, prestamoNum: Integer;
begin
  Rewrite(arch);

  for sucursal := 1 to 3 do
  begin
    for empleado := 1 to 3 do
    begin
      for prestamoNum := 1 to 3 do
      begin
        prestamo.numSucursal := sucursal;
        prestamo.dniEmpleado := empleado * 1000 + prestamoNum; // Genera un DNI ficticio
        prestamo.numPrestamo := prestamoNum;
        dia := Random(28) + 1;
        mes := Random(12) + 1;
        ano := 2022 + Random(3); // Años 2022, 2023, 2024
        prestamo.fechaOtorgacion.dia := dia;
        prestamo.fechaOtorgacion.mes := mes;
        prestamo.fechaOtorgacion.ano := ano;
        prestamo.monto := Random * 10000; // Monto aleatorio entre 0 y 10000

        Write(arch, prestamo);
      end;
    end;
  end;

  Close(arch);
end;

var
arch:ArchivoPrestamos;
begin
  Assign(arch,'juan.data');
  CargarArchivo(arch);//se dispone
  GenerarInforme(arch);
end.
