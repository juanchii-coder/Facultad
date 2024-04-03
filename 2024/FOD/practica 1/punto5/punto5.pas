program punto5;
type
    celulares= record
        cod:integer;
        nom:string;
        desc:string;
        marca:string;
        precio:real;
        stockMin:integer;
        stockDisp:integer;
    end;

    archivo= file of celulares;

procedure leer(var c:celulares);
begin
    write('codigo: ');
    readln(c.cod);
    if(c.cod<>0)then begin
        write('nombre: ');
        readln(c.nom);
        write('descripcion: ');
        readln(c.desc);
        write('marca: ');
        readln(c.marca);
        write('precio: ');
        readln(c.precio);
        write('stock minimo: ');
        readln(c.stockMin);
        write('stock disponible: ');
        readln(c.stockDisp);
    end;
end;

procedure escribir(var c:celulares);
begin
    write('codigo: ');
    writeln(c.cod);
    write('nombre: ');
    writeln(c.nom);
    write('descripcion: ');
    writeln(c.desc);
    write('marca: ');
    writeln(c.marca);
    write('precio: ');
    writeln(c.precio);
    write('stock minimo: ');
    writeln(c.stockMin);
    write('stock disponible: ');
    writeln(c.stockDisp);

end;

procedure listar(var arch:archivo;i:integer);
var c:celulares;
begin
    reset(arch);
    if (i=1)then begin
        while(not eof(arch))do begin
            read(arch,c);
            if(c.stockDisp<c.stockMin)then
                escribir(c);
        end;
    end
    else begin
        while(not eof(arch))do begin
            read(arch,c);
            if(c.desc<>'')then
                escribir(c);
        end;
    end;
    close(arch);
end;

procedure cargar(var arch:archivo);
var cel:celulares;
begin
    leer(cel);
    While (cel.cod<>0)do begin
        Write(arch,cel);
        leer(cel);
    end;
end;

procedure archTextoExp(var arch:archivo);
var
    celu:text;
    celular:celulares;
begin
    assign(celu,'celulares.txt');
    rewrite(celu);
    while(not eof(arch))do begin
        read(arch,celular);
        writeln(celular.cod,' ',celular.precio,' ',celular.marca);
        writeln(celular.stockDisp,' ',celular.stockMin,' ',celular.desc);
        writeln(celular.nom);
    end;
    close(arch);
end;

procedure agregar(var arch:archivo);
begin
    seek(arch,filesize(arch));
    cargar(arch);
end;

procedure modificarStock(var arch:archivo);
var cel:celulares;num:integer;celDeseado:string;
begin
    Write('que celular deseas modificar el stock?');
    read(celDeseado);
    read(arch,cel);

    while(cel.nom<>celDeseado)do begin
        read(arch,cel);
    end;

    if(cel.nom=celDeseado)then begin
        write('cual es el stock actual?');
        read(num);
        cel.stockDisp:=num;
        seek(arch, filepos(arch)-1);
        write(arch,cel);
    end
    else
    begin
        write('no se ha encontrado ese celular');
    end;
end;

procedure exportarSinStock(var arch:archivo);
var 
    celu:text;
    celular:celulares;
begin
    assign(celu,'sinStock.txt');
    rewrite(celu);
    while(not eof(arch))do begin
        read(arch,celular);
        if(celular.stockDisp=0)then begin
            writeln(celular.cod,' ',celular.precio,' ',celular.marca);
            writeln(celular.stockDisp,' ',celular.stockMin,' ',celular.desc);
            writeln(celular.nom);
        end;
    end;
    close(arch);
end;

procedure main(var arch:archivo;num:integer);
begin
    if(num=1)then 
    begin
        rewrite(arch);
        cargar(arch);
        close(arch);
    end
    else if (num=2) then 
    begin
        listar(arch,1);
    end
    else if (num=3) then
    begin
        listar(arch,2)
    end
    else if (num=4) then
    begin
        reset(arch);
        archTextoExp(arch);
        close(arch);
    end
    else if(num=5) then
    begin
        reset(arch);
        agregar(arch);
        close(arch);
    end
    else if(num=6) then
    begin
        reset(arch);
        modificarStock(arch);
        close(arch);
    end
    else if(num=7) then
    begin
      exportarSinStock(arch);
    end
    else
    begin
        writeln(num,' No es una opcion');
    end;
end;

var
    arch:archivo;
    num:integer;
begin
    assign(arch,'celulares.dat');
    num:=99;
    while(num<>0)do begin
        Writeln('elige algunas de las siguientes opciones: ');
        Writeln('1= crear archivo desordenado');
        Writeln('2= listar datos');
        Writeln('3= listar celulares con descripcion');
        Writeln('4= exportar archivo');
        Writeln('5= añadir otros celulares');
        Writeln('6= modificar stock');
        Writeln('7= exportar celulares sin stock');
        Writeln('0= finalizar');
        readln(num);
        main(arch,num);
    end;
    read();
end.
