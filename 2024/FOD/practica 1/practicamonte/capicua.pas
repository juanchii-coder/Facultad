program capicua;
var
  num1,num2,digito,revez:integer;
begin
  read(num1);
  revez:=0;
  num2:=num1;
  while(num2<>0) do begin
  digito:=num2 mod 10;
  revez:=(revez*10)+digito;
  num2:=num2 div 10;
  end;
  if(num1=revez)then
    writeln('capicua');
end.
