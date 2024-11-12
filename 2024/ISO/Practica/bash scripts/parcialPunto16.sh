#!/bin/bash

# Inicialización del arreglo de usuarios
usuarios=("$@")

# Función para verificar si un usuario existe en el arreglo
existe() {
    local usuario=$1
    for u in "${usuarios[@]}"; do
        if [ "$u" == "$usuario" ]; then
            return 0  # El usuario existe
        fi
    done
    return 1  # El usuario no existe
}

# Función para eliminar un usuario del arreglo
eliminar_usuario() {
    local usuario=$1
    if existe "$usuario"; then
        # Crear un nuevo arreglo sin el usuario a eliminar
        usuarios=("${usuarios[@]/$usuario}")
        echo "Usuario '$usuario' eliminado."
    else
        echo "Error: Usuario '$usuario' no encontrado."
        return 100  # Código de error si el usuario no existe
    fi
}

# Función para buscar usuarios que contengan un patrón en su nombre
usuarios_con_patron() {
    local patron=$1
    local encontrados=()
    for u in "${usuarios[@]}"; do
        if [[ "$u" == *"$patron"* ]]; then
            encontrados+=("$u")
        fi
    done
    
    if [ ${#encontrados[@]} -eq 0 ]; then
        echo "No se encontraron usuarios con el patrón '$patron'."
        return 102  # Código de error si no se encontró ningún usuario con el patrón
    else
        echo "Usuarios que contienen el patrón '$patron': ${encontrados[@]}"
    fi
}

# Función para imprimir la cantidad de usuarios en el arreglo
cantidad() {
    local total=${#usuarios[@]}
    if [ "$total" -eq 0 ]; then
        echo "No hay usuarios en el arreglo."
        return 95  # Código de error si el arreglo está vacío
    else
        echo "Cantidad total de usuarios: $total"
    fi
}

# Función para listar todos los usuarios en el arreglo
usuarios() {
    if [ ${#usuarios[@]} -eq 0 ]; then
        echo "No hay usuarios en el arreglo."
        return 95  # Código de error si el arreglo está vacío
    else
        echo "Usuarios en el arreglo: ${usuarios[@]}"
    fi
}

# Ejecución de las funciones de prueba
# Llamadas a las funciones para verificar su funcionamiento
echo "Probando la función cantidad:"
cantidad

echo "Probando la función usuarios:"
usuarios

echo "Probando la función existe con 'usuario1':"
existe "usuario1" && echo "El usuario 'usuario1' existe en el arreglo." || echo "El usuario 'usuario1' no existe en el arreglo."

echo "Probando la función eliminar_usuario con 'usuario2':"
eliminar_usuario "usuario2"

echo "Probando la función usuarios_con_patron con 'adm':"
usuarios_con_patron "adm"
