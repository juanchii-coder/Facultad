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

procedure leer(var c:celulares);
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
        while(nor eof(arch))do begin
            read(arch,c)
            if(c.stockDisp<c.stockMin)then
                escribir(c);
        end;
    end
    else begin
        while(nor eof(arch))do begin
            read(arch,c)
            if(c.desc<>'')then
                escribir(c);
        end;
    end;
    close(arch);
end;

procedure cargar(var arch:archivo);
var cel:celulares;
begin
    rewrite(arch);
    leer(cel);
    While (cel.cod<>0)do begin
        Write(arch,cel);
        leer(cel);
    end;
    close(arch);
end;

procedure main(var arch:archivo;num:integer);
begin
    if(num=1)then 
    begin
        cargar(arch);
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

        close(arch);
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
    assign(arch,'celulares.txt')
    Writeln('elige algunas de las siguientes opciones: ');
    Writeln('1= crear archivo desordenado');
    Writeln('2= listar datos');
    Writeln('3= listar celulares con descripcion');
    Writeln('4= exportar archivo');
    readln(num);
    main(arch,num);
end.
