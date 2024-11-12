#!/bin/bash

if [ $# -eq 0 ]; then
    echo "Uso: $0 archivo_o_directorio [archivo_o_directorio ...]"
    exit 1
fi

for item in "$@"; do
    if [ -f "$item" ]; then

        echo "Procesando archivo: $item"
        
        gzip -c "$item" > "${item}.gz"
        echo "Archivo '$item' comprimido en '${item}.gz'"

    elif [ -d "$item" ]; then
        echo "Procesando directorio: $item"
        
        if [ -r "$item" ]; then
            tar -czf "${item}.tar.gz" "$item"
            echo "Directorio '$item' empaquetado y comprimido en '${item}.tar.gz'"
        fi

        if [ -w "$item" ]; then
            rm -rf "$item"
            echo "Directorio '$item' eliminado junto con su contenido"
        fi

    else
        echo "'$item' no es un archivo ni un directorio válido."
    fi
done