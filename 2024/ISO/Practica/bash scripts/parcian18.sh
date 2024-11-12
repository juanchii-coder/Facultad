#arreglo con archivos del directorio /etc que terminan en .conf
arreglo=($(find /etc -name "*.conf"))

function cantidad(){
    echo "${#arreglo[@]}"
    return
}

function verArchivos(){
    echo "${arreglo[@]}"
    return
}

function existe(){
    for i in "${arreglo[@]}"; do
        if [ "$i" = "$1" ]; then
            echo "$1 existe en /etc"
            return
        fi
    done
    echo "$1 no existe en /etc"
    return
}

function eliminar(){
    if [ "$2" = "logico" ]; then
    cont=0
        for i in "${arreglo[@]}"; do
            if [ "$i" = "$1" ]; then
                unset "arreglo[$cont]"
                return
            fi
            cont=$((cont + 1))
        done
    elif [ "$2" = "fisico" ]; then
        for i in "${arreglo[@]}"; do
            if [ "$i" = "$1" ]; then
                rm "$i"
                return
            fi
        done
    else
        echo "segundo parametro no es correcto"
    fi
}