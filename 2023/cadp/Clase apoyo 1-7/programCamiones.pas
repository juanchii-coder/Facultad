program camiones;
const
    DF = 100;
type
    rango= 1..DF;
    camion = record
        patente: string;
        anioFabricacion: integer;
        capacidad: real;    
    end;

    vCamiones = array [rango] of camion;

    viaje = record
        codigo: integer;
        codCamion: rango;
        distancia: real;
        destino: string;
        anio:integer;
        dni:integer;
    end;

    lista = ^nodo
    nodo = record
        dato: viaje;
        sig: lista;
    end;

    procedure leerCamiones(var c: camion);{se dispone}
    procedure cargarVCamiones(var vC: vCamiones);{se dispone}

    procedure leerViaje(var v: viaje);
    begin
        readln(v.codigo);
        if(v.codigo <> -1) then begin
            readln(v.codCamion);
            readln(v.distancia);
            readln(v.destino);
            readln(v.anio);
            readln(v.dni);
        end;
    end;

    procedure agregarOrdenado(var L:lista; v: viaje);
    var
        nue,act,ant: lista;
    begin
        new(nue);
        nue^.dato:= v;
        act:= L;
        ant:= L;
        while(act <> nil) and (v.codCamion > act^.dato.codCamion) do begin
            ant:= act;
            act:= act^.sig;
        end;
        if(act = ant) then
            L:= nue;
        else
            ant^.sig:= nue;
        end;
        nue^sig:= act;
    end;

    procedure cargarViajes(var L:lista);
    var
        v: viaje;
    begin
        leerViaje(v);
        while(v.codigo <> -1)do begin
            agregarOrdenado(L,v);
            leerViaje(v);
        end;
    end;

    procedure sacarMaximoMinimo(kmTotales:real; var patenteMax,patenteMin: string; var max,min: real; patenteAct:string);
    begin
        if(kmTotales > max) then begin
            patenteMax:= patenteAct;
            max:= kmTotales
        end;
        if(kmTotales < min) then begin
            patenteMin:= patenteAct;
            min:= kmTotales
        end;
    end;

    function cumpleDNI(dni:integer):boolean;
    var
        dig: integer;
        ok: boolean;
    begin
        ok:= true;
        while(dni <> 0) and (ok)  do begin
            dig:= dni mod 10;
            if(dig mod 2 = 0) then
                ok:= false
            dni:= dni div 10;
        end;
        cumpleDNI:= ok;
    end;

    procedure recorrerViajesProcesando(L: lista; vC: vCamiones);
    var
        kmTotales,max,min: real;
        patenteMax,patenteMin,patenteAct:string;
        cantViajes,codCamionAct: integer;
    begin
        max:=-1;
        min:= 99999;
        cantViajes:=0;
        while(L <> nil) do begin
            codCamionAct:= L^.dato.codCamion;
            patenteAct:= vC[L^.dato.codCamion].patente;
            kmTotales:= 0;
            while( L<> nil) and( L^.dato.codCamion = codCamionAct) do begin
                kmTotales:= kmTotales + L^.dato.distancia;
                if( vC[L^.dato.codCamion].capacidad > 30,5 ) and ((L^.dato.anio - vC[L^.dato.codCamion].anioFabricacion) > 5) then
                    cantViajes:= cantViajes + 1;
                if(cumpleDNI(L^.dato.dni))then
                    writeln(L^.dato.codigo)
                L:=L^.sig;
            end;
            sacarMaximoMinimo(kmTotales, patenteMax, patenteMin, max, min, patenteAct);
        end;
        writeln('La cantidad de viajes con camiones con capacidad > 30,5 y antiguedad > 5 son: ', cantViajes);
        writeln('La patende del camion que más kilometros recorrió es: ', patenteMax, 'y la patente del que menos recorrió es: ', patenteMin)
    end;
var
    L:lista;
begin
    L:=nil;
    cargarVCamiones(vC);{se dispone}
    cargarViajes(L);
    recorrerViajesProcesando(L, vC);
end;